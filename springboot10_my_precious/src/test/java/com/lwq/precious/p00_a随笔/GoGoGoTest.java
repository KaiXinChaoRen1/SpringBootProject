package com.lwq.precious.p00_a随笔;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Answers.values;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.alibaba.fastjson2.JSONObject;
import com.lwq.precious.model.CloneStudent;
import com.lwq.precious.service.AsyncTaskService;
import com.lwq.precious.service.AsyncTaskService2;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GoGoGoTest implements Serializable {

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Autowired
    private AsyncTaskService2 asyncTaskService2;


    @Test
    public void name22s2131111() {

      double a=100.0;
      double b =a/1000.0;
      System.out.println(b);
       
    }

    @Test
    public void name22s21311() {

        Double double1 = new Double(444/1000000.0);
        System.out.println(double1);

        String valueOf = String.valueOf(new Double(444/1000000.0));
        System.out.println(valueOf);

        String valueOf1 = String.valueOf(new Double(0.000444));
        System.out.println(valueOf1);
       
    }

    @Test
    public void name22s2131() {

        String rootPath = System.getProperty("user.dir");
        System.out.println(rootPath);
    }

    @Test
    public void name22s213() {
        System.out.println("" + null);
    }

    /**
     * Set存储String
     */
    @Test
    public void name2221() {
        String s1 = "111aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s2 = "111aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(s1.equals(s2));
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(s2);
        hashSet.add(s1);
        System.out.println(hashSet.size());
    }

    /**
     * 字符串分割
     */
    @Test
    public void name222() {
        String s = "1;2;3;";
        String[] split = s.split(";");
        System.out.println(split.length);
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

    }

    /**
     * org.springframework.util.Assert断言,否则抛出错误
     */
    @Test
    public void name() {
        try {
            Assert.notNull(null, "数据为null");
        } catch (Exception e) {
            log.error("", e);
        }

    }

    /**
     * 断言测试,Test里带的断言
     */
    @Test
    public void name17() {
        int a = 2;
        assertEquals(2, a);
        System.out.println("wuhu~~~~~~~~~");
        assertEquals(3, a); // 断言失败后不会执行后面的
        System.out.println("wuhu~~~~~~~~~");
        assertEquals(2, a);
    }

    /**
     * 测试log打印
     */
    @Test
    public void name16() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.info("呵呵", e);
        }

    }

    /*
     * 测试异步任务
     */
    @Test
    public void name155() throws InterruptedException, ExecutionException {
        long begin = System.currentTimeMillis();
        Future<String> task1 = asyncTaskService.task1();
        Future<String> task2 = asyncTaskService.task2();
        Future<String> task3 = asyncTaskService.task3();
        long end = System.currentTimeMillis();
        System.out.println("执行到这里的时间是" + (end - begin));// 如果这里直接结束,会打断子线程的睡眠,那会不会打断正儿八经的任务呢
        System.out.println(task1.get());
        System.out.println(task2.get());
        System.out.println(task3.get());
    }

    /*
     * 测试手写异步任务2
     */
    @Test
    public void name15() throws InterruptedException, ExecutionException {
        long begin = System.currentTimeMillis();
        FutureTask<String> task1 = asyncTaskService2.task1();
        FutureTask<String> task2 = asyncTaskService2.task2();
        FutureTask<String> task3 = asyncTaskService2.task3();
        long end = System.currentTimeMillis();
        System.out.println("执行到这里的时间是" + (end - begin));// 如果这里直接结束,会打断子线程的睡眠,那会不会打断正儿八经的任务呢
        System.out.println(task1.get());
        System.out.println(task2.get());
        System.out.println(task3.get());
    }

    /**
     * 字符串切割获取最后一位或者前x位
     */
    @Test
    public void name14() {
        String str = "aaab";
        String substring = str.substring(str.length() - 1);
        System.out.println(substring);

        String substring2 = str.substring(0, str.length() - 1);
        System.out.println(substring2);
    }

    /**
     * lambda表达式里不能修改外部的普通变量,想要访问可以放到数组里
     */
    @Test
    public void name13() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1); // ctrl+d复制上一行
        integers.add(2);
        integers.add(3);
        // boolean b=false;
        // integers.forEach(i->{
        // if(i==3){
        // b=true; //报错:Variable used in lambda expression should be final or
        // effectively final
        // }
        // });
        boolean[] b = new boolean[] { false };
        integers.forEach(i -> {
            if (i == 3) {
                b[0] = true;
            }
        });
        System.out.println(b[0]);
    }

    /**
     * Long包装类对比(包装类与基本类型运算时会自动转换为基本类型)
     */
    @Test
    public void name1() {
        Long l = 200L;

        System.out.println(l == 200L);
        System.out.println(l.equals(200));
        System.out.println(l.longValue() == 200);

        Long l2 = 200L;
        // 阿里巴巴规范:包装类之间比较必须用equals
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
     * ====>'%' 和 '/' 区分
     */
    @Test
    public void name4() {
        System.out.println("3/2=" + 3 / 2);
        System.out.println("2/3=" + 2 / 3);
        System.out.println("3%2=" + 3 % 2);
        System.out.println("2%3=" + 2 % 3);
        System.out.println((double) 2 / 3);
    }

    /**
     * list添加null 和 removeAll
     */
    @Test
    public void name5() {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(null);
        System.out.println(l);
        System.out.println(l.size());
        Object[] objects = l.toArray();
        System.out.println(objects);
        System.out.println(objects.length);

        // removeAll
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list.removeAll(list2);
        System.out.println(list);

    }

    /**
     * 手写序列化对象深拷贝
     */
    @Test
    public void name8() throws Exception {
        CloneStudent xiaoming = new CloneStudent("小明");
        CloneStudent xiaowang = new CloneStudent("小王", xiaoming);
        // 序列化到文件
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\lwq\\Desktop\\student.bin", false));
        oos.writeObject(xiaowang);
        oos.flush();
        oos.close();

        // 反序列化到对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\lwq\\Desktop\\student.bin"));
        CloneStudent xiaowang2 = (CloneStudent) ois.readObject();
        ois.close();

        System.out.println(xiaowang);
        System.out.println(xiaowang2);
        xiaowang.getFavoriteClassmate().setName("小小明");
        System.out.println(xiaowang);
        System.out.println(xiaowang2);
    }

    /**
     * Hutool序列化深拷贝
     */
    @Test
    public void name9() {
        CloneStudent xiaoming = new CloneStudent("小明");
        CloneStudent xiaowang = new CloneStudent("小王", xiaoming);
        CloneStudent xiaowang2 = ObjectUtil.cloneByStream(xiaowang);
        System.out.println(xiaowang);
        System.out.println(xiaowang2);
        xiaowang.getFavoriteClassmate().setName("小小明");
        System.out.println(xiaowang);
        System.out.println(xiaowang2);
    }

    /**
     * 普通内部类不能直接序列化,
     * 可以让外部类继承序列化接口,
     * 或者改成静态内部类
     * 才可以序列化
     */
    @Test
    public void name10() throws Exception {
        // hutool
        User u = new User();
        u.setName("li");
        System.out.println(u);
        User u2 = ObjectUtil.cloneByStream(u);
        System.out.println(u2);

        // 手写
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\lwq\\Desktop\\u.bin", false));
        oos.writeObject(u);
        oos.flush();
        oos.close();
        // 反序列化到对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\lwq\\Desktop\\u.bin"));
        User u3 = (User) ois.readObject();
        ois.close();
        System.out.println(u3);

    }

    @Data
    @ToString
    class User implements Serializable {
        String name;
        String age;
    }

}
