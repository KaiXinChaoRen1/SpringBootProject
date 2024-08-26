package com.lwq.springboot01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAop {

    @Around("execution(public * com.lwq.springboot01.controller..*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("controller包方法 {} 执行完成，耗时: {} 毫秒",
                joinPoint.getSignature().getName(), (end - start));
        return result;
    }
}
