package com.lwq.precious.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@Api(tags = "web环境下的文件上传下载")
@RestController
@RequestMapping("/file")
public class FileController {

    @ApiOperation("csv文件下载")
    @GetMapping("/csv")
    public void name22(HttpServletResponse response) throws IOException {
        BufferedWriter gb2312 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\lwq\\Desktop\\a.csv"), "GB2312"));
        gb2312.write("li,wen文,qiang强");
        gb2312.close();

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+ URLEncoder.encode("呵呵.csv", "UTF-8"));

        IOUtils.copy(new FileInputStream("C:\\Users\\lwq\\Desktop\\a.csv"), response.getOutputStream());

        response.flushBuffer();
    }

    @ApiOperation("文件下载")
    @GetMapping("/download")
    public String name1(HttpServletResponse response) throws IOException {

        String myFileName = "呵呵.txt";

        //response.setHeader("Content-Disposition", "attachment;filename="+myFileName);
        //文件名带中文需要设置一下文件名编码
        //Content-Disposition:来设置文件下载对话框。
        //attachment:表示以附件形式下载(如果要在页面中打开，可以改为inline)
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(myFileName, "UTF-8"));

        //告诉浏览器区分不同类型的数据(有很多很多种,用到再去查吧)
        response.setContentType("application/octer-stream");

        byte[] bytes = {-23, -69, -111, -23, -87, -84, -25, -88, -117, -27, -70, -113, -27, -111, -104};
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);

        outputStream.flush();
        outputStream.close();
        //这里这样返回没有用
        return "执行完毕";
    }


    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public void name(@RequestPart MultipartFile[] myMultipartFile) throws IOException {
        MultipartFile  m=myMultipartFile[0];
        if (m.isEmpty()) {
            return;
        }
        //获取流
        InputStream inputStream = m.getInputStream();

        //操作流
        int b;
        while ((b = inputStream.read()) != -1) {
            System.out.println((char) b);
        }
        //释放资源
        inputStream.close();
    }

    /**
     * MultipartFile-->File工具方法(妈的,没用)
     */
    private File toFile(MultipartFile multipartFile) {
        File file = null;
        String fileName = multipartFile.getOriginalFilename();
        String prefix = null;
        if (fileName == null) {
            prefix = "tempFile";
        } else {
            prefix = fileName.substring(fileName.lastIndexOf("."));
        }
        try {
            file = File.createTempFile(prefix, prefix);
            multipartFile.transferTo(file);
            file.deleteOnExit();//之前看的未生效,奇怪,不用了
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
