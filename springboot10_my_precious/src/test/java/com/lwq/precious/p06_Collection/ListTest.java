package com.lwq.precious.p06_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.precious.model.MyJsonUser;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ListTest {

    /**
     * list进行sort排序
     */
    @Test
    void name4() {
        MyJsonUser user1 = MyJsonUser.builder().name("李文强").age(23).build();
        MyJsonUser user2 = MyJsonUser.builder().name("文强李").age(24).build();
        ArrayList<MyJsonUser> arrayList = new ArrayList<MyJsonUser>();
        arrayList.add(user2);
        arrayList.add(user1);
        // 直接打印
        System.out.println(arrayList);
        // 升序排序
        arrayList.sort(Comparator.comparing(MyJsonUser::getAge));
        System.out.println(arrayList);
        // 降序排序
        arrayList.sort(Comparator.comparing(MyJsonUser::getAge).reversed());
        System.out.println(arrayList);
    }

    /**
     * 快速初始化
     * List list = new ArrayList<>(Arrays.asList(xxx))--->YES
     * List list = Arrays.asList(xxx)----------------------NO
     */
    @Test
    void name1() {
        List<String> list = Arrays.asList("我", "是", "你", "爸", "爸");
        list.add(0, "阿");

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
        String[] a = { "1", "2", "3" };
        List<String> asList = Arrays.asList(a);
        ArrayList<String> arrayList = new ArrayList<>(asList);

        Integer[] b = { 1, 2, 3 };
        List<Integer> asList2 = Arrays.asList(b);
        ArrayList<Integer> arrayList2 = new ArrayList<>(asList2);

        // 这种方式不适用于基本类型
        // int[] c = {1, 2, 3};
        // List<int[]> asList3 = Arrays.asList(c);
    }

    /**
     * List.contains()
     */
    @Test
    void name3() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("我", "是", "你", "爸", "爸"));
        System.out.println(arrayList.contains("我"));
    }

}
