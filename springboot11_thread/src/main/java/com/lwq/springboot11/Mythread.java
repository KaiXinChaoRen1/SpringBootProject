package com.lwq.springboot11;

public class Mythread implements Runnable{
    @Override
	// run是子线程的入口点 
	public void run() {
		for(int i=0;i<21;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			System.out.println( i+"我在跳舞");
		}
	}
}
 