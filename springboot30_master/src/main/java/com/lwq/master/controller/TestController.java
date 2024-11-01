package com.lwq.master.controller;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.master.feign.MyFeginService;
import com.lwq.master.service.TestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "@Api(tags=\"hello\")")
@RestController
@RequestMapping("/")
@Slf4j
public class TestController {

    @Autowired
    MyFeginService myFeginService;

    @Autowired
    TestService testService;

    @ApiOperation(value = "put请求测试")
    @GetMapping("/asynStudy2")
    public Object asynStudy2() {
        long time1 = System.currentTimeMillis();
        Object res = testService.asynStudy2();

        long time2 = System.currentTimeMillis();
        System.out.println("用时" + (time2 - time1));
        return res;
    }

    @ApiOperation(value = "asynStudy")
    @GetMapping("/asynStudy")
    public Object asynStudy() {
        long time1 = System.currentTimeMillis();
        Object res = testService.asynStudy();

        long time2 = System.currentTimeMillis();
        System.out.println("用时" + (time2 - time1));
        return res;
    }

    @ApiOperation(value = "asynCalculate")
    @GetMapping("/asynCalculate")
    public Object asynCalculate() {
        long time1 = System.currentTimeMillis();
        Object res = testService.asynCalculate();
        long time2 = System.currentTimeMillis();
        System.out.println("用时" + (time2 - time1));
        return res;
    }

    @ApiOperation(value = "loopCalculate")
    @GetMapping("/loopCalculate")
    public Object loopCalculate() {
        long time1 = System.currentTimeMillis();
        Object res = testService.loopCalculate();
        long time2 = System.currentTimeMillis();
        System.out.println("用时" + (time2 - time1));
        return res;
    }

    /*
     * URI
     * :http://127.0.0.1:7789
     */
    @ApiOperation(value = "dohehe1")
    @GetMapping("/dohehe1")
    public Object dohehe1(@RequestParam String uriStr) throws URISyntaxException {
        Object res = myFeginService.doHehe1(uriStr);
        return res;
    }

    @ApiOperation(value = "dohehe2")
    @GetMapping("/dohehe2")
    public Object dohehe2() throws URISyntaxException {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("node1", "http://127.0.0.1:7788");
        hashMap.put("node2", "http://127.0.0.1:7789");

        String resStr = new String();
        for (Entry<String, String> entry : hashMap.entrySet()) {
            Object res = myFeginService.doHehe1(entry.getValue());
            resStr = resStr + entry.getKey() + ":" + res.toString() + "\n";

        }

        return resStr;
    }

}
