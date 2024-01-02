package com.lwq.strategy_pattern.service;

import org.springframework.stereotype.Service;

import com.lwq.strategy_pattern.StrategyInterface;

@Service("subtract")
public class SubtractService implements StrategyInterface{
    @Override
    public String doOperation() {
      return "执行了减法操作----";
    }
}
