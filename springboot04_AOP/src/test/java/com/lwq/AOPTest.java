package com.lwq;

import com.lwq.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class AOPTest {
    @Autowired
    private TestService testService;

    @Test
    public void name1(){
        testService.method1();
    }

    @Test
    public void name2(){
        testService.method2();
    }
}
