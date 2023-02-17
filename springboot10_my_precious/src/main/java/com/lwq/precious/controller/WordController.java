package com.lwq.precious.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = "导出word")
@RestController
@RequestMapping("/word")
public class WordController {

    @ApiOperation("word1")
    @PostMapping("/word1")
    public void exportWord(HttpServletResponse response) throws Exception {
        OutputStream out = null;

        // 获取Word模板
        InputStream ins = new FileInputStream("C:\\Users\\lwq\\Desktop\\a.docx");
        // 注册xdocreport实例并加载FreeMarker模板引擎
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(ins, TemplateEngineKind.Freemarker);
        // 创建xdocreport上下文对象
        IContext context;
        context = report.createContext();
        ArrayList<HashMap<String, String>> dataList = new ArrayList<>();
        HashMap<String, String> stringstringHashMap = new HashMap<String, String>();
        stringstringHashMap.put("haha", "哈哈");
        HashMap<String, String> stringstringHashMap2 = new HashMap<String, String>();
        stringstringHashMap2.put("haha", "哈哈2");
        dataList.add(stringstringHashMap);
        dataList.add(stringstringHashMap2);

        context.put("hehe", "呵呵");
        context.put("dataList", dataList);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition",
                "attachment; filename=".concat(String.valueOf(URLEncoder.encode("美国重大时间.docx", "UTF-8"))));
        out = response.getOutputStream();
        report.process(context, out);
        out.flush();
        out.close();

    }
}
