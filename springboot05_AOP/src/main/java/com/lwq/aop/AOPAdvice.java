package com.lwq.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * execution()定义切点的方式有多种
 *  1.根据方法名
 *  2.根据类名
 *  3.根据包名
 *  具体查搜索引擎
 */
@Component
@Aspect
public class AOPAdvice {
    //@Pointcut("execution(* name1(..))")                           //根据方法名 ==>任意返回类型,方法名为name1,任意参数
    //@Pointcut("execution(* com.lwq.service.TestService.*(..))")   //根据类名   ==>任意返回类型,TestService类,任意方法,任意参数
    @Pointcut("execution(* com.lwq..*.*(..))")                      //根据包名   ==>任意返回类型,com.lwq包及其子包,任意类,任意方法,任意参数
    public void pt(){}


    @Before("pt()")
    public void before(){
        System.out.println("前置before...");
    }

    @After("pt()")
    public void after(){
        System.out.println("后置after...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前around before...");
        Object ret = pjp.proceed();
        System.out.println("环绕后around after...");
        return ret;
    }

    @AfterReturning("pt()")
    public void afterReturing(){
        System.out.println("返回后afterReturning...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        System.out.println("afterThrowing抛出异常后,有我殿后");
    }




}
