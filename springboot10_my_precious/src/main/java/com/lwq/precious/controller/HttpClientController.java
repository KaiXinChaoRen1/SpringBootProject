package com.lwq.precious.controller;

import com.lwq.precious.utils.HttpClientUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/http")
public class HttpClientController {

    @GetMapping("test1")
    public String name1(){
        System.out.println("方法执行了");
        return "hehe";
    }

    @GetMapping("test2")
    public String name2() throws IOException, ParseException {

        HttpClientUtils client = new HttpClientUtils("http://localhost:8080/http/test1");

        //client.setHttps(true);//支持https

        client.get();

        return "调用其他接口返回"+client.getContent();
    }



}
