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
        // e.printStackTrace(); // 这样会打印在控制台而不是日志里
        // log.error(e.toString());// 只打印一行
        // log.error(e.getMessage());// 甚至只有半行
        log.error("", e);
        return "服务器内部异常: " + e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PromptException.class)
    public String handleException(PromptException e) {
        // 特定的自定义异常可以做特定的处理
        System.out.println("自定义异常特殊处理");
        log.error("", e);
        return "服务器内部异常: " + e.getMessage();
    }
}
