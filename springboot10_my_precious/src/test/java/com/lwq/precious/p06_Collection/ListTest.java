package com.lwq.precious.p06_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.precious.model.MyJsonUser;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ListTest {

    /**
     * 指定大小防止频繁扩容
     */
    @Test
    public void name9() {
        long time1 = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        // ArrayList<Integer> arrayList = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(66);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("运行时间为" + (time2 - time1) + "ms");
    }

    /**
     * 反转耗时很少,Arraylist就是快
     */
    @Test
    public void name8() {
        long time1 = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        // List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5000000; i++) {
            list.add(i);
        }
        long time2 = System.currentTimeMillis();
        Collections.reverse(list);
        long time3 = System.currentTimeMillis();

        System.out.println("添加数据耗时" + (time2 - time1));
        System.out.println("反转耗时" + (time3 - time2));

    }

    /**
     * subList
     */
    @Test
    public void name7() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println(arrayList);
        // 截取(subListde的结果类型是Arrayslist的一个内部类,不是普通的Arraylist,对subList的后续操作会反应到原先的ArrayList上)
        List<Integer> subList = arrayList.subList(1, 3);
        System.out.println(subList);
        // 自己addAll自己
        subList.addAll(subList);
        System.out.println(subList);
        System.out.println("对subList的后续操作会反应到原先的ArrayList上");
        System.out.println(arrayList);


    }

    /**
     * 不要再循环中删除集合元素
     */
    @Test
    public void name6() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("ab");
        arrayList.add("ac");
        arrayList.removeIf(o -> o.contains("a"));
        System.out.println(arrayList);
    }

    /**
     * Stream流进行sort排序
     */
    @Test
    void name5() {
        MyJsonUser user1 = MyJsonUser.builder().name("李文强").age(23).build();
        MyJsonUser user2 = MyJsonUser.builder().name("文强李").age(24).build();
        MyJsonUser user3 = MyJsonUser.builder().name("士大夫").age(25).build();
        MyJsonUser user4 = MyJsonUser.builder().name("士发给第三方大夫").age(26).build();
        HashSet<MyJsonUser> hashSet = new HashSet<>();

        hashSet.add(user4);
        hashSet.add(user3);
        hashSet.add(user2);
        hashSet.add(user1);
        // 直接打印
        System.out.println(hashSet);
        // 升序排序
        List<MyJsonUser> collect = hashSet.stream().sorted(Comparator.comparing(MyJsonUser::getAge))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

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
