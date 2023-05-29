package com.lwq.precious.p09_导出.Excel;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import cn.hutool.json.JSONObject;


// public class ExportExcelWithMultiThreadExample {
//     private static final String FILE_PATH = "C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹 (2)\\temp.xlsx";
//     private static final int BATCH_SIZE = 10000; // 每批次写入的数据量

//     public static void main(String[] args) throws IOException, InterruptedException {
//         Map<String, List<JSONObject>> data = new HashMap<>();
//         Thread readThread = new Thread(() -> {
//             for (int i = 0; i < 10; i++) {
//                 List<JSONObject> sheetData = new ArrayList<>(BATCH_SIZE);
//                 for (int j = 0; j < 100000; j++) {  // 每个Sheet页写入100000条数据
//                     JSONObject rowData = new JSONObject();
//                     rowData.put("data_" + i, "value_" + i + "_" + j);
//                     sheetData.add(rowData);
//                 }
//                 synchronized (data) {
//                     data.put("Sheet" + i, sheetData);
//                     data.notifyAll(); // 通知写线程开始写入数据
//                 }
//             }
//         });
//         Thread writeThread = new Thread(() -> {
//             SXSSFWorkbook workbook = new SXSSFWorkbook();

//             while (true) {
//                 Map<String, List<JSONObject>> batchData;
//                 synchronized (data) {
//                     while (data.isEmpty()) {
//                         try {
//                             data.wait(); // 等待读线程添加数据
//                         } catch (InterruptedException e) {
//                             e.printStackTrace();
//                         }
//                     }
//                     batchData = new HashMap<>(data);
//                     data.clear();
//                 }

//                 for (Map.Entry<String, List<JSONObject>> entry : batchData.entrySet()) {
//                     String sheetName = entry.getKey();
//                     List<JSONObject> sheetData = entry.getValue();
//                     Sheet sheet = workbook.createSheet(sheetName);

//                     int rowNumber = 0;
//                     if (sheetData.size() > 0) {
//                         Row titleRow = sheet.createRow(rowNumber++);
//                         JSONObject firstRowData = sheetData.get(0);
//                         int cellNumber = 0;
//                         for (String key : firstRowData.keySet()) {
//                             Cell cell = titleRow.createCell(cellNumber++);
//                             cell.setCellValue(key);
//                         }

//                         for (int i = 0; i < sheetData.size(); i++) { // 写入数据到Excel文件中
//                             Row row = sheet.createRow(rowNumber++);
//                             JSONObject rowData = sheetData.get(i);
//                             int cellIndex = 0;
//                             for (String key : rowData.keySet()) {
//                                 Cell cell = row.createCell(cellIndex++);
//                                 cell.setCellValue((String)rowData.get(key));
//                             }
//                         }
//                     }

//                     SXSSFSheet sxssfSheet = (SXSSFSheet) sheet;   // 转换为SXSSFSheet对象，

//                     //将数据写入磁盘并清空缓存
//                     try {
//                         sxssfSheet.flushRows(sheetData.size());
//                         System.out.println("写入了");
//                     } catch (IOException e) {
//                         // TODO Auto-generated catch block
//                         e.printStackTrace();
//                     }

//                 }

//                 if (data.isEmpty()) {
//                     break;
//                 }
//             }

//             try {
//                 FileOutputStream fos = new FileOutputStream(FILE_PATH);
//                 workbook.write(fos);
//                 fos.close();

//                 workbook.dispose(); // 清除临时文件
//                 System.out.println("数据导出完成！");
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         });

//         readThread.start();
//         writeThread.start();

//         readThread.join();
//         writeThread.join();
//     }
// }

/**
 * 多线程并行读写(未完成)
 */
public class ExportExcelWithMultiThreadExample {
    private static final String FILE_PATH = "C:\\Users\\wenqiang.li1\\Desktop\\新建文件夹 (2)\\temp.xlsx";
    private static final int BATCH_SIZE = 10000; // 每批次写入的数据量

    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, List<JSONObject>> data = new HashMap<>();
        Thread readThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                List<JSONObject> sheetData = new ArrayList<>(BATCH_SIZE);
                for (int j = 0; j < 100000; j++) {  // 每个Sheet页写入100000条数据
                    JSONObject rowData = new JSONObject();
                    rowData.put("data_" + i, "value_" + i + "_" + j);
                    sheetData.add(rowData);
                }
                synchronized (data) {
                    data.put("Sheet" + i, sheetData);
                    data.notifyAll(); // 通知写线程开始写入数据
                }
            }
        });
        Thread writeThread = new Thread(() -> {
            SXSSFWorkbook workbook = new SXSSFWorkbook();

            while (true) {
                Map<String, List<JSONObject>> batchData;
                synchronized (data) {
                    while (data.isEmpty()) {
                        try {
                            data.wait(); // 等待读线程添加数据
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    batchData = new HashMap<>(data);
                    data.clear();
                }

                for (Map.Entry<String, List<JSONObject>> entry : batchData.entrySet()) {
                    String sheetName = entry.getKey();
                    Sheet sheet = workbook.getSheet(sheetName);
                    if (sheet == null) {
                        sheet = workbook.createSheet(sheetName);

                        int rowNumber = 0;
                        Row titleRow = sheet.createRow(rowNumber++);
                        JSONObject firstRowData = entry.getValue().get(0);
                        int cellNumber = 0;
                        for (String key : firstRowData.keySet()) {
                            Cell cell = titleRow.createCell(cellNumber++);
                            cell.setCellValue(key);
                        }
                    }

                    List<JSONObject> sheetData = entry.getValue();
                    int lastRowNum = sheet.getLastRowNum();
                    for (int i = 0; i < sheetData.size(); i++) { // 写入数据到Excel文件中
                        Row row = sheet.createRow(lastRowNum + i + 1);
                        JSONObject rowData = sheetData.get(i);
                        int cellIndex = 0;
                        for (String key : rowData.keySet()) {
                            Cell cell = row.createCell(cellIndex++);
                            cell.setCellValue((String)rowData.get(key));
                        }
                    }

                    //将数据写入磁盘并清空缓存
                    SXSSFSheet sxssfSheet = (SXSSFSheet) sheet;   // 转换为SXSSFSheet对象，
                    try {
                        sxssfSheet.flushRows(sheetData.size());
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                if (data.isEmpty()) {
                    break;
                }
            }

            try {
                FileOutputStream fos = new FileOutputStream(FILE_PATH);
                workbook.write(fos);
                fos.close();

                workbook.dispose(); // 清除临时文件
                System.out.println("数据导出完成！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        readThread.start();
        writeThread.start();

        readThread.join();
        writeThread.join();
    }
}