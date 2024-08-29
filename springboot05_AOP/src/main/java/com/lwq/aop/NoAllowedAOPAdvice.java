package com.lwq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.lwq.annotation.NoAllowed;
import com.lwq.annotation.OnAopCondition;

@Component
@Aspect
public class NoAllowedAOPAdvice {

    // ********************************************注解AOP****************

    @Pointcut("@annotation(com.lwq.annotation.NoAllowed)")
    public void ptNoAllowed() {
    }

    @Before("ptNoAllowed()")
    public void beforeNoAllowed(JoinPoint joinPoint) {
        System.out.println("before");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        NoAllowed noAllowed = signature.getMethod().getAnnotation(NoAllowed.class);
        String[] requiredStatuses = noAllowed.value();

        for (int i = 0; i < requiredStatuses.length; i++) {
            if ("hehe".equals(requiredStatuses[i])) {
                throw new RuntimeException("不允许的操作hehe");
            }
        }

    }

}
