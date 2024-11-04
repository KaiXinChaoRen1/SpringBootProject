package com.lwq.slave2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfig {

        @Bean
        public OpenAPI springMemberOpenAPI() {
                return new OpenAPI()
                                .info(new Info().title("我的Infotitle")
                                                .description("我的description")
                                                .version("我的 versionv0.0.1")
                                                .license(new License().name("license name LWQ.CN 2.0")
                                                                .url("license_url_http://_lwq_springdoc.org")))
                                .externalDocs(
                                                new ExternalDocumentation()
                                                                .description("url_description ")
                                                                .url("https://lwqqqqqqqqqqqqqqqqqq.com"));

        }
}
