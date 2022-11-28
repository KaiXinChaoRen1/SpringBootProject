package com.lwq.springboot20_webflux.router;

import com.lwq.springboot20_webflux.handler.HelloHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HelloRouter {

    @Autowired
    private HelloHandler helloHandler;  //报红不用管
    @Bean
    public RouterFunction<ServerResponse> routeCity() {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        helloHandler::helloWorld);
    }
}
