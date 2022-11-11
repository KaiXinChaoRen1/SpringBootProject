package com.lwq.precious.p00_utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MyUtils {
    /**
     * StopWatch--代码用时分析
     */
    @Test
    public void name() throws InterruptedException {

        StopWatch sw = new StopWatch("test");

        sw.start("task1");
        // do something
        Thread.sleep(100);
        sw.stop();

        sw.start("task2");
        // do something
        Thread.sleep(200);
        sw.stop();

        System.out.println("我的分界线-------------------------------");
        System.out.println(sw.prettyPrint());
    }



}
