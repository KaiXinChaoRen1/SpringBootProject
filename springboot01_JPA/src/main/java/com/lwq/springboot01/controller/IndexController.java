package com.lwq.springboot01.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.entity.schoolstory.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "索引测试")
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private PersonRepository pr;

    @ApiOperation(value = "添加数据")
    @PostMapping("/add")
    public ResponseEntity<String> add1ResponseEntity(@RequestBody Person person) {
        try {
            pr.save(person);
        } catch (Exception e) {
            return ResponseEntity.ok("添加失败" + e.getMessage());
        }
        return ResponseEntity.ok("添加成功");
    }

}
