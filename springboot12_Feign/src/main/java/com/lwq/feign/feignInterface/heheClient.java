package com.lwq.feign.feignInterface;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "user-service", url = "http://localhost:8080")
public interface heheClient {

    @PostMapping("/index/add2")
    public ResponseEntity<String> add2(@RequestParam("num") Integer num);

    @PostMapping("/index/add")
    public ResponseEntity<String> add(@RequestBody HashMap<String, String> map);
}
