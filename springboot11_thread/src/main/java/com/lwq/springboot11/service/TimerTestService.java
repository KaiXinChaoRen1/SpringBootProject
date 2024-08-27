package com.lwq.springboot11.service;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TimerTestService {

    private Timer t;

    /**
     * 线程的名称可以一样
     */
    public void timerRun() {
        t = new Timer("timerRun");
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();

                log.info("当前线程name为{},id为{},timer run  !!", thread.getName(), thread.getId());

            }
        }, 1000, 1000);
    }

    public void timerRun2() {
        if (t != null) {

            t.cancel();
            t = new Timer("timerRun2");
        } else {
            t = new Timer("timerRun2");
        }

        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Thread thread = Thread.currentThread();

                log.info("当前线程name为{},id为{},timer run  !!", thread.getName(), thread.getId());
            }
        }, 1000, 1000);
    }

    public void stopRun2() {
        if (t != null) {
            t.cancel();
            System.out.println("timer stop!!");
        }else{
            System.out.println("timer is null");
        }

    }
}
