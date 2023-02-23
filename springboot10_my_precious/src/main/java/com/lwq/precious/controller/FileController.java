package com.lwq.precious.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = "web环境下的文件上传下载")
@RestController
@RequestMapping("/file")
public class FileController {

    @ApiOperation("csv文件下载")
    @GetMapping("/csv")
    public void name22(HttpServletResponse response) throws IOException {
        BufferedWriter gb2312 = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("C:\\Users\\lwq\\Desktop\\a.csv"), "GB2312"));
        gb2312.write("li,wen文,qiang强");
        gb2312.close();

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;filename=" + URLEncoder.encode("呵呵.csv", "UTF-8"));

        IOUtils.copy(new FileInputStream("C:\\Users\\lwq\\Desktop\\a.csv"), response.getOutputStream());

        response.flushBuffer();
    }

    @ApiOperation("文件预览")
    @GetMapping("/yulan")
    public void yulan(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "inline;filename=bbb.png");
        response.setContentType("image/png");
        // 读取文件
        FileInputStream fis = new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\aaa.png");

        ServletOutputStream outputStream = response.getOutputStream();
        // 写入返回
        StreamUtils.copy(fis, outputStream);
    }

    @ApiOperation("文件下载")
    @GetMapping("/download")
    public String name1(HttpServletResponse response) throws IOException {

        String myFileName = "呵呵.txt";

        // response.setHeader("Content-Disposition", "attachment;filename="+myFileName);
        // 文件名带中文需要设置一下文件名编码
        // Content-Disposition:来设置文件下载对话框。
        // attachment:表示以附件形式下载(如果要在页面中打开，可以改为inline,详见文件预览接口)
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(myFileName, "UTF-8"));
        // response.setHeader("Content-Disposition", "inline");

        // 告诉浏览器区分不同类型的数据(有很多很多种,用到再去查吧)
        response.setContentType("application/octer-stream");

        byte[] bytes = { -23, -69, -111, -23, -87, -84, -25, -88, -117, -27, -70, -113, -27, -111, -104 };
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);

        outputStream.flush();
        outputStream.close();
        // 这里这样返回没有用
        return "执行完毕";
    }

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public void name(@RequestPart MultipartFile[] myMultipartFile) throws IOException {
        MultipartFile mf = myMultipartFile[0];
        if (mf.isEmpty()) {
            log.error("上传文件为空");
            return;
        }
        // 操作文件流
        // InputStream inputStream = m.getInputStream();

        // //操作流
        // int b;
        // while ((b = inputStream.read()) != -1) {
        // System.out.println((char) b);
        // }
        // //释放资源
        // inputStream.close();

        // 操作File
        String myFilePath = System.getProperty("user.dir");
        String originalFilename = mf.getOriginalFilename();
        File destFile = new File(myFilePath + "\\" + originalFilename);
        mf.transferTo(destFile);

        // 操作File
        System.out.println(destFile.isDirectory());
        System.out.println(destFile.isFile());
        System.out.println(destFile.exists());
        System.out.println(destFile.getAbsolutePath());// 得到绝对路径
        System.out.println(destFile.getPath());// 抽象路径
        System.out.println(destFile.getName());

    }

}
