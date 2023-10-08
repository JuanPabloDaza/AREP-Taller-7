package edu.escuelaing.arep.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class HelloService {

    private static URLReader urlReader = new URLReader();
    private static Map<String, String> userdata = new HashMap<>();

    public static void main(String... args) {
        port(getPort());
        staticFiles.location("/public");
        secure("keystore/ecikeystore.p12", "123456", null, null);
        userdata.put("juan", "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");

        get("/hello", (req, res) -> "Hello Docker");

        get("/", (req, res) -> {
            res.redirect("/login.html");
            return null;
        });

        get("/login", (req, res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            if (authenticateUser(username, password)) {
                res.redirect("/welcome.html", 200);
                return null; // La redirección se encargará de la respuesta
            } else {
                res.status(401);
                System.out.println(res.raw().toString()); 
                return "Incorrect username or password";
            }
        });

        get("/signUp", (req, res) -> {
            res.redirect("/signUp.html", 200);
            return null;
        });

        get("/signedUp", (req,res) -> {
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            signUpUser(username, password);
            res.redirect("/login.html", 200);
            return null;
        });
    }

    private static void signUpUser(String username, String password){
        userdata.put(username, password);
    }

    private static boolean authenticateUser(String username, String password){
        if(userdata.containsKey(username)){
            String storedPassword = userdata.get(username);
            return storedPassword.equals(password);
        }else{
            return false;
        }
    }

    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}