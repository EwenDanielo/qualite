package com.example.qualite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class QualiteApplication {

    public static void main(String[] args) {
        if (System.getenv("POSTGRES_USER") == null) {
            Dotenv dotenv = Dotenv.load();
            System.setProperty("POSTGRES_USER", dotenv.get("POSTGRES_USER"));
            System.setProperty("POSTGRES_PASSWORD", dotenv.get("POSTGRES_PASSWORD"));
            System.setProperty("POSTGRES_DB", dotenv.get("POSTGRES_DB"));
            System.setProperty("POSTGRES_PORT", dotenv.get("POSTGRES_PORT"));
        }

        SpringApplication.run(QualiteApplication.class, args);
    }
}

