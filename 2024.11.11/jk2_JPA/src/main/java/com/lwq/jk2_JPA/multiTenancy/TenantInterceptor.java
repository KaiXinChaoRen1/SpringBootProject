// package com.lwq.jk2_JPA.multiTenancy;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// @Component
// public class TenantInterceptor extends HandlerInterceptorAdapter {

// @Override
// public boolean preHandle(HttpServletRequest request, HttpServletResponse
// response, Object handler)
// throws Exception {
// String tenantId = request.getHeader("X-Tenant-ID"); // 从请求头中获取租户ID
// if (tenantId != null) {
// TenantContext.setCurrentTenant(tenantId);
// }
// return true;
// }

// @Override
// public void afterCompletion(HttpServletRequest request, HttpServletResponse
// response, Object handler, Exception ex)
// throws Exception {
// TenantContext.clear();
// }
// }
