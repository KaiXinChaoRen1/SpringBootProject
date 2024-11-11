package com.lwq.jk1.j02_jdk17;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MyUtils {

    /**
     * Spring断言工具类
     */
    @Test
    public void name19() {
        Assert.notNull(null, "数据为null");

        Assert.hasLength("    ", "字符串没有长度");
        // 空格不算内容
        Assert.hasText("    ", "字符串没有内容");
    }

}
