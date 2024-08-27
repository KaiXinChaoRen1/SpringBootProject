package com.lwq.springboot11.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncTaskService {
    private Map<String, AsyncTask> tasks = new HashMap<>();

    // 异步执行接口
    @Async
    public void startTask(String taskId, AsyncTask task) {
        tasks.put(taskId, task);
        try {
            task.run();
        } catch (InterruptedException e) {
            log.error("", e);
        }
    }

    public AsnycTaskVO getTask(String taskId) {
        if (tasks.containsKey(taskId)) {
            AsyncTask task = tasks.get(taskId);
            return AsnycTaskVO.builder().taskId(taskId).progress(task.getProgress())
                    .progressMessage(task.getProgressMessage()).done(true).build();
        }
        return null;
    }

    public static class AsyncTask {

        public void run() throws InterruptedException {
        }

        public String getProgressMessage() {
            return null;
        }

        public Integer getProgress() {
            return null;
        }
    }
}
