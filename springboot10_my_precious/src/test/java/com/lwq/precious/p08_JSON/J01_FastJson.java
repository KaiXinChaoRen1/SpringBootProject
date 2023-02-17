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
        // Java对象->Json字符串
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("name", "李文强");
        hashMap.put("school", "清华大学");
        String jsonString = JSON.toJSONString(hashMap);
        System.out.println(jsonString);

        // 字符串->JSON对象
        JSONObject parseObject = JSON.parseObject(jsonString);
        // 操作JSON对象
        System.out.println(parseObject.getString("name"));

        // JSON字符串->Java对象
        HashMap parseMap = JSON.parseObject(jsonString, HashMap.class);
        System.out.println(parseMap);
        parseMap.put("money", "$9999999999");
        System.out.println(parseMap);

    }

    @Test
    void name1() {
        Student build = Student.builder().name("李文强").build();
        String jsonString = JSON.toJSONString(build);
        Student parseObject = JSON.parseObject(jsonString, Student.class);
        parseObject.learning();
    }

}
