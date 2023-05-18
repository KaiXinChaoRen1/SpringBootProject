package com.lwq.precious.p03_RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RegExpTest {

    /**
     * 匹配最后一个数字,$代表从行尾匹配第一个,^代表从开头匹配第一个
     */
    @Test
    public void name7() {
        String str = "aaa....bbb_阿..s_d._..斯_顿as_xxx是1234\n山东分公司2344梵蒂冈_aa2345";
        System.out.println("---------先打印字符串--------------------");
        System.out.println(str);
        System.out.println("-------------END-------------------------");
        Pattern pattern = Pattern.compile("(\\d+)$");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("找到" + matcher.group());
        }
    }

    /**
     * 匹配第一个.之后第三个_之前的所有字符
     */
    @Test
    public void name6() {
        String str = "aaa....bbb_阿..s_d._..斯_顿as_xxx是的是的_aa";
        Pattern pattern = Pattern.compile("(?<=\\.)[^_]*_[^_]*_[^_]*(?=_)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("找到" + matcher.group());
        }
    }

    /**
     * '*' 匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。要匹配 * 字符，请使用 \*。
     * '+' 匹配前面的子表达式一次或多次。例如，zo+ 能匹配 "zo" 以及 "zoo"。要匹配 + 字符，请使用 \+。
     * '?' 匹配前面的子表达式零次或一次。例如，do(es)? 可以匹配 "do" 、 "does"、 "doxy" 中的 "do" 。
     */
    @Test
    public void name5() {
        String str = "升降速度丧失1,发动攻击参数丧失2a";
        // Pattern pattern = Pattern.compile("af+");
        Pattern pattern = Pattern.compile("af?");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("找到" + matcher.group());
        }
    }

    /**
     * [abc]匹配abc中任意一个
     */
    @Test
    public void name4() {
        String str = "升降速度丧失1,发动攻击参数丧失2af";
        Pattern pattern = Pattern.compile("([abc])([def])");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("找到" + matcher.group());
            System.out.println("找到" + matcher.group(1));
            System.out.println("找到" + matcher.group(2));
        }
    }

    /**
     * ()括号可以对匹配到的字串进行后续分割
     */
    @Test
    public void name3() {
        String str = "升降速度丧失1,发动攻击参数丧失2";
        Pattern pattern = Pattern.compile("(.)(.)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("找到" + matcher.group(0));
        }
        if (matcher.find()) {
            // group()和group(0)都是整个匹配
            System.out.println("找到" + matcher.group());
            System.out.println("找到" + matcher.group(0));
            System.out.println("找到" + matcher.group(1));
            System.out.println("找到" + matcher.group(2));
        }
    }

    /**
     * . 匹配任意字符
     * find()方法 调用一次之后指针后移
     */
    @Test
    public void name2() {
        String str = "升降速度丧失1,发动攻击参数丧失2";
        Pattern pattern = Pattern.compile("..");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("找到" + matcher.group(0));
        }
        if (matcher.find()) {
            System.out.println("找到" + matcher.group(0));
        }
    }

    @Test
    public void name1() {
        String news = "升降速度丧失1,发动攻击参数丧失2";
        // pattern:样式,范例
        Pattern pattern = Pattern.compile("\\d\\d");
        Matcher matcher = pattern.matcher(news);
        while (matcher.find()) {
            System.out.println("找到" + matcher.group(0));
        }
    }

}
