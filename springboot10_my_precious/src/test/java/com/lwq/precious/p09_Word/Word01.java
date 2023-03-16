package com.lwq.precious.p09_Word;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

public class Word01 {

	@Test
	public void name8() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\444.doc");
		HWPFDocument hwpfDocument = new HWPFDocument(fis);

	}

	/**
	 * 读取poi生成的doc
	 */
	@Test
	public void name7() throws Exception {
		XWPFDocument doc1 = new XWPFDocument(
				new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\hehe.doc"));

	}

	@Test
	public void name6() {
		try {
			// Load the first Word document and get the content to copy
			XWPFDocument doc1 = new XWPFDocument(new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\222.doc"));

			// Load the second Word document and find the table and cell to insert into
			XWPFDocument doc2 = new XWPFDocument(new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\111.doc"));
			List<XWPFTable> tables = doc2.getTables();
			XWPFTable table = tables.get(0);
			XWPFTableCell cell = table.getRow(1).getCell(0);

			// Copy the body elements from the source document to the target document
			for (IBodyElement elem1 : doc1.getBodyElements()) {
				if (elem1.getElementType() == BodyElementType.PARAGRAPH) {
					// If this is a paragraph, copy it to the target document
					XWPFParagraph para1 = (XWPFParagraph) elem1;
					XWPFParagraph para2 = cell.addParagraph();
					para2.getCTP().set(para1.getCTP());
					for (XWPFRun run1 : para1.getRuns()) {
						XWPFRun run2 = para2.createRun();
						run2.getCTR().set(run1.getCTR());
					}
				} else if (elem1.getElementType() == BodyElementType.TABLE) {
					// If this is a table, copy it to the target document
					XWPFTable table1 = (XWPFTable) elem1;
					CTTbl addNewTbl = cell.getCTTc().addNewTbl();
					addNewTbl.set(table1.getCTTbl());
				}
			}

			// Save the modified target document
			FileOutputStream out = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\target_modified.doc");
			doc2.write(out);
			out.close();

			System.out.println("执行结束");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 复制全部内容到另一个word
	 */
	@Test
	public void name5() {
		try {
			// Load the first Word document and get the content to copy
			XWPFDocument doc1 = new XWPFDocument(new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\222.docx"));

			XWPFDocument doc2 = new XWPFDocument();

			// Copy the body elements from the source document to the target document
			for (IBodyElement elem1 : doc1.getBodyElements()) {
				if (elem1.getElementType() == BodyElementType.PARAGRAPH) {
					// If this is a paragraph, copy it to the target document
					XWPFParagraph para1 = (XWPFParagraph) elem1;
					XWPFParagraph para2 = doc2.createParagraph();
					para2.getCTP().set(para1.getCTP());
					for (XWPFRun run1 : para1.getRuns()) {
						XWPFRun run2 = para2.createRun();
						run2.getCTR().set(run1.getCTR());
					}
				} else if (elem1.getElementType() == BodyElementType.TABLE) {
					// If this is a table, copy it to the target document
					XWPFTable table1 = (XWPFTable) elem1;
					XWPFTable table2 = doc2.createTable();
					table2.getCTTbl().set(table1.getCTTbl());
				}
			}

			// Save the modified target document
			FileOutputStream out = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\hehe.docx");
			doc2.write(out);
			out.close();

			System.out.println("执行结束");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void name4() {
		try {
			// Load the first Word document and get the content to copy
			XWPFDocument doc1 = new XWPFDocument(new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\222.docx"));

			// Load the second Word document and find the table and cell to insert into
			XWPFDocument doc2 = new XWPFDocument(new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\111.docx"));
			List<XWPFTable> tables = doc2.getTables();
			XWPFTable table = tables.get(0);
			XWPFTableCell cell = table.getRow(1).getCell(0);

			for (XWPFParagraph para1 : doc1.getParagraphs()) {
				XWPFParagraph para2 = cell.addParagraph();
				para2.getCTP().set(para1.getCTP());

				// for (XWPFRun run1 : para1.getRuns()) {
				// XWPFRun run2 = para2.createRun();
				// run2.getCTR().set(run1.getCTR());
				// }
			}

			// Save the modified target document
			FileOutputStream out = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\target_modified.docx");
			doc2.write(out);
			out.close();

			System.out.println("执行结束");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void name3() {
		try {
			// Load the first Word document and get the content to copy
			XWPFDocument doc1 = new XWPFDocument(new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\222.docx"));

			// Load the second Word document and find the table and cell to insert into
			XWPFDocument doc2 = new XWPFDocument(new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\111.docx"));
			List<XWPFTable> tables = doc2.getTables();
			XWPFTable table = tables.get(0);
			XWPFTableCell cell = table.getRow(1).getCell(0);

			for (XWPFParagraph para1 : doc1.getParagraphs()) {
				XWPFParagraph para2 = doc2.createParagraph();
				para2.getCTP().set(para1.getCTP());
				for (XWPFRun run1 : para1.getRuns()) {
					XWPFRun run2 = para2.createRun();
					run2.getCTR().set(run1.getCTR());
				}
			}

			// Insert the new paragraph into the target table cell
			cell.setParagraph(doc2.getParagraphs().get(doc2.getParagraphs().size() - 1));

			// Save the modified target document
			FileOutputStream out = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\target_modified.docx");
			doc2.write(out);
			out.close();

			System.out.println("执行结束");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void name2() {
		try {
			// Load the first Word document and get the content to copy
			XWPFDocument doc1 = new XWPFDocument(new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\222.docx"));
			XWPFParagraph para = doc1.getParagraphs().get(0);
			String contentToCopy = para.getText();
			System.out.println(contentToCopy);

			// Load the second Word document and find the table to insert into
			XWPFDocument doc2 = new XWPFDocument(new FileInputStream("C:\\Users\\wenqiang.li1\\Desktop\\111.docx"));
			// XWPFTable table = doc2.getTableArray(0);

			List<XWPFTable> tables = doc2.getTables();
			XWPFTable table = tables.get(0);

			// Insert the copied content into the table
			XWPFTableRow row = table.getRow(1);
			XWPFTableCell cell = row.getCell(0);
			cell.setText(contentToCopy);

			// Save the modified Word document
			FileOutputStream out = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\111_modified.docx");
			doc2.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * html->doc
	 */
	@Test
	public void name() {
	}

	/**
	 * html->doc
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void name11() throws FileNotFoundException {
		// 创建 POIFSFileSystem 对象
		POIFSFileSystem poifs = new POIFSFileSystem();
		// 获取DirectoryEntry
		DirectoryEntry directory = poifs.getRoot();
		// 创建输出流
		FileOutputStream out = new FileOutputStream("C:\\Users\\wenqiang.li1\\Desktop\\haha.doc");
		try {
			// 创建文档,1.格式,2.HTML文件输入流
			directory.createDocument("WordDocument", getInputStream("111.html"));
			// 写入
			poifs.writeFilesystem(out);
			// 释放资源
			out.close();
			System.out.println("html转换word成功");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static InputStream getInputStream(String name) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
	}
}
