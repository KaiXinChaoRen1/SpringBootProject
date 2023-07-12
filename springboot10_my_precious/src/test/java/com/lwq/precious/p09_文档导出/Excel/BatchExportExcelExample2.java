package com.lwq.precious.p09_文档导出.Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.alibaba.fastjson2.JSONObject;

public class BatchExportExcelExample2 {
    private static final String FILE_PATH = "C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹 (2)\\batchExport2.xlsx";
    private static final int BATCH_SIZE = 10000; // 每批次写入的数据量

    public static void main(String[] args) throws IOException {

        Map<String, List<JSONObject>> data = getData();

        long time1 = System.currentTimeMillis();

        SXSSFWorkbook workbook = new SXSSFWorkbook();

        for (Map.Entry<String, List<JSONObject>> entry : data.entrySet()) {
            String sheetName = entry.getKey();
            List<JSONObject> sheetData = entry.getValue();
            Sheet sheet = workbook.createSheet(sheetName);

            int rowNumber = 0;
            if (sheetData.size() > 0) {
                Row titleRow = sheet.createRow(rowNumber++);
                JSONObject firstRowData = sheetData.get(0);
                int cellNumber = 0;
                for (String key : firstRowData.keySet()) {
                    Cell cell = titleRow.createCell(cellNumber++);
                    cell.setCellValue(key);
                }

                for (int i = 0; i < sheetData.size(); i++) { 
                    if (i > 0 && i % BATCH_SIZE == 0) {
                        // 将数据刷新到磁盘并清空缓存
                        SXSSFSheet sxssfSheet = (SXSSFSheet) sheet;
                        sxssfSheet.flushRows(BATCH_SIZE);
                    }
                    Row row = sheet.createRow(rowNumber++);
                    JSONObject rowData = sheetData.get(i);
                    int cellIndex = 0;
                    for (String key : rowData.keySet()) {
                        Cell cell = row.createCell(cellIndex++);
                        cell.setCellValue(rowData.getString(key));
                    }
                }
                // 将数据刷新到磁盘并清空缓存
                SXSSFSheet sxssfSheet = (SXSSFSheet) sheet;
                sxssfSheet.flushRows(sheetData.size() % BATCH_SIZE);
                System.out.println("写入一次");

            }
        }

        FileOutputStream fos = new FileOutputStream(FILE_PATH);
        workbook.write(fos);
        fos.close();

        workbook.dispose(); // 清除临时文件
        workbook.close();

        long time2 = System.currentTimeMillis();
        System.out.println("导出时间为" + (time2 - time1) + "ms");
    }

    /**
     * 制造假数据
     */
    private static Map<String, List<JSONObject>> getData() {

        Map<String, List<JSONObject>> data = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            // 指定初始大小,防止频繁扩容
            List<JSONObject> sheetData = new ArrayList<>(100002);
            // 每个Sheet页写入100000条数据
            for (int j = 0; j < 100002; j++) {
                JSONObject rowData = new JSONObject();
                rowData.put("姓名_" + i, "lwq_" + i + "_" + j);
                sheetData.add(rowData);
            }
            data.put("sheet" + i, sheetData);
        }
        return data;
    }
}