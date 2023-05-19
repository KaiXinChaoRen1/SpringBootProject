package com.lwq.springboot20_webflux.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot20_webflux.service.TestService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Mono(返回0或1个元素)
 * Flux(返回0-n个元素)
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    TestService testService;

    //zip
    @GetMapping("/zip")
    public Mono<String> name() {

        return Mono.zip(testService.serviceMethod1(), testService.serviceMethod2())
                .map(o -> o.getT1() + o.getT2()+"333444555");
    }

    // 阻塞5秒钟
    private String createStr() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        return "heheheheh~~~~~~~~~~";
    }

    // 普通的SpringMVC方法
    @GetMapping("/1")
    private String get1() {
        log.info("get1 start");
        String result = createStr();
        log.info("get1 end.");
        return result;
    }

    // WebFlux(注意返回值 返回的是Mono ，注意控制台打印的日志时间,直接打印end,说明是异步处理)
    @GetMapping("/2")
    private Mono<String> get2() {
        log.info("get2 start");
        Mono<String> result = Mono.fromSupplier(() -> createStr());
        log.info("get2 end.");
        return result;
    }

    /**
     * Flux : 返回0-n个元素
     * 注：需要指定MediaType
     *
     * @return
     */
    @GetMapping(value = "/3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<String> flux() {
        Flux<String> result = Flux
                .fromStream(IntStream.range(1, 5).mapToObj(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    String res = "flux data--" + i;
                    System.out.println(res);
                    return res;
                }));
        return result;
    }

}
