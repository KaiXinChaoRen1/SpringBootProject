package com.lwq.precious.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 拷贝练习,实体类
 * clone要实现Cloneable接口并重写方法
 * 序列化深克隆的方式需要实现Serializable
 */
@Data
public class CloneStudent implements Cloneable, Serializable {

    String name;
    CloneStudent favoriteClassmate;

    public CloneStudent(String name) {
        this.name = name;
    }

    public CloneStudent(String name, CloneStudent favoriteClassmate) {
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
