package com.lwq.precious.p00_a随笔;

import java.net.UnknownHostException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.precious.model.MyJsonUser;
import com.lwq.precious.utils.SigarUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GoGoGoTest2 {


    @Test
    public void name5() throws UnknownHostException {
        System.out.println("heh");
        SigarUtils.property();
    }

    @Test
    public void name4() {
        HashMap<String, MyJsonUser> map = new HashMap<>();
        MyJsonUser build = MyJsonUser.builder().age(23).name("黄春").build();
        map.put("1", build);

        System.out.println(map.get("1"));
        // build.setAge(24);

        build = MyJsonUser.builder().age(23).name("小龙").build();
        System.out.println(map.get("1"));

    }

    /**
     * 从开头或结尾或某一个位置开始匹配
     */
    @Test
    public void name3() {
        System.out.println("aabb".startsWith("ab", 1));
        System.out.println("aabb".startsWith("aab"));
        System.out.println("aabb".endsWith("abb"));
    }

    /**
     * 判断包含子串
     */
    @Test
    public void name2() {
        System.out.println("aaabbb".contains("a"));
        System.out.println("aaabbb".contains("ab"));
    }

    /**
     * 字符串忽略大小写匹配
     */
    @Test
    public void name() {
        System.out.println("faLsE".equalsIgnoreCase("FALSE"));
        System.out.println("FALSE".equalsIgnoreCase("FALSE"));
        System.out.println("false".equalsIgnoreCase("FALSE"));
        System.out.println("False".equalsIgnoreCase("FALSE"));
    }
}
