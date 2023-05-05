package ru.home.springbootapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.home.security.WebSecurityConfigBase;

@SpringBootApplication(scanBasePackages = "ru.home")
public class Main {
    @Autowired
    WebSecurityConfigBase webSecurityConfigBase;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
