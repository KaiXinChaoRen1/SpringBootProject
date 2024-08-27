package com.lwq.springboot11.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

  private Thread currentThread;

  public void startDancing(String name) {

    if (currentThread != null && currentThread.isAlive()) {
      currentThread.stop();
    }

    Mythread runable = new Mythread(name);
    currentThread = new Thread(runable);
    currentThread.start();
  }

}
