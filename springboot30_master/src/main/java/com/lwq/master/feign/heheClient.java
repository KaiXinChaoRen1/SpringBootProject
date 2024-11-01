package com.lwq.master.feign;

import java.net.URI;
import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.lwq.master.vo.StudentVo;

@Component
@FeignClient(name = "my-service", url = "http://localhost:8080")
public interface heheClient {

    @PostMapping("/index/add2")
    public ResponseEntity<String> add2(URI uri, @RequestParam("num") Integer num);

    @PostMapping("/index/add")
    public ResponseEntity<String> add(URI uri, @RequestBody HashMap<String, String> map);

    @GetMapping("/hehe1")
    public ResponseEntity<String> hehe1(URI uri);

    @PostMapping("/calculate")
    public ResponseEntity<String> calculate(URI uri, @RequestBody Integer a, @RequestParam Integer b);

    @PostMapping("/student_learning")
    public Object studentLearning(URI uri, @RequestBody StudentVo s, @RequestParam String teacherName,
            @RequestParam String subjectName);

    @PutMapping("/put_student_learning")
    public Object put_student_learning(URI uri, @RequestBody StudentVo s, @RequestParam String teacherName,
            @RequestParam String subjectName);
}
