package com.lwq.your_name2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "your_controller_配置knife4j包扫描")
@RestController
@RequestMapping("/timer")
@Slf4j
public class TestController {

    @ApiOperation(value = "hehe")
    @GetMapping("/hehe")
    public Object hehe() {

        return "hehe";
    }

}
