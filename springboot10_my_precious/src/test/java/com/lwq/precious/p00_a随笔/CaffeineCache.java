package com.lwq.precious.p00_a随笔;

import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.NonNull;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CaffeineCache {
    public static void main(String[] args) throws Exception {
        // 创建缓存对象，设置最大缓存数量为1000
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(1000).expireAfter(new Expiry<String, String>() {

                    @Override
                    public long expireAfterCreate(@NonNull String key, @NonNull String value, long currentTime) {
                        // TODO Auto-generated method stub
                        return 10000000;
                    }

                    @Override
                    public long expireAfterUpdate(@NonNull String key, @NonNull String value, long currentTime,
                            @NonNegative long currentDuration) {
                        // TODO Auto-generated method stub
                        return 10000000;
                    }

                    @Override
                    public long expireAfterRead(@NonNull String key, @NonNull String value, long currentTime,
                            @NonNegative long currentDuration) {
                        // TODO Auto-generated method stub
                        return 10000000;
                    }
                })
                .build();
        cache.put("张三", "10000");
        cache.put("李四", "20000");
        System.out.println(cache.getIfPresent("张三"));
        System.out.println(cache.getIfPresent("李四"));

        Thread.sleep(1000);
        System.out.println(cache.getIfPresent("张三"));
        System.out.println(cache.getIfPresent("李四"));

    }
}
