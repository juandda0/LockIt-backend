package org.juannn.lockit;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;

@SpringBootApplication
public class LockItApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockItApplication.class, args);
    }

}
