package com.lwq.precious.p00_a随笔;

import java.io.*;
import java.util.ArrayList;

import com.lwq.precious.model.CloneStudent;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GoGoGoTest implements Serializable {


    /**
     * lambda表达式里不能修改外部的普通变量,想要访问可以放到数组里
     */
    @Test
    public void name13() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);  //ctrl+d复制上一行
        integers.add(2);
        integers.add(3);
//        boolean b=false;
//        integers.forEach(i->{
//            if(i==3){
//                b=true;     //报错:Variable used in lambda expression should be final or effectively final
//            }
//        });
        boolean[] b = new boolean[]{false};
        integers.forEach(i -> {
            if (i == 3) {
                b[0] = true;
            }
        });
        System.out.println(b[0]);
    }


    /**
     * Long包装类对比
     */
    @Test
    public void name1() {
        Long l = 100L;

        System.out.println(l == 100);
        System.out.println(l.equals(100));
        System.out.println(l.longValue() == 100);

        Long l2 = 100L;
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
     * ====>'%' 和 '/'
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


        //removeAll
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
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\lwq\\Desktop\\student.bin", false));
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
        //hutool
        User u = new User();
        u.setName("li");
        System.out.println(u);
        User u2 = ObjectUtil.cloneByStream(u);
        System.out.println(u2);

        //手写
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
