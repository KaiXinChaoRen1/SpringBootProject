package com.lwq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.service.ImplService;
import com.lwq.service.TestService;
import com.lwq.service2.TestService2;

@SpringBootTest
public class AOPTest {
    @Autowired
    private TestService testService;

    @Autowired
    private TestService2 testService2;

    @Autowired
    private ImplService implService;

    @Test
    public void name4() {
        implService.sayhehe();
    }

    @Test
    public void name3() {
        testService2.method3(111);
    }

    @Test
    public void name2() {
        testService.method2();
    }

    @Test
    public void name1() {
        testService.method1();
    }

}
