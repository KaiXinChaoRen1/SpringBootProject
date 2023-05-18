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
        // Object->JSONObject
        JSONObject json =  (JSONObject) JSON.toJSON(hashMap);
        System.out.println(json.get("name"));

        // Object->JSONString
        String jsonString = JSON.toJSONString(hashMap);
        System.out.println(jsonString);



        // JSONString->JSONObject
        JSONObject parseObject = JSON.parseObject(jsonString);
        // JSONObject->JSONString
        String str = parseObject.toString();
        System.out.println("JSONObject.toString()和对象直接转换的JSONString是否相等: " + str.equals(jsonString));
        // 操作JSONObject
        //getString
        System.out.println(parseObject.getString("name"));

        // JSONString->Java对象
        HashMap parseMap = JSON.parseObject(jsonString, HashMap.class);
        System.out.println(parseMap);
        parseMap.put("money", "$9999999999");
        System.out.println(parseMap);

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
