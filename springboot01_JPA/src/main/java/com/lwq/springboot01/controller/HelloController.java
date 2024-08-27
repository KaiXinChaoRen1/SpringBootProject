package com.lwq.springboot01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot01.entity.yanTest.A;
import com.lwq.springboot01.entity.yanTest.ADao;
import com.lwq.springboot01.entity.yanTest.BDao;
import com.lwq.springboot01.service.LayersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "父子结构测试")
@RestController
public class HelloController {

    @Autowired
    private LayersService layersService;

    @Autowired
    ADao aDao;

    @Autowired
    BDao bDao;

    @ApiOperation(value = "测试热部署")
    @GetMapping("/hehe5222")
    public String hehe2225() {

        return "haha111222";
    }

    /**
     * JPA父子结构
     * 保存数据
     */

    @ApiOperation(value = "添加数据")
    @GetMapping("/hehe5")
    public String hehe5() {
        layersService.testMoreLayers();
        return "看控制台";
    }

    @ApiOperation(value = "添加数据(事务)")
    @GetMapping("/hehe55")
    public String hehe55() {
        layersService.testMoreLayerss();
        return "看控制台";
    }

    /**
     * 查询数据
     */

    @ApiOperation(value = "查询父")
    @GetMapping("/hehe6")
    public String hehe6() {
        A testMoreLayers2 = layersService.testMoreLayers2();
        return testMoreLayers2.toString();
    }

    @ApiOperation(value = "删除父")
    @GetMapping("/hehe7")
    public String hehe7() {
        layersService.deleteParent();
        return "";
    }

    @ApiOperation(value = "删除子")
    @GetMapping("/hehe8")
    public String hehe8() {
        layersService.deleteChild();
        return "";
    }

    @ApiOperation(value = "一个事务内  持续save数据 并持续find数据")
    @GetMapping("/saveAndFindInOneTransaction")
    public String saveAndFindInOneTransaction() {
        layersService.saveAndFindInOneTransaction();
        return "";
    }
}
