package com.lwq.springboot20_webflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 据说相当于Controller
 */
@Component
public class HelloHandler {

    public Mono<ServerResponse> helloWorld(ServerRequest request) {

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello,WebFlux"));
    }
}
