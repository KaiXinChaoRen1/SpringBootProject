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

    @ApiOperation(value = "维护外键的一方保存")
    @GetMapping("/save1")
    public ResponseEntity<String> save1() {
        one2OneService.save1();
        return ResponseEntity.ok("success");
    }

    @ApiOperation(value = "放弃维护外键的一方保存")
    @GetMapping("/save2")
    public ResponseEntity<String> save2() {
        one2OneService.save2();
        return ResponseEntity.ok("success");
    }

    @ApiOperation(value = "放弃维护外键的一方保存2")
    @GetMapping("/save3")
    public ResponseEntity<String> save3() {
        one2OneService.save3();
        return ResponseEntity.ok("success");
    }
}
