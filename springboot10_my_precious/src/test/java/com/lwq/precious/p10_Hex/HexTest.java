package com.lwq.precious.p10_Hex;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class HexTest {

    @Test
    public void convertbytearr() {
        byte[] longToByte = longToByte(10000L);

        byte[] long2ByteArr = long2ByteArr(10000L);

        System.out.println("此处断点查看");
    }

    @Test
    public void name12323443() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.containsKey(null);
    }

    @Test
    public void name12323() {
        char[] binaryArray = { '1', '1' };
        String hexString = binaryToHex(new String(binaryArray));
        System.out.println("0x" + hexString);
    }

    public static String binaryToHex(String binary) {
        // 确保字符串长度为偶数
        if (binary.length() % 2 != 0) {
            binary = '0' + binary; // 在前面添加一个'0'
        }

        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 2) {
            String binarySubStr = binary.substring(i, i + 2);
            // 将二进制子串转换为十进制整数
            int decimal = Integer.parseInt(binarySubStr);
            // 将十进制整数转换为十六进制字符
            hex.append(Integer.toHexString(decimal));
        }
        return hex.toString();
    }

    /**
     * 常见的udp报文,会有byte 或者 十六进制 两种展示形式
     * byte->十六进制
     * 也就是
     * -128~127范围内的十进制->两位十六进制数
     * 
     * 1.正数情况下: 十进制=左边十六进制数*16+右边十六进制数
     * 2.负数情况下: 考虑负数在数轴上的位置,转换成整数,再用上边的方式,例如-2 在正数数轴上应该是256-2=254
     * 数轴 255,0_____127,128________255,0_____________255
     * -1,0_____127,-128________-1,0______
     */
    @Test
    public void name1() {
        String s1 = Integer.toHexString(1);
        System.out.println(s1);

        String s2 = Integer.toHexString(2);
        System.out.println(s2);

        String s10 = Integer.toHexString(10);
        System.out.println(s10);

        String s15 = Integer.toHexString(15);
        System.out.println(s15);

        String s16 = Integer.toHexString(16);
        System.out.println(s16);

        String s17 = Integer.toHexString(17);
        System.out.println(s17);

        String s34 = Integer.toHexString(34);
        System.out.println(s34);

        String s255 = Integer.toHexString(255);
        System.out.println(s255);

        System.out.println("------------------------------");

        String f1 = Integer.toHexString(-1);
        System.out.println(f1);

        String f2 = Integer.toHexString(-2);
        System.out.println(f2);

        String f127 = Integer.toHexString(-127); // -127在数轴上转为正数时129
        System.out.println(f127);

        String s129 = Integer.toHexString(129); // -127在数轴上转为正数时129
        System.out.println(s129);

        String s254 = Integer.toHexString(254);
        System.out.println(s254);

    }

    @Test
    public void name22222() {
        byte[] hex2ByteArr = Hex2ByteArr("58 02");
        byte[] long2ByteArr = long2ByteArr(225304545l);

        String byteArr2Bin = byteArr2Bin(long2ByteArr);
        String byteArr2Hex = byteArr2Hex(long2ByteArr);
        String byteArr2Unsigned = byteArr2Unsigned(long2ByteArr);
        System.out.println(byteArr2Unsigned);

    }

    @Test
    public void name2222() {
        // String hexString = "58 02";

        String hexString = "00 0a 01 02";
        byte[] byteArr = Hex2ByteArr(hexString);
        System.out.println("十六进制转换成byte数组为->");
        for (int i = 0; i < byteArr.length; i++) {
            System.out.print(byteArr[i] + ",");
        }
        System.out.println("-----------------------------------");
        String binary = byteArr2Bin(byteArr);
        System.out.println("byte数组转换成二进制->" + binary);
        String convertToUnsigned = byteArr2Unsigned(byteArr);
        System.out.println(convertToUnsigned);
    }

    @Test
    public void name2() {
        String hexString = "aa 55 18 00 c0 a8 00 06 01 00 0a 00 6e 65 77 5f 73 65 72 69 65 73 ff ff ";
        byte[] byteArr = Hex2ByteArr(hexString);
        String hex = byteArr2Hex(byteArr);
        System.out.println(hex);

    }

    /**
     * 十六进制转byte数组
     * 十六进制转bit
     * 十六进制转无符号数
     */
    @Test
    public void name3() {
        // String hexString = "00 0e a6 00";
        // String hexString = "18 05 07 0c 04 2a 00 de";

        String hexString = "00 01 2a 04 0c 07 05 18";

        // String hexString = "18 05 07 0c 04 2a de 00";
        byte[] byteArr = Hex2ByteArr(hexString);
        String binary = byteArr2Bin(byteArr);
        String byteArr2Hex = byteArr2Hex(byteArr);
        System.out.println(byteArr2Hex);

        String byteArr2Unsigned = byteArr2Unsigned(byteArr);

        ByteBuffer buffer = ByteBuffer.wrap(byteArr);
        int result = buffer.getInt();

        System.out.println("byte->有符号数" + result);
        for (int i = 0; i < byteArr.length; i++) {
            System.out.print(byteArr[i]);
        }
        System.out.println(binary);
        System.out.println(byteArr2Unsigned);

    }

    /**
     * 无符号数转byte
     */
    @Test
    public void name333() {
        String long2Binary = long2Binary(2101254, 32);
        byte[] long2ByteArr = long2ByteArr(201006);
        String byteArr2Hex = byteArr2Hex(long2ByteArr);

        System.out.println(byteArr2Hex);
    }

    public byte[] Hex2ByteArr(String inHex) {
        String[] hex = inHex.split(" ");// 将接收的字符串按空格分割成数组
        byte[] byteArray = new byte[hex.length];
        for (int i = 0; i < hex.length; i++) {
            // parseInt()方法用于将字符串参数作为有符号的n进制整数进行解析
            byteArray[i] = (byte) Integer.parseInt(hex[i], 16);
        }
        return byteArray;
    }

    public String charArr2Unsigned(char[] binaryArray) {
        int result = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            // 右移一位，然后将二进制数的这一位设为1或0
            result = (result << 1) + (binaryArray[i] - '0');
        }
        return String.valueOf(result);
    }

    public String byteArr2Unsigned(byte[] bytes) {
        long result = 0;
        for (int i = 0; i < bytes.length; i++) {
            // 将每个字节解释为无符号整数，然后左移8位，并将结果加到结果中
            result = (result << 8) + (bytes[i] & 0xFF);
        }
        return String.valueOf(result);
    }

    // 无符号long转换为bit位
    // public char[] long2Binary(Long num, Integer bitWise) {
    // if (num < 0) {
    // throw new RuntimeException("参数为负,请输入无符号数");
    // }
    // char[] res = new char[bitWise];
    // for (int i = 0; i < res.length; i++) {
    // res[i] = '0';
    // }
    // String s = Long.toBinaryString(num);
    // char[] chars = s.toCharArray();

    // int j = res.length - 1;
    // for (int i = chars.length - 1; i >= 0; i--) {

    // res[j--] = chars[i];
    // }
    // return res;
    // }

    public String long2Binary(int k, Integer bitWise) {
        if (k < 0) {
            throw new RuntimeException("参数为负,请输入无符号数");
        }
        char[] res = new char[bitWise];
        for (int i = 0; i < res.length; i++) {
            res[i] = '0';
        }
        String s = Long.toBinaryString(k);
        char[] chars = s.toCharArray();

        int j = res.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {

            res[j--] = chars[i];
        }
        return new String(res);
    }

    // 无符号数转换为Byte数组
    public byte[] long2ByteArr(long num) {
        byte[] bytes = BigInteger.valueOf(num & 0xffffffffffffffffL).toByteArray();
        return bytes;
    }

    public String byteArr2Bin(byte[] inByte) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < inByte.length; i++) {
            String tString = Integer.toBinaryString((inByte[i] & 0xFF) + 0x100).substring(1);
            sb.append(tString);
            sb.append(" ");
        }
        return sb.toString();
    }

    public String byteArr2Hex(byte[] inByte) {
        StringBuilder sb = new StringBuilder();
        String hexString;
        for (int i = 0; i < inByte.length; i++) {
            // toHexString方法用于将16进制参数转换成无符号整数值的字符串
            String hex = Integer.toHexString(inByte[i]);
            if (hex.length() == 1) {
                sb.append("0");// 当16进制为个位数时，在前面补0
            }
            if (hex.length() > 2) {
                hex = hex.substring(hex.length() - 2);
            }
            sb.append(hex);// 将16进制加入字符串
            sb.append(" ");// 16进制字符串后补空格区分开
        }
        hexString = sb.toString();
        hexString = hexString.toUpperCase();// 将16进制字符串中的字母大写
        return hexString;
    }

    // =======simpole中转换byte[]================================================================================================================
    public static byte[] intToByte(int i) {
        byte[] b = new byte[8];
        b[0] = (byte) (i & 0xff);
        b[1] = (byte) (i >> 8 & 0xff);
        b[2] = (byte) (i >> 16 & 0xff);
        b[3] = (byte) (i >> 24 & 0xff);

        return b;
    }

    public static byte[] longToByte(long i) {
        byte[] b = new byte[8];
        b[0] = (byte) (i & 0xff);
        b[1] = (byte) (i >> 8 & 0xff);
        b[2] = (byte) (i >> 16 & 0xff);
        b[3] = (byte) (i >> 24 & 0xff);
        b[4] = (byte) (i >> 32 & 0xff);
        b[5] = (byte) (i >> 40 & 0xff);
        b[6] = (byte) (i >> 48 & 0xff);
        b[7] = (byte) (i >> 56 & 0xff);
        return b;
    }

    public static byte[] shortToByte(short i) {
        byte[] b = new byte[8];
        b[0] = (byte) (i & 0xff);
        b[1] = (byte) (i >> 8 & 0xff);

        return b;
    }

    public static byte[] charToByte(char i) {
        byte[] b = new byte[8];
        b[0] = (byte) (i & 0xff);

        return b;
    }

    public static byte[] floatToByte(float i) {
        return intToByte(Float.floatToIntBits(i));
    }

    public static byte[] doubleToByte(double i) {
        return longToByte(Double.doubleToLongBits(i));
    }

}
