package com.lwq.precious.p09_文档导出.Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class BatchExportExcelExample {
    private static final String FILE_PATH = "C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹 (2)\\batchExport.xlsx";
    private static final int BATCH_SIZE = 10000;   // 每批次导出的数据量

    public static void main(String[] args) throws IOException {
        List<List<String>> data = generateData(100002);   // 生成10w条数据

        SXSSFWorkbook workbook = new SXSSFWorkbook();   // 创建一个SXSSFWorkbook对象

        Sheet sheet = workbook.createSheet();   // 创建一个Sheet对象

        int rowNumber = 0;

        for (int i = 0; i < data.size(); i += BATCH_SIZE) {   // 分批次导出数据
            int batchSize = Math.min(BATCH_SIZE, data.size() - i);

            for (int j = 0; j < batchSize; j++) {   
                Row row = sheet.createRow(rowNumber++);
                List<String> rowData = data.get(i + j);
                for (int k = 0; k < rowData.size(); k++) {
                    Cell cell = row.createCell(k);
                    cell.setCellValue(rowData.get(k));
                }
            }
            // sheet转换为SXSSFSheet对象
            SXSSFSheet sxssfSheet = (SXSSFSheet) sheet;  
            //将数据写入磁盘并清空缓存
            sxssfSheet.flushRows(batchSize);
            System.out.println("写入一次");
        }

        // 将Workbook对象写入到磁盘中
        FileOutputStream fos = new FileOutputStream(FILE_PATH);
        workbook.write(fos);
        fos.close();

        workbook.dispose();   // 清除临时文件
        workbook.close();
        System.out.println("数据导出完成！");
    }
    /**
     * 制造假数据
     */
    private static List<List<String>> generateData(int count) {
        List<List<String>> data = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<String> rowData = new ArrayList<>();
            rowData.add("value_one_" + i);
            rowData.add("value_two_" + i);
            rowData.add("value_three_" + i);
            rowData.add("value_four_" + i);
            data.add(rowData);
        }

        return data;
    }
}
