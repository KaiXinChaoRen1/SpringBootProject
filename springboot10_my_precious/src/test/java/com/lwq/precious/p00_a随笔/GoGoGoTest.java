package com.lwq.precious.p00_a随笔;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GoGoGoTest {

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

    @Test
    public void name4() {
        System.out.println("3/2=" + 3 / 2);
        System.out.println("2/3=" + 2 / 3);
        System.out.println("3%2=" + 3 % 2);
        System.out.println("2%3=" + 2 % 3);
        System.out.println((double) 2 / 3);
    }

    /**
     * 拷贝练习,实体类
     * clone要实现Cloneable接口并重写方法
     * 序列化深克隆的方式需要实现Serializable
     */
    @Data
    class Student implements Cloneable, Serializable {

        String name;
        Student favoriteClassmate;

        public Student(String name) {
            this.name = name;
        }

        public Student(String name, Student favoriteClassmate) {
            this.name = name;
            this.favoriteClassmate = favoriteClassmate;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", favoriteClassmate=" + favoriteClassmate + "]";
        }

    }

    /**
     * clone浅拷贝
     */
    @Test
    public void name5() throws CloneNotSupportedException {
        Student xiaoming = new Student("小明");
        Student xiaowang = new Student("小王", xiaoming);

        Student xiaowang2 = (Student) xiaowang.clone();

        System.out.println(xiaowang);
        System.out.println(xiaowang2);
        xiaowang.getFavoriteClassmate().setName("小小明");
        System.out.println(xiaowang);
        System.out.println(xiaowang2);

    }

    /**
     * 通过序列化深拷贝
     */
    @Test
    public void name6() throws FileNotFoundException, IOException, ClassNotFoundException {
        Student xiaoming = new Student("小明");
        Student xiaowang = new Student("小王", xiaoming);

        // 序列化到文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\新建文件夹", false));
        oos.writeObject(xiaowang);
        oos.flush();
        oos.close();

        // 反序列化到对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\新建文件夹"));
        Student xiaowang2 = (Student) ois.readObject();
        ois.close();

        System.out.println(xiaowang);
        System.out.println(xiaowang2);
        xiaowang.getFavoriteClassmate().setName("小小明");
        System.out.println(xiaowang);
        System.out.println(xiaowang2);
    }

    /**
     * hutool工具类实现深拷贝(前提是对象必须实现Serializable接口)
     */
    @Test
    public void name7() {
        Student xiaoming = new Student("小明");
        Student xiaowang = new Student("小王", xiaoming);
        Student xiaowang2 = ObjectUtil.cloneByStream(xiaowang); 
        System.out.println(xiaowang);
        System.out.println(xiaowang2);
        xiaowang.getFavoriteClassmate().setName("小小明");
        System.out.println(xiaowang);
        System.out.println(xiaowang2);
    }
}
