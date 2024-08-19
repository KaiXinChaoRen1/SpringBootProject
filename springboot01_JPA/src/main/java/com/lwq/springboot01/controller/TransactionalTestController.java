package com.lwq.springboot01.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "事务测试")
@RestController
public class TransactionalTestController {

    @Resource
    TransactionalTestService transactionalTestService;

    // @ApiImplicitParam(name = "name", value = "姓名", required = true)
    @ApiOperation(value = "添加数据")
    @GetMapping("/add")
    public ResponseEntity<String> add1ResponseEntity() {
        transactionalTestService.add1();
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "添加数据同时抛出RuntimeException(会回滚)")
    @GetMapping("/add2")
    public ResponseEntity<String> add2() {
        transactionalTestService.add2();
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "添加数据同时抛出RuntimeException,事务设置此异常不回滚(不回滚)")
    @GetMapping("/add3")
    public ResponseEntity<String> add3() {
        transactionalTestService.add3();
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "事务调用事务,外部抛异常(会回滚)")
    @GetMapping("/add4")
    public ResponseEntity<String> add4() {
        transactionalTestService.add4();
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "事务调用事务(Propagation.REQUIRES_NEW),外部抛异常(不回滚)")
    @GetMapping("/add5")
    public ResponseEntity<String> add5() {
        transactionalTestService.add5EQUIRES_NEW();
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "事务调用事务(Propagation.NESTED),外部抛异常(会回滚) ")
    @GetMapping("/add6")
    public ResponseEntity<String> add6() {
        transactionalTestService.add6NESTED();
        return ResponseEntity.ok("添加成功");
    }

}
