package com.lwq.springboot01.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "一对一测试")
@RestController
public class One2OneController {

    @Resource
    One2OneService one2OneService;

    // @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation(value = "addAndFind")
    @GetMapping("/addAndFind")
    public ResponseEntity<String> addAndFind() {
        one2OneService.addAndFind();
        return ResponseEntity.ok("addAndFind");
    }

    @ApiOperation(value = "addAndFind2")
    @GetMapping("/addAndFind2")
    public ResponseEntity<String> addAndFind2() {
        one2OneService.addAndFind2();
        return ResponseEntity.ok("addAndFind");
    }

    @ApiOperation(value = "addAndFind3")
    @GetMapping("/addAndFind3")
    public ResponseEntity<String> addAndFind3() {
        one2OneService.addAndFind3();
        return ResponseEntity.ok("addAndFind");
    }

    @ApiOperation(value = "find")
    @GetMapping("/find")
    public ResponseEntity<String> find() {
        one2OneService.find();
        return ResponseEntity.ok("addAndFind");
    }
}
