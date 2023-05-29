package com.lwq.precious.p09_导出.Word;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class POIExportWordTest {
    public static void main(String[] args) throws Exception {
        // 创建XWPFDocument对象
        XWPFDocument doc = new XWPFDocument();
        
        // 添加标题和目录
        XWPFParagraph title = doc.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = title.createRun();
        titleRun.setText("Export Word Demo");
        titleRun.setBold(true);
        titleRun.setFontSize(20);

        XWPFParagraph toc = doc.createParagraph();
        toc.setIndentationLeft(3600);
        toc.setNumID(BigInteger.valueOf(1));
        XWPFRun tocRun = toc.createRun();
        tocRun.addTab();
        tocRun.setText("Table of Contents\n");

        // 添加正文内容：表格、字体
        XWPFParagraph content = doc.createParagraph();
        content.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun contentRun = content.createRun();
        contentRun.setText("Table Demo");
        contentRun.setFontSize(14);
        contentRun.setBold(true);

        // 创建表格
        XWPFTable table = doc.createTable();
        // 设置表格宽度
        table.setWidth(5000);
        table.setTableAlignment(TableRowAlign.CENTER);
        table.getCTTbl().getTblPr().unsetTblBorders();

        // 添加表头行
        XWPFTableRow headerRow = table.getRow(0);
        headerRow.getCell(0).setText("Name");
        headerRow.addNewTableCell().setText("Salary");
        headerRow.addNewTableCell().setText("Position");

        // 添加表格数据行
        ArrayList<String[]> dataList = new ArrayList<String[]>();
        dataList.add(new String[]{"Tom", "10000", "Engineer"});
        dataList.add(new String[]{"Jerry", "8000", "Tester"});
        for (String[] data : dataList) {
            XWPFTableRow dataRow = table.createRow();
            dataRow.getCell(0).setText(data[0]);
            dataRow.getCell(1).setText(data[1]);
            dataRow.getCell(2).setText(data[2]);
        }

        // 添加字体
        XWPFParagraph font = doc.createParagraph();
        font.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun fontRun = font.createRun();
        fontRun.setText("Font Demo");
        fontRun.setFontSize(14);
        fontRun.setBold(true);

        XWPFParagraph normal = doc.createParagraph();
        normal.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun normalRun = normal.createRun();
        normalRun.setText("This is normal text.");
        normalRun.setFontSize(12);
        normalRun.setColor("000000");

        XWPFParagraph bold = doc.createParagraph();
        bold.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun boldRun = bold.createRun();
        boldRun.setText("This is bold text.");
        boldRun.setFontSize(12);
        boldRun.setBold(true);
        boldRun.setColor("000000");

        XWPFParagraph italic = doc.createParagraph();
        italic.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun italicRun = italic.createRun();
        italicRun.setText("This is italic text.");
        italicRun.setFontSize(12);
        italicRun.setItalic(true);
        italicRun.setColor("000000");

        XWPFParagraph strike = doc.createParagraph();
        strike.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun strikeRun = strike.createRun();
        strikeRun.setText("This is strikethrough text.");
        strikeRun.setFontSize(12);
        strikeRun.setStrike(true);
        strikeRun.setColor("000000");

        // 保存文档
        FileOutputStream out = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹 (2)\\ExportWordDemo.docx");
        doc.write(out);
        out.close();
        doc.close();
        System.out.println("导出完成");
    }
}
