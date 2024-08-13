package com.lwq.springboot02_init.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hahah")
    public String hehe1() {
        return "";
    }
}
