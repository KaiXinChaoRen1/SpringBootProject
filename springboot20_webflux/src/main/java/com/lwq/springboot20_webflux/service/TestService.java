package com.lwq.springboot20_webflux.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {


    public String serviceMethod1(){
        return "我是serviceMethod111111执行结果";
    }

    public String serviceMethod2(){
        return "我是serviceMethod222222执行结果";
    }
    
}
