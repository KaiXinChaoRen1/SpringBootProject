package com.lwq.springboot11.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot11.service.ApiCallerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "CountDownLatch测试")
@RestController
@RequestMapping("/countDownLatch")
@Slf4j
public class CountDownLatchController {

    private ExecutorService executor = Executors.newFixedThreadPool(3);

    @Autowired
    private ApiCallerService apiCallerService;

    @ApiOperation(value = "测试countDownLatch")
    @GetMapping("/test1")
    public Object hehe1() throws TimeoutException {

        log.info("开始调用");
        List<String> res = callMultipleApisWithTimeout();
        log.info("调用完毕");
        return res;
    }

    public List<String> callMultipleApisWithTimeout() {
        // 假设需要调用三个接口
        CountDownLatch latch = new CountDownLatch(3);
        List<String> results = new ArrayList<>(3);
        List<Future<String>> futures = new ArrayList<>(3);

        try {

            Future<String> future1 = executor.submit(() -> {
                try {
                    return apiCallerService.callApi(1000);
                } finally {
                    latch.countDown();
                }
            });
            futures.add(future1);

            // 调用第二个接口
            Future<String> future2 = executor.submit(() -> {
                try {
                    return apiCallerService.callApi(2000);
                } finally {
                    latch.countDown();
                }
            });
            futures.add(future2);

            // 调用第三个接口
            Future<String> future3 = executor.submit(() -> {
                try {
                    return apiCallerService.callApi(5100);
                } finally {
                    latch.countDown();
                }
            });
            futures.add(future3);

            // 等待所有接口调用完成或超时
            latch.await(5, TimeUnit.SECONDS); // 设置超时时间为10秒
            log.info("等待结束");

            // 检查每个Future的状态，收集结果或错误
            for (Future<String> future : futures) {
                try {
                    results.add(future.get(10, TimeUnit.MILLISECONDS));
                } catch (ExecutionException e) {
                    // 接口调用失败，记录错误信息
                    results.add("Error: " + e.getCause().getMessage());
                } catch (CancellationException e) {
                    // 接口调用超时，记录超时信息
                    results.add("任务被取消");
                } catch (TimeoutException e) {
                    // 接口调用超时，记录超时信息
                    results.add("任务超时");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new ArrayList<>();
        }

        return results;
    }
}
