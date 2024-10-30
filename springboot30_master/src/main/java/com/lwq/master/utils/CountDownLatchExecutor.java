package com.lwq.master.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lwq.master.vo.NodeFuture;
import com.lwq.master.vo.NodeResult;
import com.lwq.master.vo.NodeVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CountDownLatchExecutor {

    @Value("${latchwaittime}")
    private Integer latchWaitTime = 5;

    private ExecutorService executorPool = Executors.newFixedThreadPool(8);

    public Object execute(Map<MyFunctionalInterface, Object[]> functionMap) {

        CountDownLatch latch = new CountDownLatch(functionMap.size());

        List<NodeFuture> nodeFutureList = new ArrayList<NodeFuture>(functionMap.size());

        List<NodeResult> nodeResultList = new ArrayList<NodeResult>();

        try {

            for (Entry<MyFunctionalInterface, Object[]> entry : functionMap.entrySet()) {

                MyFunctionalInterface mfi = entry.getKey();
                Object[] args = entry.getValue();

                Future<Object> fhehe = executorPool.submit(() -> {
                    try {
                        return mfi.execute(args);
                    } finally {
                        latch.countDown();
                    }
                });
                NodeVo node = (NodeVo) args[0];
                NodeFuture nodeFuture = new NodeFuture(node, fhehe);

                nodeFutureList.add(nodeFuture);

            }

            // 等待所有接口调用完成或超时
            latch.await(latchWaitTime, TimeUnit.SECONDS); // 设置超时时间为x秒
            // log.info("等待结束");

            // 检查每个节点 Future的状态，收集结果
            for (NodeFuture nf : nodeFutureList) {
                Future<Object> future = nf.getFuture();
                NodeVo nodeVo = nf.getNodeVo();
                Object res = null;
                try {
                    res = future.get(100, TimeUnit.MILLISECONDS);
                } catch (ExecutionException e) {
                    res = "Error: " + e.getCause().getMessage();
                } catch (CancellationException e) {
                    res = "任务被取消";
                } catch (TimeoutException e) {
                    res = "任务超时";
                }
                NodeResult nr = new NodeResult(nodeVo, res);
                nodeResultList.add(nr);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new ArrayList<>();
        }

        return nodeResultList;
    }

}
