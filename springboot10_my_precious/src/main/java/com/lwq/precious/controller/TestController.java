package com.lwq.precious.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String name() {
        System.out.println("test执行了");
        return "我家大门常打开";
    }

    @GetMapping("/test2")
    public String name2() {
        System.out.println("test2执行了");
        return "我家大门常打开";
    }

    /**
     * 测试 return 与try catch
     */
    @GetMapping("/test3")
    public String name3() {
        try {
            System.out.println("我执行了");
            // int i = 1 / 0;
            return "我家大门常打开";
        } catch (Exception e) {
            e.printStackTrace();
            //return "111";
        }
        return "2222222";       //看上去和111差不多

    }
}
