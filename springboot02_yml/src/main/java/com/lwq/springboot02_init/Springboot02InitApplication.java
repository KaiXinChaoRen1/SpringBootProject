package com.lwq.springboot02_init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Springboot02InitApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Springboot02InitApplication.class, args);

    }


}
