package com.lwq.demo.controller;


import com.lwq.demo.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello World!!";
    }

    @RequestMapping("/success")
    public String success(Map<String,String> map){
        map.put("hello","你好");
        return "success";           //导入thymelf坐标后，html放到template下就可以自动渲染
    }

    @RequestMapping("/success2")
    public String success2(Model m){
        List<Book> list=new ArrayList<>();
        Book  Hee= new Book();
        list.add(new Book(1001,"李文强自传"));
        list.add(new Book(1002,"李文强自传2"));
        list.add(new Book(1003,"李文强自传3"));
        list.add(new Book(1004,"那个男人"));
        m.addAttribute("bookList",list);
        return "success";
    }

    @RequestMapping("/hello")
    public ModelAndView success3(ModelAndView modelAndView , String id){
        modelAndView.addObject("key1","hello1");
        modelAndView.addObject("key2","hello2");

        System.out.println(id);//输出表单提交的值

        modelAndView.setViewName("hello");//把路径放入modelandview中

        return modelAndView;
    }
}
