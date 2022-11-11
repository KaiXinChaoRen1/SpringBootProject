package com.lwq.precious.p00_a随笔;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
        String str="我是%s,我%s了";
        String format = String.format(str, "李文强", "无敌");
        System.out.println(format);
    }

    /**
     * String->JSON
     */
    @Test
    public void name3() {
        String str="{\"name\":\"李文强\",\"age\":\"23\"}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject.getString("name"));
        System.out.println(jsonObject.getString("age"));
    }
}
