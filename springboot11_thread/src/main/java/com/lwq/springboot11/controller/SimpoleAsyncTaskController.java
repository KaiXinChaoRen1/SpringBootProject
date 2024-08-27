package com.lwq.springboot11.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot11.service.AsnycTaskVO;
import com.lwq.springboot11.service.AsyncTaskService;
import com.lwq.springboot11.service.AsyncTaskService.AsyncTask;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "AsyncTask")
@RestController
@RequestMapping("/AsyncTask")
@Slf4j
public class SimpoleAsyncTaskController {

    @Autowired
    AsyncTaskService asyncTaskService;

    @ApiOperation(value = "测试异步任务")
    @GetMapping("/test1")
    public String test1() {

        String taskId = UUID.randomUUID().toString();

        asyncTaskService.startTask(taskId, new AsyncTask() {

            private String progressMessage = "";
            private Integer progress = 0;

            @Override
            public void run() throws InterruptedException {
                for (int i = 0; i < 100; i++) {
                    log.info("执行中");
                    progressMessage = "正常执行中";
                    progress = i;
                    Thread.sleep(1000);
                }
                progressMessage = "执行完毕";
                progress = 100;
            }

            @Override
            public String getProgressMessage() {
                return progressMessage;
            }

            @Override
            public Integer getProgress() {
                return progress;
            }
        });

        return taskId;
    }

    @ApiOperation(value = "根据异步任务id 获取相关信息")
    @GetMapping("/test2")
    public Object test2(String taskId) {
        AsnycTaskVO task = asyncTaskService.getTask(taskId);
        return task;

    }
}
