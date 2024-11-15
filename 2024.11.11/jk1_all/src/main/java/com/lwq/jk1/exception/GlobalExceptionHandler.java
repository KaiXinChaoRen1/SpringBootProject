package com.lwq.jk1.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 优先处理空指针异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(value = { NullPointerException.class })
    @ResponseBody
    public Object nullPointerExceptionHandler(HttpServletRequest request, NullPointerException e) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.error("发生空指针异常，请求地址：{}, 错误信息：{}", request.getRequestURI(), e.getMessage());
        return "发生异常请查看控制台日志";
    }

    /**
     * 兜底处理其它异常
     * 
     * @param e
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = { Exception.class })
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request, Exception e) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();

        log.error("未知异常，请求地址：{}, 错误信息：{}", request.getRequestURI(), e.getMessage());
        return "发生异常请查看控制台日志";
    }
}
