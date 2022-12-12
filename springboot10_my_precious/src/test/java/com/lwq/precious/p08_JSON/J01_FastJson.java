package com.lwq.precious.p08_JSON;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.lwq.precious.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class J01_FastJson {
    @Test
    void name() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("name", "李文强");
        hashMap.put("school", "清华大学");
        String jsonString = JSON.toJSONString(hashMap);
        System.out.println(jsonString);

        JSONObject parseObject = JSON.parseObject(jsonString);
        System.out.println(parseObject.getString("name"));

        HashMap parseMap = JSON.parseObject(jsonString, HashMap.class);
        System.out.println(parseMap.get("name"));
    }

    @Test
    void name1() {
        Student build = Student.builder().name("李文强").build();
        String jsonString = JSON.toJSONString(build);
        Student parseObject = JSON.parseObject(jsonString, Student.class);
        parseObject.learning();
    }

}
