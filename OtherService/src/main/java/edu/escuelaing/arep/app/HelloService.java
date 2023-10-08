package edu.escuelaing.arep.app;

import static spark.Spark.*;

public class HelloService {

    private static URLReader urlReader = new URLReader();

    public static void main(String... args) {
        port(getPort());
        staticFiles.location("/public");
        secure("keystore/ecikeystore.p12", "123456", null, null);
        get("/hello", (req, res) -> "Hello Docker");
        urlReader.readURL("https://localhost:5000/hello");
    }

    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}