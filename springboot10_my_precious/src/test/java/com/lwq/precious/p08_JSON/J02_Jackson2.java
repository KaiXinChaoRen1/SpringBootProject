package com.lwq.precious.p08_JSON;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lwq.precious.model.MyJsonUser;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class J02_Jackson2 {

    @Test
    void name() throws JsonProcessingException {
        MyJsonUser myJsonUser = MyJsonUser.builder().name("甄子丹").age(55).birthday(LocalDateTime.now()).addHobby("咏春").addHobby("吃火锅").build();

        // 在高并发环境下，为了保证线程安全会有较高的锁竞争，所以很多时候都是每次通过new来创建ObjectMapper。
        ObjectMapper objectMapper = new ObjectMapper();
        //使jackson支持java8时间格式
        objectMapper.registerModule(new JavaTimeModule());

        String jsonStr = objectMapper.writeValueAsString(myJsonUser);
        System.out.println(jsonStr);

        MyJsonUser readValue = objectMapper.readValue(jsonStr, MyJsonUser.class);
        System.out.println(readValue);

    }

    @Test
    public void name1() throws JsonMappingException, JsonProcessingException {
        // String jsonStr="{\"name\":\"甄子丹\",\"age\":55,\"hobby\":[\"咏春\",\"吃火锅\"]}";
        // ObjectMapper objectMapper = new ObjectMapper();
        // MyJsonUser readValue = objectMapper.readValue(jsonStr, MyJsonUser.class);
        // System.out.println(readValue);

        String jsonStr = "{\"hobby\":[\"咏春\",\"吃火锅\"]}";
        ObjectMapper objectMapper = new ObjectMapper();
        MyJsonUser readValue = objectMapper.readValue(jsonStr, MyJsonUser.class);
        System.out.println(readValue);
    }
}
