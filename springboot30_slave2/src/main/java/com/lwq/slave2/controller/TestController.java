package com.lwq.slave2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.slave2.vo.R;
import com.lwq.slave2.vo.StudentVo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.extern.slf4j.Slf4j;

@Tag(name = "TestController", description = "商品品牌管理")
@RestController
@RequestMapping("/")
@Slf4j
public class TestController {
    @Value("${server.port}")
    private String serverPort;

    @Operation(summary = "summary:PutMapping", description = "description:hahah")
    @PutMapping("/put_student_learning")
    public R put_student_learning(@RequestBody StudentVo s, String teacherName,
            String subjectName) {

        return R.error(999, "接口请求异常,发生空空错误");
    }

    @Operation(summary = "summary:PostMapping", description = "description:hahah")
    @PostMapping("/student_learning")
    public Object studentLearning(@RequestBody StudentVo s, String teacherName,
            String subjectName) {

        log.info("我是{},我今年{}岁了,我爱学{}老师教的{}", s.getName(), s.getAge(), teacherName,
                subjectName);
        return subjectName + "下课啦";

    }

    @Operation(summary = "calculate")
    @PostMapping("/calculate")
    public Object calculate(@RequestBody Integer a, @RequestParam Integer b)
            throws InterruptedException {
        Thread.sleep(5000);

        return a * b;

    }

    @Operation(summary = " @ApiOperation(value = \"hehe1\")")
    @GetMapping("/hehe1")
    public Object hehe() {

        return serverPort + "hehe1";
    }

    @Operation(summary = "hehe2")
    @GetMapping("/hehe2")
    public Object hehe2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return serverPort + "hehe2";
    }

}
