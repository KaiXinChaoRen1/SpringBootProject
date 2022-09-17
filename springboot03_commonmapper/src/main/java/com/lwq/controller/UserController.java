package com.lwq.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwq.domain.User;
import com.lwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Model m,int thisp,int everyp) {
        //pagehelper
        PageHelper.startPage(thisp,everyp);

        List<User> all = userService.findAll();

        PageInfo pageInfo=new PageInfo(all);    //封装了分页相关参数的类

        m.addAttribute("userList", all);

        m.addAttribute("thispage", pageInfo.getPageNum());  //获取当前页
        m.addAttribute("prepage", pageInfo.getPrePage());   //获取上一页
        m.addAttribute("nextpage", pageInfo.getNextPage()); //获取下一页

        return "success";
    }

    @RequestMapping("/addUser")
    public String add(Integer id, String username, String password,String build,String util) {
        User myuser = new User(id, username, password,build,util);
        userService.addUser(myuser);
        return "redirect:findAll?thisp=0&everyp=3";

    }
    @RequestMapping("/updUser")
    public String upd(Integer id, String username, String password,String build,String util) {
        User myuser = new User(id, username, password,build,util);
        userService.updUser(myuser);
        return "redirect:findAll?thisp=0&everyp=3";

    }
    @RequestMapping("/delUser")
    public String del(Integer id,int thisp) {
        userService.delUser(id);
        return "redirect:findAll?thisp="+thisp+"&everyp=3";
    }


    @RequestMapping("/add")
    public String adds() {
        return "add";
    }

    @RequestMapping("/upd")
    public String upds(int thisp,Integer id,Model m) {
        m.addAttribute("idkey",id);
        m.addAttribute("thisp",thisp);
        return "upd";
    }

}
