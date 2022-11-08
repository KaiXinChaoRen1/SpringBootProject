package com.lwq.springboot01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lwq.springboot01.Entity.schoolstory.Person;

/**
 * proxyBeanMethods属性默认为true，
 * 如果通过直接获取这个配置类对象，再直接调用方法来return的对象，spring会检查IOC容器并返回容器中的对象
 * （1）如果组件间有依赖关系应该使用true，保证组件都是ioc中的
 * （2）如果组件间没有依赖关系应该使用false，不用检查，启动快
 */
@Configuration(proxyBeanMethods = false)
public class MyConfig {
    @Bean
    public Person p1() {
        Person p1 = Person.builder().name("李连杰").age(59).build();
        return p1;
    }
}
