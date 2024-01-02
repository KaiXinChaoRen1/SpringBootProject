package com.lwq.precious.p09_文档导出.PDF;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
