package com.lwq.springboot11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot11.service.MyService;
import com.lwq.springboot11.service.TimerTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "Time测试")
@RestController
@RequestMapping("/timer")
@Slf4j
public class TimerController {

    @Autowired
    TimerTestService timerTestService;

    @ApiOperation(value = "开启一个timer执行任务")
    @GetMapping("/test1")
    public String hehe1() {

        timerTestService.timerRun();

        return "success";
    }

    @ApiOperation(value = "Run2开启一个timer执行任务,(如果已经开启了,则关闭后重新开启))")
    @GetMapping("/test2")
    public String hehe2() {

        timerTestService.timerRun2();

        return "success";
    }

    @ApiOperation(value = "stop Run2开启一个timer执行任务,(如果已经开启了,则关闭后重新开启))")
    @GetMapping("/test3")
    public String test3() {

        timerTestService.stopRun2();

        return "success";
    }
}
