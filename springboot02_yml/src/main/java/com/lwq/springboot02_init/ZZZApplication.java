package com.lwq.springboot02_init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Timer;
import java.util.TimerTask;


@SpringBootApplication
@Slf4j
public class ZZZApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ZZZApplication.class, args);
        System.out.println("应用服务启动完成~~~");
        System.out.println("直接获取容器中的bean-->Person:"+run.getBean("person"));
    }

    @Value("${logName}")
    private String  logName;

    @PostConstruct
    public void name1(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long l = System.currentTimeMillis();
                String s = String.valueOf(l);
                log.info("我是日志"+logName+s);
            }
        },1000,1000);

    }



}
