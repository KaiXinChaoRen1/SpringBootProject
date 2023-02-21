package com.lwq.service;

import org.springframework.stereotype.Service;

import com.lwq.annotation.LWQJudgment;

@Service
public class TestService {



    public void method2(){
        System.out.println("我是一个强大的功能,看到我,就证明我完成了我的使命");
        throw new RuntimeException("我是异常,嘻嘻嘻~");        //这里发现RuntimeException不需要在方法上面声明
    }

    public void method1(){
        System.out.println("我是一个强大的功能,看到我,就证明我完成了我的使命");
    }

    

}
