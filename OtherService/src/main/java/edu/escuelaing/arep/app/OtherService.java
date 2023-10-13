package edu.escuelaing.arep.app;

import static spark.Spark.*;

public class OtherService {

    private static URLReader urlReader = new URLReader();

    public static void main(String... args) {
        port(getPort());
        staticFiles.location("/public");
        secure("keystore/ecikeystore.p12", "123456", null, null);
        get("/hello", (req, res) -> {
            res.redirect("index.html");
            return null;
        });
    }

    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }
}