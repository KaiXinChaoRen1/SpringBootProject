package com.lwq.springboot11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot11.service.MyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "线程")
@RestController
public class ThreadTestController {

    @Autowired
    MyService myService;

    @ApiOperation(value = "测试线程停止并重新开始")
    @GetMapping("/test1")
    public String hehe1(String name) {

        myService.startDancing(name);

        return "执行完毕";
    }

    @ApiOperation(value = "测试controller层的synchronized (会锁住)")
    @GetMapping("/test2")
    public synchronized String test2() throws InterruptedException {

        Thread.sleep(5000);

        return "1执行完毕";
    }

    @ApiOperation(value = "测试controller层的synchronized2 (会锁住)")
    @GetMapping("/test3")
    public synchronized String test3() throws InterruptedException {

        return "2执行完毕";
    }

}
