package com.lwq.springboot02_init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("我是手写注入值")
    private String myb;

    @Value("${a}")
    private String mya;

    @Value("${address[0]}")
    private String address1;

    @Value("${msg1}")
    private String msg1;

    @Value("${msg2}")
    private String msg2;

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private int age;

//    @Value("${list}")
//    private ArrayList<Person> personArrayList;


    @Autowired
    private Environment env;        //注入这一个对象后就可以调用配置文件中的属性了

    @Autowired
    private Person person;          //为该对象注入配置文件中属性的步骤去person上找




    @RequestMapping("/hello8088")
    public String hello2() {

        System.out.println("直接注入给myb的值 是" + myb);
        System.out.println("读取到配置文件中的a是" + mya);
        System.out.println("读取到配置文件中address数组中的第一个是" + address1);
        System.out.println("读取到配置文件中的msg1是" + msg1);
        System.out.println("读取到配置文件中的msg2是" + msg2);
        System.out.println("读取到配置文件中person的name是" + name);
        System.out.println("读取到配置文件中person的age是" + age);

        System.out.println("------------------------分割线------------------------");

        System.out.println(env.getProperty("person.name"));
        System.out.println(env.getProperty("address[1]"));

        System.out.println("------------------------分割线------------------------");

        //System.out.println(personArrayList);



        return "hello Spring Boot 222!";
    }

}
