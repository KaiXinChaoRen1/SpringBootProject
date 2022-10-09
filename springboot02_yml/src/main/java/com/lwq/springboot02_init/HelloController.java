package com.lwq.springboot02_init;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
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
    private Environment env; // 注入这一个对象后就可以调用配置文件中的属性了

    @Autowired
    private Person person; // 为该对象注入配置文件中属性的步骤去person上找

    @RequestMapping("/")
    public Person hehe1() {
        return person;
    }

    /**
     * Environment  
     * getProperty()返回String
     */
    @RequestMapping("/hehe2")
    public String hehe2() {
        System.out.println(env.getProperty("person.name"));
        System.out.println(env.getProperty("person.age"));
        System.out.println(env.getProperty("person.title"));//null
        System.out.println(env.getProperty("person.title[0]"));
        System.out.println(env.getProperty("person.list"));//null
        System.out.println(env.getProperty("person.list[0]"));
        return "看控制台！";
    }

    @RequestMapping("/hehe3")
    public String hehe3() {
        System.out.println(message);
        System.out.println(myName);
        System.out.println(myAge);
        System.out.println(petName);

        //System.out.println(myTitles);
        //System.out.println(myList);
        return "看控制台！";
    }

}
