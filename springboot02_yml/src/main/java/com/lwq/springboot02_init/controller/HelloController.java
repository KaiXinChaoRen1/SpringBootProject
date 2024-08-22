package com.lwq.springboot02_init.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot02_init.model.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "HelloController")
@RestController
@Slf4j
public class HelloController {

    // *************************配置静态变量******************************
    public static String APP_ID;

    @Value("${appid}")
    private String appId;

    // @PostConstruct
    // public void getStaticEnvironment() {
    // APP_ID = appId;
    // }
    // ******************************END********************************

    @Value("直接写入值")
    private String message;

    @Value("${person.name}")
    private String myName;

    @Value("${person.age}")
    private Integer myAge;

    @Value("${person.map2.cat[1].name}")
    private String petName;

    // @Value("$(person.pet)")
    // private Pet myPet;

    // @Value("${person.title}")
    // private String[] myTitles;

    // @Value("${person.list}")
    // private ArrayList<Person> myList;

    @Autowired
    private Environment env; // 注入这一个对象后就可以获取到配置文件中的内容了

    @Autowired
    private Person person; // 为该对象注入配置文件中属性的步骤去person上找

    @ApiOperation(value = "yml配置静态变量")
    @GetMapping("/static")
    public String hehe1() {
        System.out.println(APP_ID);
        return APP_ID;
    }

    /**
     * Environment
     * getProperty()返回String
     */
    @ApiOperation(value = "test2")
    @GetMapping("/test2")
    public String test2() {
        System.out.println(env.getProperty("person.name"));
        System.out.println(env.getProperty("person.age"));
        System.out.println(env.getProperty("person.title"));// null
        System.out.println(env.getProperty("person.title[0]"));
        System.out.println(env.getProperty("person.list"));// null
        System.out.println(env.getProperty("person.list[0]"));
        return "看控制台！";
    }

    @ApiOperation(value = "test3")
    @GetMapping("/test3")
    public String test3() {
        System.out.println(message);
        System.out.println(myName);
        System.out.println(myAge);
        System.out.println(petName);

        // System.out.println(myTitles);
        // System.out.println(myList);
        return "看控制台！";
    }

    @ApiOperation(value = "logTest")
    @GetMapping("/logTest")
    public String hehe12() {
        log.debug("我是debug日志");
        log.info("我是info日志");
        log.warn("我是warn日志");
        log.error("我是error日志");

        return "success";
    }

}
