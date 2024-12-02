// package com.lwq.jk2_JPA.multiTenancy;

// import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
// import org.springframework.stereotype.Component;

// @Component
// public class TenantIdentifierResolver implements
// CurrentTenantIdentifierResolver {

// @Override
// public String resolveCurrentTenantIdentifier() {
// System.out.println("TenantIdentifierResolver已执行xxxxxxxxxxxxxxxx");
// String tenantId = TenantContext.getCurrentTenant(); // 从上下文中获取租户ID
// return tenantId != null ? tenantId : "default"; // 默认租户
// }

// @Override
// public boolean validateExistingCurrentSessions() {
// return true;
// }
// }
