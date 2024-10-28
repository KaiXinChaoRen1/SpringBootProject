package com.lwq.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableFeignClients
public class MasterServer {

    public static void main(String[] args) {
        SpringApplication.run(MasterServer.class, args);

    }

}
