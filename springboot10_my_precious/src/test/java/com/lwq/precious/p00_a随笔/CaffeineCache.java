package com.lwq.precious.p00_a随笔;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import lombok.extern.slf4j.Slf4j;

/**
 * 单机缓存,不适用与分布式
 * 本地缓存相比Redis缓存以及其他存储避免了网络IO的开销，它不需要发送redis命令，直接在本地jvm进程中操作缓存数据，
 * 在需要的时候合理使用本地缓存可以有效提高系统的吞吐量。
 */
@Slf4j
public class CaffeineCache {
    public static void main(String[] args) throws InterruptedException {
        // 创建缓存对象
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(1000, TimeUnit.MILLISECONDS) // 设置过期时间为 1000 ms
                .maximumSize(1000) // 设置最大缓存项数为 1000
                .build();

        // 将数据放入缓存中
        cache.put("key1", "value1");
        cache.put("key2", "value2");

        // 从缓存中获取数据
        String value1 = cache.getIfPresent("key1");
        String value2 = cache.getIfPresent("key2");
        System.out.println(value1); // 输出：value1
        System.out.println(value2); // 输出：value2

        // 获取不存在的数据
        String value3 = cache.getIfPresent("key3");
        System.out.println(value3); // 输出：null

        // 移除数据
        cache.invalidate("key1");
        String value4 = cache.getIfPresent("key1");
        System.out.println(value4); // 输出：null

        String value22 = cache.getIfPresent("key2");
        System.out.println(value22);

        Thread.sleep(1000);
        String value222 = cache.getIfPresent("key2");
        System.out.println(value222);

    }

}
