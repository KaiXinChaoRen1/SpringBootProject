package com.lwq.master.service;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwq.master.feign.MyFeginService;
import com.lwq.master.utils.CountDownLatchUtils;
import com.lwq.master.utils.MyFunctionalInterface;

import com.lwq.master.vo.NodeVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestService {

    private ExecutorService executorPool = Executors.newFixedThreadPool(8);

    @Autowired
    MyFeginService myFeginService;

    public Object loopCalculate() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("node1", "http://127.0.0.1:7788");
        hashMap.put("node2", "http://127.0.0.1:7789");

        String resStr = new String();
        for (Entry<String, String> entry : hashMap.entrySet()) {
            try {
                Object res = myFeginService.calculate(entry.getValue(), 2, 4);
                resStr = resStr + entry.getKey() + ":" + res.toString() + "\n";
            } catch (Exception e) {
                log.error(entry.getKey() + "节点请求失败" + e.getMessage());
            }

        }

        return resStr;
    }

    public Object asynCalculate() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("node1", "http://127.0.0.1:7788");
        hashMap.put("node2", "http://127.0.0.1:7789");

        CountDownLatch latch = new CountDownLatch(hashMap.size());
        List<Future<Object>> futures = new ArrayList<>(hashMap.size());
        String resStr = "";

        try {

            for (Entry<String, String> entry : hashMap.entrySet()) {

                Future<Object> fhehe = executorPool.submit(() -> {
                    try {
                        return myFeginService.calculate(entry.getValue(), 2, 4);
                    } finally {
                        latch.countDown();
                    }
                });
                futures.add(fhehe);

            }

            // 等待所有接口调用完成或超时
            latch.await(4, TimeUnit.SECONDS); // 设置超时时间为x秒
            log.info("等待结束");

            // 检查每个Future的状态，收集结果或错误
            for (Future<Object> future : futures) {
                try {
                    resStr += future.get(100, TimeUnit.MILLISECONDS) + "\n";
                } catch (ExecutionException e) {
                    // 接口调用失败，记录错误信息
                    resStr += "Error: " + e.getCause().getMessage() + "\n";
                } catch (CancellationException e) {
                    // 接口调用超时，记录超时信息
                    resStr += "任务被取消" + "\n";
                } catch (TimeoutException e) {
                    // 接口调用超时，记录超时信息
                    resStr += "任务超时" + "\n";
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new ArrayList<>();
        }

        return resStr;
    }

    public Object asynStudy() {

        // 此时应该有节点信息,和调用接口的参数
        NodeVo nodeVo1 = new NodeVo("node1", "http://127.0.0.1:7788");
        NodeVo nodeVo2 = new NodeVo("node2", "http://127.0.0.1:7789");

        HashMap<NodeVo, Object[]> nodeMap = new HashMap<NodeVo, Object[]>();
        nodeMap.put(nodeVo1, new Object[] { nodeVo1, 2, 1 });
        nodeMap.put(nodeVo2, new Object[] { nodeVo2, 2, 3 });

        // 构建函数式接口 -> 接口参数 列表
        Map<MyFunctionalInterface, Object[]> funcMap = new HashMap<MyFunctionalInterface, Object[]>();

        for (Entry<NodeVo, Object[]> entry : nodeMap.entrySet()) {
            NodeVo node = entry.getKey();
            Object[] argArr = entry.getValue();

            // 函数式接口实现
            MyFunctionalInterface mfi = (Object... args) -> {
                return myFeginService.calculate(node.getUri(), (Integer) args[1], (Integer) args[2]);
            };

            funcMap.put(mfi, argArr);

        }
        // 将多个函数式接口传入CountDownLatch执行
        Object execute = CountDownLatchUtils.execute(funcMap);

        return execute;
    }
}
