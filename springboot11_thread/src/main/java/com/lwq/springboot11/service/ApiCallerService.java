package com.lwq.springboot11.service;

import org.springframework.stereotype.Service;

@Service
public class ApiCallerService {

    /**
     * 模拟调用接口调用,参数为耗时
     * 
     * @param time
     * @return
     */
    public String callApi(long time) {
        // 模拟调用第一个接口
        try {
            Thread.sleep(time); // 假设调用耗时2秒
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Interrupted";
        }
        return "Api1 result";
    }

    // public String callApi2() {
    // // 模拟调用第二个接口
    // try {
    // Thread.sleep(3000); // 假设调用耗时3秒
    // } catch (InterruptedException e) {
    // Thread.currentThread().interrupt();
    // return "Interrupted";
    // }
    // return "Api2 result";
    // }

    // public String callApi3() {
    // // 模拟调用第三个接口
    // try {
    // Thread.sleep(4000); // 假设调用耗时4秒
    // } catch (InterruptedException e) {
    // Thread.currentThread().interrupt();
    // return "Interrupted";
    // }
    // return "Api3 result";
    // }
}
