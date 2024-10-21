package com.lwq.precious.p08_JSON;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lwq.precious.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class J01_FastJson1 {
    @Test
    void name() {
        // 1."java对象" 分别转换成 json对象和json字符串

        // JavaObj->JSONObject
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("name", "李文强");
        hashMap.put("school", "清华大学");
        JSONObject json = (JSONObject) JSON.toJSON(hashMap);
        System.out.println(json.get("name"));

        // JavaObj->JSONString
        String jsonString = JSON.toJSONString(hashMap);
        System.out.println(jsonString);

        // 2."json字符串" 分别转换成 json对象和java对象

        // json字符串->JSONObject
        JSONObject parseObject = JSON.parseObject(jsonString);
        System.out.println("从json字符串转换的json对象中直接get到的name: " + parseObject.get("name"));

        // json字符串->Java对象
        HashMap<String, String> parseMap = JSON.parseObject(jsonString, HashMap.class);
        parseMap.put("money", "$9999999999");
        System.out.println(parseMap);

        // 3."json对象" 分别转换成 json字符串和java对象
        // json对象->JSONString
        String str = parseObject.toString();
        System.out.println(str);
        String str2 = parseObject.toJSONString();
        System.out.println(str2);

        // json对象->Java对象
        Student student = JSON.toJavaObject(parseObject, Student.class);
        System.out.println(student);

    }

    @Test
    void name1() {
        Student build = Student.builder().name("李文强").build();
        String jsonString = JSON.toJSONString(build);
        System.out.println(jsonString);
        String replace = jsonString.replace("李文强", "孙悟空");
        Student student = JSON.parseObject(replace, Student.class);
        student.learning();
    }

}
