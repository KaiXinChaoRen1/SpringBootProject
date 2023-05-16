package com.lwq.precious.p01_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 1数据源 2数据处理 3收集结果（终结操作）
 * 流对象是一次性的,只能进行一次终结操作
 * 
 * **原数据不会被影响
 * 数据量大的时候foreach效率更高
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class StreamTest {

    /**
     * toMap:value不能为null
     * key有覆盖问题时需要加后面的(V1,V2)->V1)覆盖规则
     */
    @Test
    public void name99981() {
        People build1 = People.builder().sex("男").name("唐三藏").build();
        People build2 = People.builder().sex("男").name("唐三彩").build();
        People build3 = People.builder().sex("女").name("老鼠精").build();
        People build4 = People.builder().sex("女").name("玉兔精").build();
        ArrayList<People> pList = new ArrayList<>();
        pList.add(build1);
        pList.add(build2);
        pList.add(build3);
        pList.add(build4);

        Map<String, String> collect = pList.stream()
                .collect(Collectors.toMap(People::getSex, People::getName, (V1, V2) -> V1));
        System.out.println(collect);

    }

    /**
     * 分组groupingBy(),返回map
     */
    @Test
    public void name9998() {
        People build1 = People.builder().sex("男").name("唐三藏").build();
        People build2 = People.builder().sex("男").name("唐三彩").build();
        People build3 = People.builder().sex("女").name("老鼠精").build();
        People build4 = People.builder().sex("女").name("玉兔精").build();
        ArrayList<People> pList = new ArrayList<>();
        pList.add(build1);
        pList.add(build2);
        pList.add(build3);
        pList.add(build4);
        // 注意这里是map
        Map<String, List<People>> collect = pList.stream().collect(Collectors.groupingBy(People::getSex));
        System.out.println(collect);

    }

    /**
     * 并行流
     */
    @Test
    public void name9999() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.stream().forEach(System.out::println); // 串行流
        System.out.println("------------------------------------------");
        list.stream().parallel().forEach(System.out::println); // 并行流
    }

    /**
     * 对基本类型拆箱装箱的优化
     */
    @Test
    public void name999() {
        ArrayList<People> peopleList = new ArrayList<People>();
        peopleList.add(new People("李文强", 17, 6666));
        peopleList.add(new People("孙文腾", 19, 5555));
        peopleList.add(new People("屈百琛", 20, 4444));

        peopleList.stream()
                .map(o -> o.getAge())
                .filter(o -> o > 17)
                .map(o -> o + 10) // 这里这么做会出现频繁的拆箱装箱
                .forEach(System.out::println);

        // 这样优化一下即可
        peopleList.stream()
                .mapToInt(o -> o.getAge())
                .filter(o -> o > 17)
                .map(o -> o + 10)
                .forEach(System.out::println);

    }

    // flatmap,例子都看完了,还是不会,感觉用处不多啊
    @Test
    public void name8() {

        String[] words = new String[] { "Hello", "World" };
        List<String[]> collect = Arrays.stream(words)
                .map(word -> word.split(""))
                .collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect2 = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Stream::of)
                .collect(Collectors.toList());
        System.out.println(collect2);

    }

    /**
     * 使用map转换流里的数据类型
     */
    @Test
    public void name99() {
        ArrayList<People> peopleList = new ArrayList<People>();
        peopleList.add(new People("李文强", 17, 6666));
        peopleList.add(new People("孙文腾", 19, 5555));
        peopleList.add(new People("屈百琛", 20, 4444));

        List<Integer> collect = peopleList.stream().map(o -> o.getAge()).collect(Collectors.toList());
        System.out.println(collect);
        List<String> collect1 = peopleList.stream().map(o -> "hehe").collect(Collectors.toList());
        System.out.println(collect1);
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

    /**
     * skip：跳过前n个
     * findFirst()
     */
    @Test
    public void name7() {
        ArrayList<People> peopleList = new ArrayList<People>();
        peopleList.add(new People("李文强", 17, 6666));
        peopleList.add(new People("孙文腾", 19, 5555));
        peopleList.add(new People("屈百琛", 20, 4444));
        peopleList.add(new People("666", 20, 3333));

        peopleList.stream()
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .skip(1)
                .forEach(System.out::println);

        Optional<People> findFirst = peopleList.stream().findFirst();
        System.out.println(findFirst.get());
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

        Predicate<People> predicate1 = people -> people.getAge() > 1;
        Predicate<People> predicate2 = people -> people.getSalary() > 4999;
        boolean anyMatch = peopleList.stream().anyMatch(predicate1.and(predicate2));
        boolean allMatch = peopleList.stream().allMatch(predicate1.and(predicate2));
        boolean noneMatch = peopleList.stream().noneMatch(predicate1.and(predicate2));
        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noneMatch);
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

    // forEach是一个终结操作(不返回Stream就是终结操作了呗)
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

    // 数组获取Stream
    @Test
    public void name11() {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        Stream<Integer> stream = Arrays.stream(arr);
        stream.filter(num -> num < 4).forEach(num -> System.out.println(num));
    }

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

}
