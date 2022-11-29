package com.lwq.precious.p05_Hutool;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StringUtils {

    /**
     * join 字符串数组拼接
     */
    @Test
    public void name1(){
        ArrayList<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("1");
        strList.add("1");
        String join = StrUtil.join("+", strList);
        System.out.println(join);

    }
}
