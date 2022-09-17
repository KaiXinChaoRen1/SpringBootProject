package com.lwq.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TeseController {


    @GetMapping("/hello")
    public String test01(){
        return "hello world";
    }

    @GetMapping("/index")
    public String test02(){
        return "hello index";
    }


}
