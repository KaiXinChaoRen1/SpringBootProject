package com.lwq.precious.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {

    @Async
    public Future<String> task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        return new AsyncResult<>("task1执行完毕,执行时间是" + (end - begin));
    }

    @Async
    public Future<String> task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1500);
        long end = System.currentTimeMillis();
        return new AsyncResult<>("task2执行完毕,执行时间是" + (end - begin));
    }

    @Async
    public Future<String> task3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        return new AsyncResult<>("task3执行完毕,执行时间是" + (end - begin));
    }
}
