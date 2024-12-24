package com.lwq.jk1;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class PostConstructCollection {

    @PostConstruct
    public void doDeadloop() {
        // deadloop();
    }

    public void deadloop() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                System.out.println("sleep-InterruptedException");
            }
            System.out.println("122");
        }
    }
}
