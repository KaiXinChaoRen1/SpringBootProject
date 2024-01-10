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
public class RunApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RunApplication.class, args);
        System.out.println("应用服务启动完成~~~");
        System.out.println("直接获取容器中的bean-->Person:"+run.getBean("person"));
    }

    @Value("${neinei}")
    private String  neinei ="12";

    @PostConstruct
    private void name1(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String s = String.valueOf(System.currentTimeMillis());
                log.info("我是日志-"+neinei+"-"+s);
            }
        },1000,1000);

    }



}
