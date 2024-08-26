package com.lwq.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnAopCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String enableAop = context.getEnvironment().getProperty("aop.enabled");
        return "true".equalsIgnoreCase(enableAop);
    }

}
