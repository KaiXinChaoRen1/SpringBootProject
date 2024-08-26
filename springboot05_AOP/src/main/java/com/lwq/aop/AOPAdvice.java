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
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.lwq.annotation.OnAopCondition;

/**
 * execution()定义切点的方式有多种
 * 1.根据方法名
 * 2.根据类名
 * 3.根据包名
 * 具体查搜索引擎
 */
@Component
@Aspect
@Conditional(OnAopCondition.class)
public class AOPAdvice {

    // ********************************************注解AOP*****************
    @Pointcut("@annotation(com.lwq.annotation.LWQJudgment)") // 根据包名 ==>任意返回类型,com.lwq包及其子包,任意类,任意方法,任意参数
    public void pt2() {
    }

    @Before("pt2()")
    public void before2(JoinPoint jp) { // 当我们使用 环绕通知 @Around 作为通知类型时，会使用ProceedingJoinPoint这个连接点
        Object[] args = jp.getArgs();
        if (args[0] instanceof String) {
            System.out.println("入参是字符串类型");
        } else {
            System.out.println("入参不是字符串类型");
        }
    }

    // ********************************************常规AOP***************************

    // @Pointcut("execution(* name1(..))") //根据方法名 ==>任意返回类型,方法名为name1,任意参数
    @Pointcut("execution(* com.lwq.service.TestService.*(..))") // 根据类名 ==>任意返回类型,TestService类,任意方法,任意参数
    // @Pointcut("execution(* com.lwq.service..*.*(..))") // 根据包名
    // ==>任意返回类型,com.lwq.service包及其子包,任意类,任意方法,任意参数
    public void pt() {
    }

    @Before("pt()")
    public void before() {
        System.out.println("前置before...");
    }

    @After("pt()")
    public void after() {
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
    public void afterReturing() {
        System.out.println("返回后afterReturning...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        System.out.println("afterThrowing抛出异常后,有我殿后");
    }

    // ----------------------------------------------------------

    @Pointcut("execution(* com.lwq.myInterface.FuncInterface+.*(..))")
    public void pt3() {
    }

    @Before("pt3()")
    public void before3() {
        System.out.println("接口前置before...");
    }

    @Around("pt3()")
    public Object around3(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("接口环绕前around before...");
        Object ret = pjp.proceed();
        System.out.println("接口环绕后around after...");
        return ret;
    }

}
