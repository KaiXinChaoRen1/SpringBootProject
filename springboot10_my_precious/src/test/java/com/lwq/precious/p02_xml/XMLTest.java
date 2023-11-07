package com.lwq.precious.p02_xml;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class XMLTest {
    // 读入
    @Test
    public void test1() throws Exception {
        SAXReader saxReader = new SAXReader(); // 创建解析对象
        File file = new File("book.xml"); // file
        Document doc = saxReader.read(file); // 将文件转成对象

        // InputStream is =
        // XmlTest.class.getClassLoader().getResourceAsStream("book.xml");
        // SAXReader saxReader = new SAXReader();
        // Document doc = saxReader.read(is);

        Element rootElement = doc.getRootElement(); // 获取根节点（节点都是element类型）

        List<Element> elements = rootElement.elements();// 获取所有子节点

        for (Element e : elements) {
            System.out.println(e.getName()); // 标签名
            // System.out.println(e.attributeValue("id")); // 标签的某个属性
            System.out.println(e.elementText("title")); // 通过子标签名字获取其文本信息
            System.out.println(e.elementText("author"));
            System.out.println(e.elementText("price"));
            // 继续遍历
            List<Element> elements2 = e.elements();
            for (Element e2 : elements2) {
                System.out.println(e2.getTextTrim()); // 获取标签内的文本
                System.out.println(e2.getText()); // 获取标签内的文本
                System.out.println(e2.getData());// 获取标签内的文本
            }
            System.out.println("------------------------------");
        }

    }

    // 写出到xml文件
    @Test
    public void test2() throws Exception {

        DocumentFactory documentFactory = new DocumentFactory();
        Document createDocument = documentFactory.createDocument();
        Element bookElement = createDocument.addElement("book");
        bookElement.addAttribute("页数", "999");
        bookElement.addAttribute("封皮", "硬封");

        bookElement.addElement("title").setText("红楼梦");
        bookElement.addElement("author").setText("曹雪芹");
        bookElement.addElement("price").setText("10");

        FileOutputStream fos = new FileOutputStream(
                new File("C:\\Users\\wenqiang.li1\\Desktop\\xmldoc\\book.xml"));
        OutputFormat outputFormat = new OutputFormat("\t", true, "UTF-8");
        XMLWriter xmlWriter = new XMLWriter(fos, outputFormat);
        xmlWriter.write(createDocument);
        fos.close();

    }

    // Xpath
    @Test
    public void test3() throws Exception {
        SAXReader saxReader = new SAXReader();
        File file = new File("book.xml");
        Document doc = saxReader.read(file);
        Element rootElement = doc.getRootElement();

        // 获取所有book
        List<Node> booklist = rootElement.selectNodes("book");
        booklist.forEach(b -> System.out.println(b));
        // 获取book下所有author
        List<Node> authorList = rootElement.selectNodes("book/author");
        authorList.forEach(b -> System.out.println(b.getText()));
        // 忽略层级获取所有title
        List<Node> titleList = rootElement.selectNodes("//title");
        titleList.forEach(b -> System.out.println(b.getText()));
        // 获取第一个音乐的名称
        List<Node> musicOneTitle = rootElement.selectNodes("music[1]/title");
        musicOneTitle.forEach(b -> System.out.println(b.getText()));
        // 获取最后一个音乐的作者
        List<Node> musicLastAuthor = rootElement.selectNodes("music[last()]/author");
        musicLastAuthor.forEach(b -> System.out.println(b.getText()));
        // 获取最倒数第二个音乐的作者
        List<Node> musicLasttwoAuthor = rootElement.selectNodes("music[last()-1]/author");
        musicLasttwoAuthor.forEach(b -> System.out.println(b.getText()));
        // 获取前两个book的价格
        List<Node> twoprice = rootElement.selectNodes("book[position()<3]/price");
        twoprice.forEach(b -> System.out.println(b.getText()));
        // 获取price>100的book title
        List<Node> heh = rootElement.selectNodes("book[price>100]/title");
        heh.forEach(b -> System.out.println(b.getText()));
        // 获取所有type属性为wuda的book的name(属性需要单引"")
        List<Node> wuda = rootElement.selectNodes("book[@type='wuda']/title");
        wuda.forEach(b -> System.out.println(b.getText()));
    }
}
