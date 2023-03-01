package com.lwq.precious.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.precious.exception.PromptException;
import com.lwq.precious.model.EnumVo;
import com.lwq.precious.model.Season;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "乱七八糟测试Controller")
@RestController
@Slf4j
public class TestController {

    @ApiOperation("Vo封装枚举类传参")
    @GetMapping("/test6")
    public void name6(@RequestBody EnumVo enumVo) {
        Season season = enumVo.getSeason();
        System.out.println(season);
        System.out.println(season.toString());
        System.out.println(season.getClass());
        
        System.out.println(season.getSeasonName());
        System.out.println(enumVo.getStr());
    }

    @ApiOperation("单个枚举类传参")
    @GetMapping("/test5")
    public void name5(@RequestBody Season season) {
        System.out.println(season.getSeasonName());
    }

    @GetMapping("/test4")
    public void name4() {
        try {
            fail();
        } catch (Exception e) {
            log.error("", e);
        }

    }

    public void fail() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new RuntimeException("我是自定义运行时错误", e);
        }
    }

    /**
     * 测试 return 与try catch
     */
    @GetMapping("/test3")
    public String name3() {
        try {
            System.out.println("我执行了");
            // int i = 1 / 0;
            return "我家大门常打开";
        } catch (Exception e) {
            e.printStackTrace();
            // return "111";
        }
        return "2222222"; // 看上去和111差不多
    }

    @GetMapping("/test2")
    public String name2() {
        System.out.println("test2执行了");
        return "我家大门常打开";
    }

    @GetMapping("/testException")
    public String testException() {
        if (1 < 2) {
            throw new RuntimeException("我是异常,芜湖芜湖~~");
        }
        return "我家大门常打开";
    }


    @GetMapping("/testException2")
    public String testException2() {
        if (1 < 2) {
            throw new PromptException("我是异常,芜湖芜湖~~");
        }
        return "我家大门常打开";
    }
    @GetMapping("/test")
    public String name() {
        System.out.println("test执行了");
        return "我家大门常打开";
    }

}
