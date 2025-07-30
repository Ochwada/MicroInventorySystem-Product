package com.ochwada.product;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * *******************************************************
 * Package: com.ochwada.product
 * File: ProductServiceApplication.java
 * Author: Ochwada
 * Date: Wednesday, 30.Jul.2025, 9:25 AM
 * Description: Main entry point for the Product Service Application
 * *******************************************************
 */

@SpringBootApplication
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }


    static {
        // Load environment variables from .env file
        // Ignores file if missing (useful for production environments like Heroku)
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        // List of expected keys to load from the .env file
        String[] envVars =
                {
                        "POSTGRES_PASSWORD",
                        "INVENTORY_SERVICE_URL"
                };
        // Iterate through keys and set them as JVM system properties if found
        for (String key : envVars) {
            String value = dotenv.get(key);

            if (value != null) {
                System.setProperty(key, value);  // Makes it accessible via System.getProperty
                System.out.println("✅ " + key + " loaded and set.");
            } else {
                System.out.println("⚠️" + key + " not found in .env file. Skipping System.");
            }
        }
    }
}
