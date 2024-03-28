package com.lwq.springboot11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    MyService myService;


    @GetMapping("/")
    public String hehe1() {

        myService.startDancing();

        return "heh";
    }




}
