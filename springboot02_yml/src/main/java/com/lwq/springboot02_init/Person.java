package com.lwq.springboot02_init;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "person")         //把配置文件中的属性注入到类中
public class Person {

    private String name;
    private Integer age;
    private Date birth;
    private String[] title;
    private Pet pet;
    private List<String> list;
    private Map<String,String>  map1;
    private Map<String,List<Pet>> map2;
    private Map<String,List<Pet>> map3;


}
