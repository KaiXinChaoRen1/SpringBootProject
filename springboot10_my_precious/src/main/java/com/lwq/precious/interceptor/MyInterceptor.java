package com.lwq.precious.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



//@Component  不加这个在配置类里直接new写的代码更少
public class MyInterceptor implements HandlerInterceptor { // default修饰的方法使之可以有方法体,所以我们无需实现也不报错

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("我是preHandle,我在执行控制器方法前执行");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("我是postHandle,我在执行控制器方法后执行");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        System.out.println("我是afterCompletion,我在请求完成后执行");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
