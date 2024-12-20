package com.lwq.jk1.j04_数据结构;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class LogDeque {

    @Value("${log.queueSize}")
    private int queueSize;

    // 使用LinkedList作为有限队列
    private LinkedList<LogStruct> logQueue = new LinkedList<>();

    // 获取队列的当前大小
    public int getQueueSize() {
        return logQueue.size();
    }

    // 定义一个 DateTimeFormatter 来指定日期时间格式
    DateTimeFormatter myformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 添加日志到队列
    public void addLog(String log) {
        // 如果队列已满，移除最早的日志
        if (logQueue.size() >= queueSize) {
            logQueue.poll(); // 删除队列头部的元素
        }
        LogStruct logStruct = new LogStruct();
        logStruct.setLogText(log);
        logStruct.setTime(LocalDateTime.now().format(myformatter));
        logQueue.add(logStruct); // 添加新的日志到队列尾部
    }

    // 获取所有日志
    public List<LogStruct> getAllLogs() {
        return new LinkedList<>(logQueue); // 返回队列的副本，避免被外部修改
    }

    @Data
    class LogStruct {
        String time;
        String logText;
        Object Others;

    }
}
