package com.lwq.springboot11;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    private Thread currentThread;

      public void  startDancing(){

        if(currentThread !=null&&currentThread.isAlive()){
            currentThread.stop();
        }

        Mythread runable = new Mythread();
        currentThread = new Thread(runable);
        currentThread.start();
      }





}
