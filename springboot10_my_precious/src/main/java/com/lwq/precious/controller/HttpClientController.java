package com.lwq.precious.controller;

import com.lwq.precious.utils.HttpClientUtils;
import com.lwq.precious.utils.IpUtil;
import com.lwq.precious.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * HttpClientUtils主要用来调用一些第三方的接口(例如微信支付接口等)
 */
@RestController
@RequestMapping("/http")
public class HttpClientController {


    /**
     * 抽空用服务器试试
     */
    @GetMapping("test4")
    public String name3(HttpServletRequest request){
        String ipAddress = IpUtil.getIpAddress(request);
        return "此次访问的ip地址是"+ipAddress;
    }

    /**
     * 通过工具方法,直接向response中写入返回内容
     * @param response
     */
    @GetMapping("test3")
    public void name3(HttpServletResponse response){
        ResponseUtils.write(response,"hehe");
    }

    
    /**
     * 通过工具方法,在接口中调用其他地址的接口
     */
    @GetMapping("test2")
    public String name2() throws IOException, ParseException {

        HttpClientUtils client = new HttpClientUtils("http://localhost:8080/http/test1");

        //client.setHttps(true);//支持https

        client.get();
        String content = client.getContent();

        return "调用牛马接口返回"+content;
    }

    //牛马方法
    @GetMapping("test1")
    public String name1(){
        System.out.println("方法执行了");
        return "hehe";
    }



}
