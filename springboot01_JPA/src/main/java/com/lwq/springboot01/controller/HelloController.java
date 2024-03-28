package com.lwq.springboot01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot01.entity.yanTest.A;
import com.lwq.springboot01.entity.yanTest.ADao;
import com.lwq.springboot01.entity.yanTest.BDao;
import com.lwq.springboot01.service.LayersService;

@RestController
public class HelloController {

    @Autowired
    private LayersService layersService;

    @Autowired
    ADao aDao;

    @Autowired
    BDao bDao;

    @GetMapping("/")
    public String hehe() {
        A build = A.builder().id(12).name("aaa").build();
        aDao.save(build);
        return "我家大门常打开,开放怀抱等你";
    }

    /**
     * JPA父子结构
     * 保存数据
     */
    @GetMapping("/hehe5")
    public String hehe5() {
        layersService.testMoreLayers();
        return "看控制台";
    }

    /**
     * 查询数据
     */
    @GetMapping("/hehe6")
    public String hehe6() {
        layersService.testMoreLayers2();
        return "看控制台";
    }

}
