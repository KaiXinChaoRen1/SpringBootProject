package com.lwq.hutool.p01_hehe;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MyTest01 {

    @Test
    public void test92111sds22() {
        LinkedList<String> linkedList = ListUtil.toLinkedList("1", "2", "3");

    }

    @ToString
    class TestBean {
        String name;
        String ageString;
    }

    @Test
    public void testcsv() {
        // 根本j8不好用
        CsvReader reader = CsvUtil.getReader();

        List<TestBean> result = reader.read(
                ResourceUtil.getUtf8Reader("C:\\Users\\wenqiang.li1\\Desktop\\hehe.csv"), TestBean.class);
        System.out.println(result.get(0));
    }

}
