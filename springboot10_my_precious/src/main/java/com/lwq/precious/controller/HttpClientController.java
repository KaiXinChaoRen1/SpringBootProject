package com.lwq.precious.controller;

import com.lwq.precious.utils.HttpClientUtils;
import com.lwq.precious.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * HttpClientUtils主要用来调用一些第三方的接口(例如微信支付接口等)
 */
@RestController
@RequestMapping("/http")
public class HttpClientController {

    @GetMapping("test3")
    public void name3(HttpServletResponse response){
        ResponseUtils.write(response,"hehe");
    }


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
