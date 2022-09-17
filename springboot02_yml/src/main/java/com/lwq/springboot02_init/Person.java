package com.lwq.springboot02_init;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component
@ConfigurationProperties(prefix = "person")         //把配置文件中的属性注入到类中
public class Person {

    private String name;
    private int age;
    private ArrayList<String> address;


}
