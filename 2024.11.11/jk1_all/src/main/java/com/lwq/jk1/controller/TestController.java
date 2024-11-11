package com.lwq.jk1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "@Api(tags=\"hello\")")
@RestController
@RequestMapping("/node7788")
@Slf4j
public class TestController {

    @ApiOperation(value = " @ApiOperation(value = \"hehe\")")
    @GetMapping("/hehe")
    public Object hehe() {

        return "hehe";
    }

    @ApiOperation(value = "hehe2")
    @GetMapping("/hehe2")
    public Object hehe2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "hehe";
    }

}
