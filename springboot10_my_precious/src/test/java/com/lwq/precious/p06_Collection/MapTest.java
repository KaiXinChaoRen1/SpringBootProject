package com.lwq.precious.p06_Collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MapTest {
    @Test
    public void name1() {
        HashMap<String, String> myMap = new HashMap<String,String>();
        myMap.put("1", "hehe");
        myMap.put("2", "haha");
        myMap.put("3", "xixi");
        //获取所有key
        Set<String> keySet = myMap.keySet();
        System.out.println(keySet);
        //获取所有value
        Collection<String> values = myMap.values();
        System.out.println(values);
        System.out.println(values.getClass());
    }

    @Test
    public void name2() {
        HashMap<String, String> myMap = new HashMap<String,String>();
        myMap.put("1", "hehe");
        myMap.put("2", "haha");
        myMap.put("3", "xixi");

        myMap.replace("3", "--","雷霆半月斩");
        System.out.println(myMap);

        myMap.replace("3", "闪电旋风劈");
        System.out.println(myMap);

      
        myMap.remove("1");
        System.out.println(myMap);

        myMap.remove("2","??");
        System.out.println(myMap);

        myMap.remove("2","haha");
        System.out.println(myMap);


    }
}
