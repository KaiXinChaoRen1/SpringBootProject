package com.lwq.springboot11.service;

public class Mythread implements Runnable {

    private String owner;

    @Override
    // run是子线程的入口点
    public void run() {
        int time = 10;
        System.out.println(this.owner + "我要跳" + time + "支舞");

        for (int i = 1; i < time + 1; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我在跳第" + i + "支舞");
        }
    }

    public Mythread(String owner) {
        this.owner = owner;

    }
}
