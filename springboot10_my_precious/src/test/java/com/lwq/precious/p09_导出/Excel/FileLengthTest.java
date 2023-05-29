package com.lwq.precious.p09_导出.Excel;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FileLengthTest {
    @Test
    public void name() {
        File file = new File("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹 (2)\\temp2.xlsx");
        System.out.println(file.length());
    }
    
}
