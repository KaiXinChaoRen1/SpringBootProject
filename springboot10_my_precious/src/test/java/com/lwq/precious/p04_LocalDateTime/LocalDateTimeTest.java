package com.lwq.precious.p04_LocalDateTime;

import java.text.SimpleDateFormat;
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

    /*
     * 时间戳转换时间'字符串'
     */
    @Test
    public void name11() {
        long currentTimeMillis = System.currentTimeMillis();
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(currentTimeMillis);
        System.out.println("年-月-日 时-分-秒-毫秒: " + currentTime);
        String currentTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm-ss").format(currentTimeMillis);
        System.out.println("年-月-日 时-分-秒: " + currentTime1);
        String currentTime2 = new SimpleDateFormat("HH-mm-ss").format(currentTimeMillis);
        System.out.println("时-分-秒: " + currentTime2);
    }

    /**
     * 转换为时间戳
     */
    @Test
    public void name6() {
        LocalDateTime localDateTime = LocalDateTime.now();
        long timestamp = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("LocalDateTime转换时间戳=>" + timestamp);
        System.out.println("直接获取时间戳==========>" + System.currentTimeMillis());
    }

    /**
     * 获取LocalDate(LocalDate系,不是Date系)
     */
    @Test
    public void name() {
        // 获取当前时间或日期
        System.out.println("1==>" + LocalDate.now());
        System.out.println("2==>" + LocalDateTime.now());

        // 根据年月日指定日期
        LocalDate of = LocalDate.of(2019, 2, 28);
        System.out.println("3==>" + of);
        // 指定时间(最后是纳秒)
        LocalDateTime of2 = LocalDateTime.of(2023, 5, 15, 16, 15, 59, 1000000);
        System.out.println("4==>" + of2);

        // 根据字符串获取
        // 日期31号之后直接报错,31之前,如果大于当月最大,那就是当月最大那一号
        String dateStr = "2019-02-31";
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("5==>" + localDate);

        String dateTimeStr = "2018-07-28 14:11:15";
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("6==>" + localDateTime);
    }

    /*
     * 比较LocalDate
     */
    @Test
    public void name10() {
        String dateTimeStr = "2018-07-15 14:11:15";
        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTimeStr,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String dateTimeStr2 = "2018-07-15 14:11:15";
        LocalDateTime localDateTime2 = LocalDateTime.parse(dateTimeStr2,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        int compareTo = localDateTime1.compareTo(localDateTime2);
        System.out.println(compareTo);// 同一个月内,可以显示差几天,否则用+-1代表大小

        System.out.println(localDateTime1.isBefore(localDateTime2));
        System.out.println(localDateTime1.isEqual(localDateTime2));
    }

    /**
     * 相差时间,多少天(当然也能看相差的,年,月等,去查API)
     */
    @Test
    public void name2() {
        LocalDate localDate1 = LocalDate.of(2019, 2, 8);
        LocalDate localDate2 = LocalDate.of(2019, 3, 8);
        long days = localDate2.toEpochDay() - localDate1.toEpochDay();
        // 打错了偶然学到
        System.err.println(days);
        System.out.println(days);
    }

    /**
     * 转换Date
     */
    @Test
    public void name3() {
        // LoaclDate转换Date
        LocalDate localDate = LocalDate.now();
        System.out.println(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        // LoaclDateTime转换Date
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));

    }

    /**
     * Date转LocalDateTime
     * Date转LocalDate
     */
    @Test
    public void name33() {

        Date date = new Date();
        System.out.println("LocalDateTime==>" + date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        System.out.println("LocalDate======>" + date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    /**
     * 转换为字符串
     * 可以实现LocalDateTime只要时间
     */
    @Test
    public void name4() {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
        // HH:mm:ss?SSS");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String strDateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        System.out.println(strDateTime);

    }

    /**
     * 符串转时间
     */
    @Test
    public void name5() {
        String dateTimeStr = "2018-07-28 14:11:15";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, dateTimeFormatter);
        System.out.println(localDateTime);

    }

    /**
     * 时间戳转换LocalDate & LocalDateTime
     */
    @Test
    public void name7() {
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        LocalDate localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDate);
        System.out.println(localDateTime);
    }

    /**
     * 定义long要加L
     */
    @Test
    public void name8() {
        LocalDateTime localDateTime = Instant.ofEpochMilli(1665675006999L).atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        System.out.println(localDateTime);
    }

}
