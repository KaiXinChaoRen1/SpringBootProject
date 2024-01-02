package com.lwq.strategy_pattern.service;

import org.springframework.stereotype.Service;

import com.lwq.strategy_pattern.StrategyInterface;

@Service("add")
public class AddService implements StrategyInterface{



    @Override
    public String doOperation() {
      return "执行了加法操作++++";
    }
    
}
