package com.lwq.jk2_JPA.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.boot.model.naming.Identifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lwq.jk2_JPA.multiTenancy.CustomPhysicalNamingStrategy;
import com.lwq.jk2_JPA.multiTenancy.TenantContext;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAop {

    // @Around("execution(public * com.lwq.jk2_JPA.controller..*.*(..))")
    // public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws
    // Throwable {
    // long start = System.currentTimeMillis();
    // Object result = joinPoint.proceed();
    // long end = System.currentTimeMillis();
    // log.info("controller包方法 {} 执行完成，耗时: {} 毫秒",
    // joinPoint.getSignature().getName(), (end - start));
    // return result;
    // }

    @Before("execution(public * com.lwq.jk2_JPA.controller..*.*(..))")
    public void setTenantBeforeController(JoinPoint joinPoint) {
        // 获取 HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 从请求体或请求头中获取租户名称
        String tenant = request.getHeader("X-Tenant-ID"); // 示例：从请求头中获取
        if (tenant == null || tenant.isEmpty()) {
            throw new IllegalArgumentException("Tenant ID is missing in the request!");
        }

        // 设置租户上下文
        TenantContext.setCurrentTenant(tenant);
    }

    @After("execution(public * com.lwq.jk2_JPA.controller..*.*(..))")
    public void clearTenantAfterController() {
        // 清除租户上下文，防止线程污染
        TenantContext.clear();
    }
}
