package com.lwq.precious.p00_utils.springFrameworkUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StreamUtils;

/**
 * IO流工具类
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StreamUtilsTest {

    @Test
    public void name() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\a.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\b.txt");
        // 先写入一个a
        fos.write(97);
        // 在将其他流复制进入
        StreamUtils.copy(fis, fos);

        fis.close();
        fos.close();

    }

    /**
     * StreamUtils.drain()
     */
    @Test
    public void name10() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\a.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\b.txt");
        System.out.println("流的长度是" + fis.getChannel().size());
        // 舍弃输入流的内容
        StreamUtils.drain(fis);
        System.out.println("流的长度是" + fis.getChannel().size());
        // 先写入一个a
        fos.write(97);
        // 在将其他流复制进入
        StreamUtils.copy(fis, fos);

        fis.close();
        fos.close();

    }

    /**
     * available()
     * getChannel().size()
     */
    @Test
    public void name101() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\a.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\b.txt");
        System.out.println("available()的结果是" + fis.available());
        System.out.println("getChannel().size()的结果是" + fis.getChannel().size());
        byte[] bytes = new byte[1024];
        int count = 0;
        while (fis.read(bytes) != -1) {
            count++;
        }
        System.out.println("读取了" + count + "次");
        System.out.println("available()的结果是" + fis.available());
        System.out.println("getChannel().size()的结果是" + fis.getChannel().size());
        StreamUtils.copy(fis, fos);

        fis.close();
        fos.close();

    }
}
