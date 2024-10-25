package com.lwq.precious.p00_a随笔;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TimeZone;
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
    public void test92111sds2223ss() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(String.valueOf(i));
        }
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }

    @Test
    public void test92111sds2223() {
        long startTime = System.currentTimeMillis();
        int iterations = 1000000;
        for (int i = 0; i < iterations; i++) {
            double result = doComplexMath();
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("执行 " + iterations + " 次复杂数学运算共耗时：" + elapsedTime + " 毫秒");
    }

    public double doComplexMath() {
        return Math.exp(Math.cos(Math.sin(Math.PI * 5)));
    }

    @Test
    public void test92111sds22() {
        char[] charArray = { '1', '0', '1', '0' };
        int result = bitsToUnsignedDecimal(charArray);
        System.out.println("The unsigned decimal number is: " + result);

    }

    @Test
    public void test92111sds222() {
        String incrementLastNumber = incrementLastNumber("12hehe459");
        System.out.println(incrementLastNumber);

    }

    public static String incrementLastNumber(String input) {
        if (input == null || input.isEmpty()) {
            return input; // 或者返回空字符串、抛出异常等
        }

        // 从后向前查找第一个非数字字符的索引
        int lastIndex = input.length() - 1;
        while (lastIndex >= 0 && Character.isDigit(input.charAt(lastIndex))) {
            lastIndex--;
        }

        // 如果没有找到非数字字符（整个字符串都是数字）
        if (lastIndex == -1) {
            // 直接将字符串转换为整数加一并返回
            return String.valueOf(Integer.parseInt(input) + 1);
        }

        // 提取末尾的数字部分
        String numberStr = input.substring(lastIndex + 1);
        int number = Integer.parseInt(numberStr);

        // 将数字加一并转换为字符串
        String incrementedNumberStr = String.valueOf(number + 1);

        // 如果原始字符串包含非数字字符，将它们与新的数字字符串拼接起来
        return input.substring(0, lastIndex + 1) + incrementedNumberStr;
    }

    public static int bitsToUnsignedDecimal(char[] charArray) {
        int decimalNumber = 0;
        for (char c : charArray) {
            // 将字符 '0' 或 '1' 转换为对应的整数值 0 或 1
            int bitValue = c - '0';
            // 将当前位的值加到结果上，注意这里使用了位移操作来避免溢出
            decimalNumber = (decimalNumber << 1) | bitValue;
        }
        return decimalNumber;
    }

    @Test
    public void test9211122() {

        ByteBuffer bytebuffer = ByteBuffer.allocate(2);
        bytebuffer.putShort((short) 500);
        byte[] array = bytebuffer.array();

        byte[] bytes = { 23, 4, 7, 4, 5, 6, 0, 0 };

        bytes[6] = array[0];
        bytes[7] = array[1];

        ByteBuffer bytebuffer2 = ByteBuffer.wrap(bytes);

        System.out.println(bytebuffer2.getLong());

    }

    @Test
    public void test92111() {
        Double valueOf = Double.valueOf("3.14");
        System.out.println(valueOf);

        Double valueOf1 = Double.valueOf("180000000");
        System.out.println(valueOf1);

    }

    @Test
    public void test9211() {
        long nowTime = System.currentTimeMillis();
        System.out.println(nowTime - ((nowTime + TimeZone.getDefault().getRawOffset()) % (24 * 60 * 60 * 1000L)));
    }

    @Test
    public void test921() throws InterruptedException {
        // 创建并开启1000个线程
        for (int i = 0; i < 1000; i++) {
            // 每个线程每10ms写入一次数据
            new Thread(() -> {
                try {
                    // 数据写入(每个线程写入100不同的key)

                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(1000000);

    }

    void writeRedis() {

    }

    @Test
    public void nsd() {
        Double.valueOf("2").doubleValue();

    }

    @Test
    public void name22s2131111123() {
        int[][] arr = new int[2][3];
        // System.out.println(arr);
        System.out.println(arr.length);
        System.out.println("hehe");

    }

    @Test
    public void name22s21311111() {

        String valueOf = String.valueOf("/L");
        System.out.println(valueOf);

        int i = 0;
        i++;
        System.out.println(i);
        System.out.println(1.7E3);

        // int parseInt = Integer.decode("aa");
        int parseInt2 = Integer.decode("0xaa");
        int parseInt3 = Integer.parseInt("aa", 16);
        // int parseInt4 = Integer.parseInt("0xaa", 16);

        // System.out.println(parseInt);
        System.out.println(parseInt2);
        System.out.println(parseInt3);
        // System.out.println(parseInt4);

    }

    private String getOneDecimalDouble(String s) {
        Double valueOf = Double.valueOf(s);
        BigDecimal setScale = BigDecimal.valueOf(valueOf).setScale(1, RoundingMode.HALF_UP);

        return setScale.toString();

    }

    // 保留一位小数
    @Test
    public void name22s21311112() {

        String a = "100";

        String b = "100.4";

        String c = "100.5";

        String d = "100.51";

        String e = "100.56";

        System.out.println(getOneDecimalDouble(a));
        System.out.println(getOneDecimalDouble(b));
        System.out.println(getOneDecimalDouble(c));
        System.out.println(getOneDecimalDouble(d));
        System.out.println(getOneDecimalDouble(e));

    }

    /**
     * 超过3位使用科学计数法
     */
    @Test
    public void name22s2131111() {

        double a = 100.0;
        double b = a / 1000000.0;
        System.out.println(b);

    }

    /**
     * 科学计数法
     */
    @Test
    public void name22s21311() {

        Double double1 = new Double(444 / 1000000.0);
        System.out.println(double1);

        String valueOf = String.valueOf(new Double(444 / 1000000.0));
        System.out.println(valueOf);

        String valueOf1 = String.valueOf(new Double(0.000444));
        System.out.println(valueOf1);

        Double valueOf2 = Double.valueOf("4.44E-4");
        System.out.println(valueOf2);

        BigDecimal bigDecimal = new BigDecimal("4.44E-4");
        System.out.println(bigDecimal);

    }

    /**
     * System.getProperty("user.dir")
     */
    @Test
    public void name22s2131() {
        String rootPath = System.getProperty("user.dir");
        System.out.println(rootPath);
    }

    /**
     * "" + null
     */
    @Test
    public void name22s213() {
        System.out.println("" + null);
        System.out.println(null + "");
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

    // /**
    // * Hutool序列化深拷贝
    // */
    // @Test
    // public void name9() {
    // CloneStudent xiaoming = new CloneStudent("小明");
    // CloneStudent xiaowang = new CloneStudent("小王", xiaoming);
    // CloneStudent xiaowang2 = ObjectUtil.cloneByStream(xiaowang);
    // System.out.println(xiaowang);
    // System.out.println(xiaowang2);
    // xiaowang.getFavoriteClassmate().setName("小小明");
    // System.out.println(xiaowang);
    // System.out.println(xiaowang2);
    // }

    /**
     * 普通内部类不能直接序列化,
     * 可以让外部类继承序列化接口,
     * 或者改成静态内部类
     * 才可以序列化
     */
    // @Test
    // public void name10() throws Exception {
    // // hutool
    // User u = new User();
    // u.setName("li");
    // System.out.println(u);
    // User u2 = ObjectUtil.cloneByStream(u);
    // System.out.println(u2);

    // // 手写
    // ObjectOutputStream oos = new ObjectOutputStream(new
    // FileOutputStream("C:\\Users\\lwq\\Desktop\\u.bin", false));
    // oos.writeObject(u);
    // oos.flush();
    // oos.close();
    // // 反序列化到对象
    // ObjectInputStream ois = new ObjectInputStream(new
    // FileInputStream("C:\\Users\\lwq\\Desktop\\u.bin"));
    // User u3 = (User) ois.readObject();
    // ois.close();
    // System.out.println(u3);

    // }

    @Data
    @ToString
    class User implements Serializable {
        String name;
        String age;
    }

}
