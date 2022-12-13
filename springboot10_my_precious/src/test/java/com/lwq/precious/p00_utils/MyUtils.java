package com.lwq.precious.p00_utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StopWatch;
import org.springframework.util.StreamUtils;

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

        System.out.println("---------我的分界线,下面是用时分析-----------------");
        System.out.println("总运行时长为" + (sw.getTotalTimeMillis() / 1000.0) + "秒");
        System.out.println(sw.prettyPrint());
    }

    /**
     * org.apache.commons.io
     * copy()
     * 追加在原有数据的后面
     */
    @Test
    public void name1() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\a.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\b.txt");
        // 先写入一个a
        fos.write(97);
        // 在将其他流复制进入
        IOUtils.copy(fis, fos);

        fis.close();
        fos.close();
    }

    /**
     * Spring提供的工具类,效果跟上面一样
     */
    @Test
    public void name11() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\a.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\b.txt");
        // 先写入一个a
        fos.write(97);
        // 在将其他流复制进入
        FileCopyUtils.copy(fis, fos);

        fis.close();
        fos.close();
    }

    /**
     * 跟上面一样,整这么多一样的api干啥,服了
     * 
     * @throws IOException
     */
    @Test
    public void name111() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\a.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\b.txt");
        // 先写入一个a
        fos.write(97);
        // 在将其他流复制进入
        StreamUtils.copy(fis, fos);

        fis.close();
        fos.close();
    }

}
