package com.lwq.precious.p00_utils;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


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

    /**
     * org.apache.commons.io
     * copy()
     * 追加在原有数据的后面
     */
    @Test
    public void name1() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\lwq\\Desktop\\a.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\lwq\\Desktop\\b.txt");

        fos.write(97);

        IOUtils.copy(fis,fos);

        fis.close();
        fos.close();
    }


}
