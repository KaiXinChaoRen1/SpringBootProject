package com.lwq.precious.psvmTest.cloneTest;

/**
 * 实现Cloneable接口重写clone方法实现浅拷贝
 */
public class CloneTest0 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student xiaoming = new Student("小明");
        Student xiaowang = new Student("小王", xiaoming);

        Student xiaowang2 = (Student) xiaowang.clone();

        System.out.println(xiaowang);
        System.out.println(xiaowang2);
        xiaowang.getFavoriteClassmate().setName("小小明");
        System.out.println(xiaowang);
        System.out.println(xiaowang2);
    }
}
