package com.lwq.precious.p01_Stream;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class OptionalTest {

    /**
     * 构造
     */
    @Test
    public void name() {
        Optional<Integer> integerOptional = Optional.of(1);
        // Optional<Object> of = Optional.of(null);
        Optional<Integer> integerOptional2 = Optional.ofNullable(1);
        Optional<Object> nullOptional = Optional.ofNullable(null);

        Optional<Object> nullOptional2 = Optional.empty();
        Optional<String> nullOptional3 = Optional.empty();
        System.out.println(nullOptional.equals(nullOptional2));
        System.out.println(nullOptional.equals(nullOptional3));
    }

    /**
     * 当mapping function返回的不是Optional类型的数据时，使用map，因为map会进行一次Optional的包装。
     */
    @Test
    public void name2() {

        Dog dog = new Dog("旺财", "1");
        // Optional<String> map = Optional.ofNullable(dog).map(d -> d.getName());
        Optional<String> map = Optional.ofNullable(dog).map(Dog::getName);
        System.out.println(map.get());

        Dog dog2 = new Dog();
        Optional<String> map2 = Optional.ofNullable(dog2).map(d -> d.getName());
        System.out.println(map2.isPresent());

    }

    /**
     * flatMap,当mapping
     * function返回的是Optional类型的数据时，可以直接使用flatMap，flatMap直接返回Optional
     */
    @Test
    public void name3() {

        Cat cat = new Cat(Optional.ofNullable("喵咪"), "1");
        Optional<String> flatMap = Optional.ofNullable(cat).flatMap(Cat::getName);
        System.out.println(flatMap.get());

        Cat cat2 = new Cat(Optional.ofNullable(null), "1");
        Optional<String> flatMap2 = Optional.ofNullable(cat2).flatMap(c -> c.getName());
        System.out.println(flatMap2.isPresent());
    }

    /**
     * orElse() & orElseGet();
     */
    @Test
    public void name4() {

        // 在optional为空值的情况下orElse和orElseGet都会执行方法
        Optional<String> o8 = Optional.empty();
        System.out.println(o8.orElse(method()));
        System.out.println(o8.orElseGet(() -> (method())));

        System.out.println("-----------------------------------------");
        // 当optional不为空时，orElseGet不会执行。
        Optional<String> o9 = Optional.of("我是笨蛋");
        System.out.println(o9.orElse(method()));
        System.out.println(o9.orElseGet(() -> (method())));

    }

    private static String method() {
        System.out.println("此方法执行了");
        return "我是天才";
    }

    /**
     * orElseThrow 完美替代我判空抛异常的写法
     */
    @Test
    public void name5() {
        Optional<String> o = Optional.of("我是笨蛋");
        String content = o.orElseThrow(() -> new RuntimeException("数据不存在"));
        System.out.println(content);
        System.out.println("------------------------------------------------");
        Optional<String> o2 = Optional.ofNullable(null);
        String content2 = o2.orElseThrow(() -> new RuntimeException("数据不存在"));
        System.out.println(content2);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Dog {
        String name;
        String age;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Cat {
        Optional<String> name;
        String age;

    }

}
