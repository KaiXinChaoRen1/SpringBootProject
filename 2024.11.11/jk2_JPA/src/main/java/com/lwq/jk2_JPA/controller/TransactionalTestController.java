package com.lwq.jk2_JPA.controller;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.jk2_JPA.dao.schoolRepository.PersonRepository;
import com.lwq.jk2_JPA.entity.schoolstory.Person;
import com.lwq.jk2_JPA.service.transactionalTest.TransactionalTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "事务测试")
@RestController
public class TransactionalTestController {

    @Resource
    private PersonRepository pr;
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

    @ApiOperation(value = "方法修饰符对 @Transactional注解的影响,只有pubnlic才生效")
    @GetMapping("/add222")
    public ResponseEntity<String> xiushifuTest() {
        transactionalTestService.xiushifuTest();
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "子线程 测试事务,(线程内事务有效,但跟主线程无关,主线程回滚,子线程不会滚)")
    @GetMapping("/threadAdd")
    @Transactional
    public ResponseEntity<String> threadAdd() {

        new Thread(() -> {
            add3();
        }).start();

        Person p1 = Person.builder().name("zhangfei_main").age(55).birthday(LocalDateTime.now()).build();
        pr.save(p1);
        if (true) {
            throw new RuntimeException();
        }
        return ResponseEntity.ok("执行完毕");
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

    @ApiOperation(value = "编程式事务测试 ")
    @GetMapping("/test1")
    public ResponseEntity<String> test1() {

        transactionalTestService.addtest();

        return ResponseEntity.ok("success");
    }

    @ApiOperation(value = "编程式事务测试(先提交再抛出异常) ")
    @GetMapping("/test2")
    public ResponseEntity<String> test2() {

        transactionalTestService.addtest2();

        return ResponseEntity.ok("success");
    }

    @ApiOperation(value = "编程式事务测试(先抛出异常) ")
    @GetMapping("/test3")
    public ResponseEntity<String> test3() {

        transactionalTestService.addtest3();

        return ResponseEntity.ok("success");
    }

    @ApiOperation(value = "编程式事务一部分提交,一部分回滚) ")
    @GetMapping("/test4")
    public ResponseEntity<String> test4(boolean isException) {

        transactionalTestService.addtest4(isException);

        return ResponseEntity.ok("success");
    }

    @ApiOperation(value = "jpa+jdbcTemplate) ")
    @GetMapping("/jdbcTemplate")
    public ResponseEntity<String> jdbcTemplate(Integer id, Boolean isException) {

        transactionalTestService.jdbcTemplateTest(id, isException);

        return ResponseEntity.ok("success");
    }

}
