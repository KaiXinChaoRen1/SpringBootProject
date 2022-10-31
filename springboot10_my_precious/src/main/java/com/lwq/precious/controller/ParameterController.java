package com.lwq.precious.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.precious.model.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="参数测试")
@RestController
public class ParameterController {
    
    @ApiOperation("1@NotNull")
    @PostMapping("/1")
    public Student name1(@RequestBody @Valid Student s) {

        return s;
    }
}
