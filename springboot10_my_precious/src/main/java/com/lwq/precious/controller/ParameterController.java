package com.lwq.precious.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.precious.model.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "参数测试")
@RestController
@RequestMapping("/par")
public class ParameterController {

    @ApiOperation("1@NotNull")
    @PostMapping("/1")
    public Student name1(@RequestBody @Valid Student s) {

        return s;
    }

    @ApiOperation("参数默认值")
    @GetMapping("/test1")
    public String test1(@RequestParam(defaultValue = "hehe") String str,
            @RequestParam(defaultValue = "100") Integer i) {
        System.out.println(i);
        System.out.println(i.getClass());
        return str;
    }

    @ApiOperation("必须有参数") // 不能防止 ?str= 这种情况
    @GetMapping("/test2")
    public String test2(@RequestParam(required = true) String str) {
        if (str == null) {
            return "参数为null";
        } else if (str.length() == 0) {
            return "str长度为0";
        }
        return str;
    }

    @ApiOperation("必须有参数2") // Integer没有空串这种情况
    @GetMapping("/test3")
    public String test3(@RequestParam(required = true) Integer i) {
        if (i == null) {
            return "参数为null";
        } else {
            return "参数不为null";
        }
    }
}
