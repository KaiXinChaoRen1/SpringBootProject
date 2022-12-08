package com.lwq.precious.exception;

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
        // e.printStackTrace(); //这样会打印在控制台而不是日志里
        // log.error(e.toString());//只打印一行
        // log.error( e.getMessage());//甚至只有半行
        log.error("", e);

        return "全局异常处理执行了-----" + e.getMessage();
    }
}
