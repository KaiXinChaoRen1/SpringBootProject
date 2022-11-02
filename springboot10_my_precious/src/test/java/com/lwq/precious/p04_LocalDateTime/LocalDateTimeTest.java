package com.lwq.precious.p04_LocalDateTime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LocalDateTimeTest {

    @Test
    public void name() {
        //获取当前时间或日期
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());

        //根据年月日指定日期
        LocalDate localDate1 = LocalDate.of(2019, 2, 28);// 年月日
        System.err.println(localDate1);

        
        String str = "2019-02-31";// 日期31号之后直接报错,31之前,如果大于当月最大,那就是当月最大那一号
        LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.err.println(localDate);

        String dateTimeStr = "2018-07-28 14:11:15";
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.err.println(localDateTime);
    }

    /**
     * 相差多少天
     */
    @Test
    public void name2() {
        LocalDate localDate1 = LocalDate.of(2019, 2, 8);
        LocalDate localDate2 = LocalDate.of(2019, 3, 8);
        long days = localDate2.toEpochDay() - localDate1.toEpochDay();
        System.err.println(days);
    }

    /**
     * 转换Date
     */
    @Test
    public void name3() {
        // LoaclDate转换Date
        LocalDate localDate = LocalDate.of(2019, 2, 8);
        Date day = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(day);
        // LoaclDateTime转换Date
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);

    }

    @Test
    public void name33() {
        // Date转LocalDateTime(LocalDate)
        Date date = new Date();
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDateTime);
        System.out.println(localDate);
    }

    @Test
    public void name4() {
        // 时间转字符串格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss?SSS");
        String dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        System.out.println(dateTime);

    }

    @Test
    public void name5() {
        // 字符串转时间
        String dateTimeStr = "2018-07-28 14:11:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, df);

    }

    // 转换时间戳
    @Test
    public void name6() {
        LocalDateTime localDateTime = LocalDateTime.now();
        long timestamp = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println(timestamp);
    }

    //时间戳转换
    @Test
    public void name7() {
        long timestamp = System.currentTimeMillis();
        LocalDate localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();

    }

}
