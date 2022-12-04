package com.lwq.precious.controller;

import com.lwq.precious.model.SysUser;
import com.lwq.precious.utils.UserHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/thread")
public class ThreadLocalController {

    private  static Long count=0l;


    @GetMapping("/test1")
    public Object test1(){
        SysUser sysUser = new SysUser(count++, LocalDateTime.now());
        UserHolder.saveUser(sysUser);
        return UserHolder.getUser();
    }

    /**
     * 会获取到不一定哪个user,难道是因为线程服用?
     */
    @GetMapping("/test2")
    public Object test2(){
        return UserHolder.getUser();
    }

}
