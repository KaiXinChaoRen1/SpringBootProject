package com.lwq.precious.p05_Hutool;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.precious.model.Student;

import cn.hutool.core.util.ReflectUtil;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HutoolTest {
    /**
     * 玩一下浅拷贝,跟Hutool没关系
     */
    @Test
    public void name() {
       
        HashMap<String, String> hashMap = new HashMap<String,String>();
        hashMap.put("1", "hehe");

        ArrayList<Map<String, String>> strList = new ArrayList<Map<String, String>>();
        strList.add(hashMap);
        System.out.println("原始数据==>"+strList);
        ArrayList<Map<String, String>> cloneList = (ArrayList)strList.clone();
        System.out.println("克隆数据==>"+cloneList);
        cloneList.get(0).put("1", "HAHA");

        System.out.println("仅修改克隆数据==>"+cloneList);
        System.out.println("原始数据==>"+strList);
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

}
