package com.lwq.precious.p01_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 1数据源 2数据处理 3收集结果（终结操作）
 * 流对象是一次性的,只能进行一次终结操作
 * 原数据不会被影响
 */

@SpringBootTest
class StreamTest {

    // 单列集合获取Stream
    // filter & Predicate
    @Test
    public void name1() {

        ArrayList<People> peopleList = new ArrayList<People>();
        peopleList.add(new People("李文强", 17, 6666));
        peopleList.add(new People("孙文腾", 19, 5555));
        peopleList.add(new People("屈百琛", 20, 4444));

        // Predicate<People> predicate1=people->people.getAge()<20;
        // Predicate<People> predicate2=people->people.getSalary()>4443;
        // List<People> res = peopleList.stream()
        // .filter(predicate1).
        // filter(predicate2)
        // .collect(Collectors.toList());
        // System.out.println(res);

        // or & and
        Predicate<People> predicate1 = people -> people.getAge() < 20;
        Predicate<People> predicate2 = people -> people.getSalary() > 4443;
        List<People> res = peopleList.stream().filter(predicate1.and(predicate2)).collect(Collectors.toList());
        System.out.println(res);
    }

    // 数组获取Stream
    @Test
    public void name11() {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        Stream<Integer> stream = Arrays.stream(arr);
        stream.filter(num -> num < 4).forEach(num -> System.out.println(num));
    }

    // 双列集合获取Stream
    @Test
    public void name12() {
        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("瑟提", "叹为观止");
        myMap.put("亚索", "狂风绝息斩");
        myMap.put("Zed", "禁奥义-瞬狱影杀阵");
        Set<Entry<String, String>> myEntrySet = myMap.entrySet();
        myEntrySet.stream()
                .filter(entry -> entry.getValue().length() > 4)
                .forEach(entry -> System.out.println(entry));
    }

    // limit & distinct
    @Test
    public void name3() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);

        list.stream()
                .distinct() // 去重
                .limit(4) // 前四个
                .forEach(number -> System.out.println(number));
    }

    // sorted & ::
    // 需要去比较的类实现comparable接口或者直接lambda
    @Test
    public void name4() {
        ArrayList<People> peopleList = new ArrayList<People>();
        peopleList.add(new People("李文强", 17, 6666));
        peopleList.add(new People("孙文腾", 19, 5555));
        peopleList.add(new People("屈百琛", 20, 4444));

        peopleList.stream().sorted((p1, p2) -> p2.getAge() - p1.getAge())
                // .forEach(hehe->System.out.println(hehe));
                .forEach(System.out::println);
    }

    // max & min & count（都是终结操作）
    @Test
    public void name5() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(9);
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println(max.get());
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println(min.get());
        long count = list.stream().count();
        System.out.println(count);
    }

    // forEach是一个终结操作
    @Test
    public void name666() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.stream().forEach(o -> method(o));
        System.out.println(list);
    }

    private void method(String hehe) {
        hehe = hehe + "z";
        System.out.println(hehe);
    }

    // map:对每一个值分别操作
    // .collect(Collectors.toList()); 收集元素放进集合
    @Test
    public void name6() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        List<Integer> collect = list.stream()
                .map(o -> o + 10)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /// skip：跳过前n个
    @Test
    public void name7() {
        ArrayList<People> peopleList = new ArrayList<People>();
        peopleList.add(new People("李文强", 17, 6666));
        peopleList.add(new People("孙文腾", 19, 5555));
        peopleList.add(new People("屈百琛", 20, 4444));

        peopleList.stream()
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .skip(1)
                .forEach(System.out::println);
    }

    // flatmap将每一个元素都处理最后返回stream(具体在百度吧)
    @Test
    public void name8() {

    }

    // anyMatch 任意一个元素符合条件,返回true
    // allMatch 所有元素...
    // noMatch 都不符合...
    @Test
    public void name9() {
        ArrayList<People> peopleList = new ArrayList<People>();
        peopleList.add(new People("李文强", 17, 6666));
        peopleList.add(new People("孙文腾", 19, 5555));
        peopleList.add(new People("屈百琛", 20, 4444));

        boolean anyMatch = peopleList.stream()
                .anyMatch(p -> p.getSalary() > 6665);
        System.out.println(anyMatch);
    }

    // 看不懂,有空再看
    // reduce 可以传入一个初始值,依次将流中的元素与初始元素计算,计算结果再与后续元素计算
    @Test
    public void name10() {
        ArrayList<People> peopleList = new ArrayList<People>();
        peopleList.add(new People("李文强", 17, 6666));
        peopleList.add(new People("孙文腾", 19, 5555));
        peopleList.add(new People("屈百琛", 20, 4444));

        Integer reduce = peopleList.stream()
                .map(p -> p.getAge())
                .reduce(0, (result, element) -> result + element);

        System.out.println(reduce);
    }

}
