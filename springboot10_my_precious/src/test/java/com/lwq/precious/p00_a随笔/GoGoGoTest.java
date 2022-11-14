package com.lwq.precious.p00_a随笔;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;

/**
 *  单元测试中使用scanner输入和I/O流是没有任何反应的
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GoGoGoTest {

    /**
     * Long包装类对比
     */
    @Test
    public void name1() {
        Long l = 100L;

        System.out.println(l == 100);
        System.out.println(l.equals(100));
        System.out.println(l.longValue() == 100);

        Long l2 = 100L;
        System.out.println(l.equals(l2));
    }

    /**
     * String.format
     */
    @Test
    public void name2() {
        String str = "我是%s,我%s了";
        String format = String.format(str, "李文强", "无敌");
        System.out.println(format);
    }

    /**
     * String->JSON
     */
    @Test
    public void name3() {
        String str = "{\"name\":\"李文强\",\"age\":\"23\"}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject.getString("name"));
        System.out.println(jsonObject.getString("age"));
    }

    /**
     * ====>'%' 和 '/'
     */
    @Test
    public void name4() {
        System.out.println("3/2=" + 3 / 2);
        System.out.println("2/3=" + 2 / 3);
        System.out.println("3%2=" + 3 % 2);
        System.out.println("2%3=" + 2 % 3);
        System.out.println((double) 2 / 3);
    }


}
