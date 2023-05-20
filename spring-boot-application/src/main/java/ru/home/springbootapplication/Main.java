package ru.home.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.home")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
