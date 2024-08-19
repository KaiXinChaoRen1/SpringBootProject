package com.lwq.precious.p09_文档导出.PDF;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class POIExportWordTest {
    public static void main(String[] args) throws Exception {

        FileOutputStream out = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹\\aa.pdf");
        Document document = new Document();
        PdfWriter instance = PdfWriter.getInstance(document, out);
        document.setPageSize(PageSize.A4);
        document.open();

        // 创建PDF内容
        Paragraph paragraph = new Paragraph("Hello, World!");
        document.add(paragraph);

        document.close();

    }
}
