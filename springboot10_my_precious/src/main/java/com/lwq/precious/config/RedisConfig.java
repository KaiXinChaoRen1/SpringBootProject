package com.lwq.precious.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
    /**
     * 改变redisTemplate对k-v的默认序列化方式,(但有一个问题,会redis中记录class信息实现自动反序列化,十分占用空间,因此不用这种方式,而是全用String,手动序列化)
     */
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory){
//        // 创建RedisTemplate对象
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        // 设置连接工厂
//        template.setConnectionFactory(connectionFactory);
//        // 创建JSON序列化工具
//        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
//
//        // 设置Key的序列化(key和hashKey采用String序列化)
//        template.setKeySerializer(RedisSerializer.string());
//        template.setHashKeySerializer(RedisSerializer.string());
//        // 设置Value的序列化(value和hashValue采用JSON序列化)
//        template.setValueSerializer(jsonRedisSerializer);
//        template.setHashValueSerializer(jsonRedisSerializer);
//        // 返回
//        return template;
//    }
}
