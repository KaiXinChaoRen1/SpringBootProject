// package com.lwq.jk2_JPA.multiTenancy;

// import java.util.HashMap;
// import java.util.Map;

// import javax.sql.DataSource;

// import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

// @Configuration
// public class HibernateConfig {
// @Bean
// public LocalContainerEntityManagerFactoryBean
// entityManagerFactory(EntityManagerFactoryBuilder builder,
// DataSource dataSource) {
// return builder
// .dataSource(dataSource)
// .packages("com.lwq.jk2_JPA.entity") // 实体类所在包
// .properties(hibernateProperties())
// .build();
// }

// private Map<String, Object> hibernateProperties() {
// Map<String, Object> properties = new HashMap<>();
// properties.put("hibernate.physical_naming_strategy",
// "com.lwq.jk2_JPA.multiTenancy.CustomPhysicalNamingStrategy");
// return properties;
// }
// }
