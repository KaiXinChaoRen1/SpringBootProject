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

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=export.csv");

        IOUtils.copy(new FileInputStream("C:\\Users\\lwq\\Desktop\\a.csv"),response.getOutputStream());
        response.flushBuffer();
    }




    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public void name(@RequestPart MultipartFile myMultipartFile) throws IOException {
        if(myMultipartFile.isEmpty()){
            return;
        }
        //获取流
        InputStream inputStream = myMultipartFile.getInputStream();
        
        //操作流
        int b;
        while ((b = inputStream.read())!=-1){
            System.out.println((char) b);
        }
        //释放资源
        inputStream.close();
    }

    /**
     * MultipartFile-->File工具方法(妈的,没用)
     */
    private File toFile(MultipartFile multipartFile) {
        File file =null;
        String fileName =multipartFile.getOriginalFilename();
        String prefix=null;
        if(fileName==null){
            prefix="tempFile";
        }else{
            prefix=fileName.substring(fileName.lastIndexOf("."));
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

    @ApiOperation("文件下载")
    @GetMapping("/download")
    public void name1(HttpServletResponse response) throws IOException {
        String fileName="hehe.txt";

        ServletOutputStream outputStream = response.getOutputStream();

        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        response.setContentType("application/octer-stream");

        byte [] bytes = {-23, -69, -111, -23, -87, -84, -25, -88, -117, -27, -70, -113, -27, -111, -104};
        outputStream.write(bytes);

        outputStream.flush();
        outputStream.close();
      

    }
    
}
