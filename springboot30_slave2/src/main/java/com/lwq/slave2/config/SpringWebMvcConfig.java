package com.lwq.slave2.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // 如果使用第一种这个注解一定需要去除掉
public class SpringWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // ObjectMapper objectMapper = new ObjectMapper();
        // SimpleModule simpleModule = new SimpleModule();
        // simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        // simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        // simpleModule.addSerializer(Date.class, new DateFormatSerializer());
        // objectMapper.registerModule(simpleModule);
        // converter.setObjectMapper(objectMapper);

        converters.add(converter);
    }

}
