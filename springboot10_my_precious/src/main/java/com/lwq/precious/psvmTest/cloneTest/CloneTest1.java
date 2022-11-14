package com.lwq.precious.psvmTest.cloneTest;

import lombok.Data;

import java.io.*;
/**
 * 通过序列化深拷贝
 */
public class CloneTest1 {
    public static void main(String[] args) throws Exception {

        Student xiaoming = new Student("小明");
        Student xiaowang = new Student("小王", xiaoming);

        // 序列化到文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\lwq\\Desktop\\student.bin", false));
        oos.writeObject(xiaowang);
        oos.flush();
        oos.close();

        // 反序列化到对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\lwq\\Desktop\\student.bin"));
        Student xiaowang2 = (Student) ois.readObject();
        ois.close();

        System.out.println(xiaowang);
        System.out.println(xiaowang2);
        xiaowang.getFavoriteClassmate().setName("小小明");
        System.out.println(xiaowang);
        System.out.println(xiaowang2);

    }
}



