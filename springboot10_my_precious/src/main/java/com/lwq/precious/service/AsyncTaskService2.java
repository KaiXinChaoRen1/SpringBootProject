package com.lwq.precious.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.springframework.stereotype.Service;

/**
 * 手动实现异步任务
 */

@Service
public class AsyncTaskService2 {
    // 创建线程池（3个）
    ExecutorService threadPool1 = Executors.newFixedThreadPool(3);

    public FutureTask<String> task1() throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            long begin = System.currentTimeMillis();
            Thread.sleep(1000);
            long end = System.currentTimeMillis();
            return "task1执行完毕,执行时间是" + (end - begin);
        });
        threadPool1.execute(futureTask);
        return futureTask;

    }

    public FutureTask<String> task2() throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            long begin = System.currentTimeMillis();
            Thread.sleep(1500);
            long end = System.currentTimeMillis();
            return "task1执行完毕,执行时间是" + (end - begin);
        });
        threadPool1.execute(futureTask);
        return futureTask;

    }

    public FutureTask<String> task3() throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            long begin = System.currentTimeMillis();
            Thread.sleep(2000);
            long end = System.currentTimeMillis();
            return "task1执行完毕,执行时间是" + (end - begin);
        });
        threadPool1.execute(futureTask);
        return futureTask;

    }
}
