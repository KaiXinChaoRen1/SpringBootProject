package com.lwq.jk1.j04_数据结构;

import static org.mockito.ArgumentMatchers.anyBoolean;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.jk1.j04_数据结构.LogDeque.LogStruct;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LogDequeTest {

    @Autowired
    LogDeque logDeque;

    @Test
    public void name4() {

        for (int i = 0; i < 1000000; i++) {
            logDeque.addLog("qqq" + i);

        }

        List<LogStruct> allLogs = logDeque.getAllLogs();
        System.out.println(allLogs);
    }
}
