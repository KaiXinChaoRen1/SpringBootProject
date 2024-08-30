package com.lwq.feign.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.feign.feignInterface.heheClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "your_controller_配置knife4j包扫描")
@RestController
@RequestMapping("/feignTest")
@Slf4j
public class TestController {

    @Autowired
    private heheClient heheClient;

    @ApiOperation(value = "hehe")
    @PostMapping("/hehe")
    public Object hehe(Integer num) {

        return heheClient.add2(num);
    }

    @ApiOperation(value = "testBody")
    @PostMapping("/testBody")
    public Object testBody(@RequestBody HashMap<String, String> map) {

        return heheClient.add(map);
    }

}
