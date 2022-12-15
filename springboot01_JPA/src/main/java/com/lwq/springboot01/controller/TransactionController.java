package com.lwq.springboot01.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tran")
public class TransactionController {

    @GetMapping("/update")
    public String update() {
        try {

            return "修改成功";
        } catch (Exception e) {
            return "修改失败";
        }

    }

    @GetMapping("/get")
    public String get() {
        return null;
    }

    @Transactional
    public void updateFlag(Boolean b) {

    }

    public Boolean getFlag() {
        return null;
    }
}
