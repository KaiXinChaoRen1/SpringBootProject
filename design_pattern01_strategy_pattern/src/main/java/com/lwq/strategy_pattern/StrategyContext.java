package com.lwq.strategy_pattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StrategyContext {

    private final Map<String, StrategyInterface> strategyMap = new ConcurrentHashMap<>();

    public StrategyContext(Map<String, StrategyInterface> map) {
        map.forEach(this.strategyMap::put);
    }

    public StrategyInterface getResource(String type) {
        if (!strategyMap.containsKey(type)) {
            throw new RuntimeException("未找到类型是" + type + "的策略");
        }
        return strategyMap.get(type);
    }
}
