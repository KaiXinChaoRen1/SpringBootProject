package com.lwq.controller;


import com.lwq.domain.People;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/test")
public class vuecontroller {

    @GetMapping("/get/{username}")
    public String test(@PathVariable String username) {
        //获取请求参数
        String myname=username;

        if(myname.equals("李文强")==true){
            return myname+"少主，三年之期已到，老爷让你回家继承百亿家产(get)";
        }
        else {
            return myname+"，快给我滚蛋，小心揍你(get)";

        }
    }
    /*@PostMapping("/post/{username}")
    public String test2(@PathVariable String username) {}*/

    @PostMapping("/post")
    public String test2(String name) {      //直接可以获取请求体里的参数（名字要一样）
        //获取请求参数
        String myname=name;

        if(myname.equals("李文强")==true){
            return myname+"少主，三年之期已到，老爷让你回家继承百亿家产(post)";
        }
        else {
            return myname+"，快给我滚蛋，小心揍你(post)";

        }
    }

    @GetMapping("/all")
    public ArrayList<People> test3(){
        People p1 = new People("王思聪", 30);
        People p2 = new People("李文强少主", 30);
        People p3 = new People("爱因斯坦", 30);
        ArrayList<People> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        return list;
    }

/*    @PostMapping("/test")       //直接可以获取请求体里的参数，并封装成对象
    public String test4(String name,int age){       //请求体里的参数名要和这里的参数名一样
        People people = new People(name, age);
        String eat = people.eat();
        return eat+"（接受post请求体里的两个参数）";
    }*/

    @PostMapping("/test")       //直接可以获取请求体里的参数，并封装成对象
    public String test4(People myp){
        return "(直接封装成对象)"+myp.eat();
    }

}
