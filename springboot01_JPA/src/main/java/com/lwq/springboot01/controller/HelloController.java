package com.lwq.springboot01.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot01.Entity.Person;
import com.lwq.springboot01.dao.PersonRepository;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private PersonRepository pr;

    @GetMapping("/")
    public String hello() {
        return "我家大门常打开,开放怀抱等你";
    }

    @GetMapping("/hehe1")
    public String hello1() {
        return "Spring Boot1111111111111111111111";
    }

    @GetMapping("/hehe2")
    public String hello2() {
        return "Spring Boot22222222222222222222222";
    }
    @GetMapping("/hehe3")
    public List<Person> hello3() {
        List<Person> findAll = pr.findAll();
        return findAll;
    }
}
