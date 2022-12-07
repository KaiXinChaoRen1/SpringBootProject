package com.lwq.precious.p06_Collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ListTest {
    /**
     * 快速初始化
     * List  list =  new ArrayList<>(Arrays.asList(xxx))--->YES
     * List  list = Arrays.asList(xxx)----------------------NO
     */
    @Test
    void name1() {
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("我", "是", "你", "爸", "爸"));
        System.out.println(strList);
        strList.add("!");
        System.out.println(strList);
    }

    /**
     * 数组转集合的正确姿势,当然也可以直接循环,stream等等
     */
    @Test
    void name2() {
        int[] a = {1, 2, 3};
        List list = CollectionUtils.arrayToList(a);
        System.out.println(list);
    }


}
