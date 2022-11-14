package com.lwq.precious.psvmTest.cloneTest;

import cn.hutool.core.util.ObjectUtil;

/**
 * hutool工具类实现深拷贝(前提是对象必须实现Serializable接口)
 */
public class CloneTest2 {
    public static void main(String[] args) {
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
