package com.lwq.precious.p00_a随笔;

import java.math.BigInteger;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.precious.model.MyJsonUser;
import com.lwq.precious.utils.SigarUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GoGoGoTest2 {
    /**
     * 10进制->16进制
     * 10进制->8进制
     * 10进制->2进制
     */
    @Test
    public void name11() {
        // 10进制->16进制
        String hexString = Integer.toHexString(16);
        System.out.println(hexString);
        // 10进制->8进制
        String octalString = Integer.toOctalString(10);
        System.out.println(octalString);
        // 10进制->2进制
        String binaryString = Integer.toBinaryString(255);
        System.out.println(binaryString);
    }

    /**
     * 16进制->10进制
     * 8进制->10进制
     */
    @Test
    public void name10() {
        BigInteger bigInteger = new BigInteger("1a", 16);
        System.out.println(bigInteger);
        int intValue = bigInteger.intValue();
        System.out.println(intValue);
        BigInteger bigInteger2 = new BigInteger("17", 8);
        System.out.println(bigInteger2);

    }

    /**
     * 十进制<-->二进制
     */
    @Test
    public void name9() {
        int parseUnsignedInt = Integer.parseUnsignedInt("11111111", 2);
        System.out.println(parseUnsignedInt);
        String binaryString = Integer.toBinaryString(255);
        System.out.println(binaryString);
    }

    @Test
    public void name8() throws UnknownHostException {
        String a = null;
        a = a + "hehe";
        System.out.println(a);
    }

    @Test
    public void name7() throws UnknownHostException {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void name6() throws UnknownHostException {
        try {
            throw new RuntimeException("出现异常了");
        } catch (Exception e) {
            System.out.println("----------------------------------------");
            e.printStackTrace();
            System.out.println("----------------------------------------");
            log.error("全局异常捕获", e);
        }
        SigarUtils.property();
    }

    @Test
    public void name5() throws UnknownHostException {
        System.out.println("heh");
        SigarUtils.property();
    }

    @Test
    public void name4() {
        HashMap<String, MyJsonUser> map = new HashMap<>();
        MyJsonUser build = MyJsonUser.builder().age(23).name("黄春").build();
        map.put("1", build);

        System.out.println(map.get("1"));
        // build.setAge(24);

        build = MyJsonUser.builder().age(23).name("小龙").build();
        System.out.println(map.get("1"));

    }

    /**
     * 从开头或结尾或某一个位置开始匹配
     */
    @Test
    public void name3() {
        System.out.println("aabb".startsWith("ab", 1));
        System.out.println("aabb".startsWith("aab"));
        System.out.println("aabb".endsWith("abb"));
    }

    /**
     * 判断包含子串
     */
    @Test
    public void name2() {
        System.out.println("aaabbb".contains("a"));
        System.out.println("aaabbb".contains("ab"));
    }

    /**
     * 字符串忽略大小写匹配
     */
    @Test
    public void name() {
        System.out.println("faLsE".equalsIgnoreCase("FALSE"));
        System.out.println("FALSE".equalsIgnoreCase("FALSE"));
        System.out.println("false".equalsIgnoreCase("FALSE"));
        System.out.println("False".equalsIgnoreCase("FALSE"));
    }
}
