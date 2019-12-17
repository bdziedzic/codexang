package com.codexabra.coop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CoopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoopApplication.class, args);
    }

}
