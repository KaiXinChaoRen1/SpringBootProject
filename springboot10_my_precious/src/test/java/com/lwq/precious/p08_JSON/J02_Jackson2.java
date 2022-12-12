package com.lwq.precious.p08_JSON;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class J02_Jackson2 {

    @Test
    void name() throws JsonProcessingException {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("name", "李文强");
        hashMap.put("school", "清华大学");
        // 在高并发环境下，为了保证线程安全会有较高的锁竞争，所以很多时候都是每次通过new来创建ObjectMapper。
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonStr = objectMapper.writeValueAsString(hashMap);
        System.out.println(jsonStr);

        HashMap readValue = objectMapper.readValue(jsonStr, HashMap.class);
        System.out.println(readValue.get("name"));

    }
}
