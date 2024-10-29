package com.lwq.master.feign;

import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.lwq.master.vo.StudentVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyFeginService {

    @Autowired
    private heheClient heheClient;

    public Object doHehe1(String uriStr) throws URISyntaxException {

        URI uri = new URI(uriStr);
        return heheClient.hehe1(uri);
    }

    public Object calculate(String uriStr, Integer a, Integer b) {

        URI uri;
        try {
            uri = new URI(uriStr);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return "uri错误";
        }
        return heheClient.calculate(uri, a, b);
    }

    public Object studentLearning(String uriStr, StudentVo s, String teacherName, String subjectName) {

        URI uri;
        try {
            uri = new URI(uriStr);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "uri错误";
        }
        return heheClient.studentLearning(uri, s, teacherName, subjectName);
    }

}
