package com.lwq.precious.p05_Hutool;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import lombok.Data;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HutoolTest {
    /**
     * 玩一下浅拷贝,跟Hutool没关系
     */
    @Test
    public void name() {

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("1", "hehe");

        ArrayList<Map<String, String>> strList = new ArrayList<Map<String, String>>();
        strList.add(hashMap);
        System.out.println("原始数据==>" + strList);
        ArrayList<Map<String, String>> cloneList = (ArrayList) strList.clone();
        System.out.println("克隆数据==>" + cloneList);
        cloneList.get(0).put("1", "HAHA");

        System.out.println("仅修改克隆数据==>" + cloneList);
        System.out.println("原始数据==>" + strList);
    }

    /**
     * Hutool工具类反射调用私有方法
     */
    @Test
    public void name1() {
        Method method = ReflectUtil.getMethod(Student.class, "cry");
        Student newInstance = ReflectUtil.newInstance(Student.class);
        ReflectUtil.invoke(newInstance, method, null);
    }

    /**
     * 雪花算法
     */
    @Test
    public void name2() {
        // 参数1为终端ID
        // 参数2为数据中心ID(不懂,分布式会用?)
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id = snowflake.nextId();
        System.out.println(id);
    }

    /**
     * 判断基本类型,包括原始类和包装类
     */
    @Test
    public void name3() {
        String str = "hehe";
        int i = 1;
        Integer integer = 1;
        System.out.println(ObjectUtil.isBasicType(str));
        System.out.println(ObjectUtil.isBasicType(i));
        System.out.println(ObjectUtil.isBasicType(integer));
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
     * hutool工具类实现深拷贝(前提是对象必须实现Serializable接口)
     */
    @Test
    public void name4() {
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
