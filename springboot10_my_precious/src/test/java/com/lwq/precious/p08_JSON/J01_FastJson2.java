package com.lwq.precious.p08_JSON;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.lwq.precious.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class J01_FastJson2 {

    /**
     * json对象转换
     */
    @Test
    void hehe() {
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
        HashMap<String, String> mapObj = JSON.parseObject(jsonString, HashMap.class);
        mapObj.put("money", "$9999999999");
        System.out.println(mapObj);
        Student studentObj = JSON.parseObject(jsonString, Student.class);
        System.out.println(studentObj);

        // 3."json对象" 分别转换成 json字符串和java对象
        // json对象->JSONString
        String str = parseObject.toString();
        System.out.println(str);
        String str2 = parseObject.toJSONString();
        System.out.println(str2);

        // json对象->Java对象
        Student student = JSON.to(Student.class, parseObject);
        System.out.println(student);

    }

    /**
     * jsonArray
     */
    @Test
    void heheh() {
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("张三", "123456", new ArrayList<>()));
        arrayList.add(new Student("李四", "123456", new ArrayList<>()));

        ArrayList<Student> arrayList2 = new ArrayList<>();
        arrayList2.add(new Student("张三2", "123456", new ArrayList<>()));
        arrayList2.add(new Student("李四2", "123456", new ArrayList<>()));

        // JSONObject jsonobj = (JSONObject) JSON.toJSON(arrayList);
        JSONArray jsonArray = JSON.parseArray(JSON.toJSONString(arrayList));
        JSONArray jsonarr = (JSONArray) JSON.toJSON(arrayList2);

        System.out.println(jsonArray.equals(jsonarr));
        System.out.println(arrayList);
        System.out.println(jsonarr.toString());

    }

}
