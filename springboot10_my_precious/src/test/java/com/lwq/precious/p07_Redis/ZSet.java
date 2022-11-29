package com.lwq.precious.p07_Redis;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ZSet {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void name1() {
        stringRedisTemplate.opsForZSet().add("k1","v1",1);
        stringRedisTemplate.opsForZSet().add("k1","v1",1);
        stringRedisTemplate.opsForZSet().add("k1","vv",1);
        stringRedisTemplate.opsForZSet().add("k1","v2",2);

        //获取score，可以用来当作判断key存不存在
        Double score = stringRedisTemplate.opsForZSet().score("k1", "v25");
        System.out.println(score);

        Set<String> range = stringRedisTemplate.opsForZSet().range("k1",0, 100);
        System.out.println(range);



    }
}
