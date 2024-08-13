package com.lwq.springboot02_init.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/logTest")
@Slf4j
public class LogTestController {
    @GetMapping("/1")
    public String hehe12() {
        log.debug("我是debug日志");
        log.info("我是info日志");
        log.warn("我是warn日志");
        log.error("我是error日志");

        return "success";
    }
}
