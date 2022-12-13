package com.lwq.precious.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 指定时间运行的定时器
 */
@EnableScheduling
@Service
@Slf4j
public class TimerService {

    /*
     * 实现1:
     * scheduleAtFixedRate
     */

    // @PostConstruct
    public void hehe() {
        // 指定时间
        String dateTimeStr = "2022-12-08 19:21:15";
        LocalDateTime startTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // LocaldateTime转换成Date对象
        Date from = Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant());

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                log.info("我执行了现在是" + LocalDateTime.now().toString());
            }

        }, from, 1000);
    }

    /**
     * 实现2:
     * Scheduled
     */

    // @Scheduled(cron="0/1 46 17 * * ?")
    public void hehe2() {
        log.info("我执行了现在是" + LocalDateTime.now().toString());
    }

}
