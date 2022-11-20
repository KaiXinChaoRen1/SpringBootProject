package com.lwq.precious.p07_Redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwq.precious.model.MyModel;
import com.lwq.precious.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RedisTestQuickStart {

    //引入依赖,yml写上配置,直接就可以注入使用,@Autowired会有爆红,但是没关系
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    //JSON转换工具
    private static final ObjectMapper mapper = new ObjectMapper();

    //测试Hash的存取
    @Test
    public void name4() {
        stringRedisTemplate.opsForHash().put("user", "name", "虎哥");
        stringRedisTemplate.opsForHash().put("user", "age", "21");

        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("user");
        System.out.println(map);
    }

    @Test
    public void name3() throws JsonProcessingException {
        // 创建对象
        MyModel myModel = new MyModel("hehe", "hehe");
        // 手动序列化
        String json = mapper.writeValueAsString(myModel);
        // 写入数据
        stringRedisTemplate.opsForValue().set("myModel", json);

        // 获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("myModel");
        // 手动反序列化
        MyModel myModel1 = mapper.readValue(jsonUser, MyModel.class);
        System.out.println(myModel1);

    }


    //修改序列化方式后,通过String类型存储Java对象,(但有一个问题,会redis中记录class信息实现自动反序列化,十分占用空间,因此不用这种方式,而是全用String,手动序列化)
    @Test
    public void name2() {
        MyModel myModel = MyModel.builder().username("hehe").password("hehe").build();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("model", myModel);
        Object model = valueOperations.get("model");        //还会自动的反序列化
        System.out.println(model);


    }

    @Test
    public void name1() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name", "刘备");   //会使用序列化器把kv序列化后存储,要想所见即所得,需要改变redisTemplate的序列化方式
        System.out.println(valueOperations.get("name"));
    }

}
