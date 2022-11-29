package com.lwq.precious.p05_Hutool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.lwq.precious.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
     * 反射
     * Hutool工具类调用私有方法
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

}
