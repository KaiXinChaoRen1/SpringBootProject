package com.lwq.precious.p09_文档导出.Excel;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FileLengthTest {

    /**
     * 文件大小Byte为单位
     */
    @Test
    public void name() {
        File file = new File("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹 (2)\\a.txt");
        System.out.println(file.length());
    }

}
