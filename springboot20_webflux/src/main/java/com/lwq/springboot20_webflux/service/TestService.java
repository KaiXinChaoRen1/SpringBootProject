package com.lwq.springboot20_webflux.service;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class TestService {


    public  Mono<String> serviceMethod1(){
        return Mono.just("我是serviceMethod111111执行结果");
    }

    public  Mono<String> serviceMethod2(){
        return Mono.just("我是serviceMethod22222222222222执行结果");
    }
    
}
