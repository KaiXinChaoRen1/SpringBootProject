package com.lwq.service2;

import org.springframework.stereotype.Service;

import com.lwq.annotation.LWQJudgment;

@Service
public class TestService2 {

    @LWQJudgment
    public void method3(Object object) {
        System.out.println("参数是" + object);

    }
}
