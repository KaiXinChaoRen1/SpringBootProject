package com.lwq.precious.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
/*
 *全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        log.error("", e);
        return  "全局异常处理执行了-----"+e.getMessage();
    }
}
