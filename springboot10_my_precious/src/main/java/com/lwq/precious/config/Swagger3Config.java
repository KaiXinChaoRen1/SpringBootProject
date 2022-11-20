package com.lwq.precious.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 访问--> http://localhost:8080/swagger-ui/index.html
 */
@Configuration
public class Swagger3Config {
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(webApiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                //.groupName("无敌破坏王李文强的组")
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("<我是标题>")
                .description("我是描述..............")
                .contact(new Contact("天才李文强", "http://hehe.com", "hehe@hehe.com"))
                .version("'我是版本-v1.0.1'")
                .build();
    }


}
