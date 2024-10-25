package com.lwq.strategy_pattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.strategy_pattern.StrategyContext;
import com.lwq.strategy_pattern.StrategyInterface;

@RestController
public class TestController {

    @Autowired
    StrategyContext StrategyContext;

    @GetMapping("/test")
    public String hehe(@RequestParam String type) {
        StrategyInterface resource = StrategyContext.getResource(type);

        return resource.doOperation();
    }

}
