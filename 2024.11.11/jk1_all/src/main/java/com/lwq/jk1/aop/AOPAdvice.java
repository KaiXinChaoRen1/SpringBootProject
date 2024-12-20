package com.lwq.jk1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPAdvice {

    @Pointcut("@annotation(com.lwq.jk1.aop.TimeLog)")
    public void pt2() {
    }

    @Around("pt2()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable { // 当我们使用 环绕通知 @Around
                                                                     // 作为通知类型时，会使用ProceedingJoinPoint这个连接点
        System.out.println("环绕前around before...");
        Object ret = pjp.proceed();
        System.out.println("环绕后around after...");
        return ret;

    }

}
