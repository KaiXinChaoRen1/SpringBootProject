package com.lwq.jk1.j00_hello_algo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DataTypesTest {

    /**
     * 字符编码
     * 
     * ASCII码 7位(一个字节的低7位) 表示128个不同的字符 包含英文大小写 26*2 数字 10 一些标点 换行符等
     * 
     * GBK ,中国发布, GB2312, 是扩展版,其中ASCII用1字节表示,汉字用2字节
     * 
     * Unicode,全世界语言 ,常用占2字节,也有3,4字节的,因此出现了长短不统一,读取的问题
     * 
     * UTF‑8 (使用1-4字节,UTF16 使用2or4)已成为国际上使用最广泛的Unicode 编码方法。它是一种可变长度的编码
     * 对于长度为1 字节的字符，将最高位设置为0 ，其余7 位设置为Unicode 码点。值得注意的是，ASCII
     * 字符在Unicode 字符集中占据了前128 个码点。也就是说，UTF‑8 编码可以向下兼容ASCII 码
     * 长度大于1的字符,有其他校验方式
     */
    @Test
    public void a12() {

    }

    /**
     * 浮点数 小数点后表示
     * float 的表示方式包含指数位，导致其取值范围远大于int
     * 尽管浮点数float 扩展了取值范围，但其副作用是牺牲了精度。整数类型int 将全部32 比特用于表示数字，
     * 数字是均匀分布的；而由于指数位的存在，浮点数float 的数值越大，相邻两个数字之间的差值就会趋向越
     * 大
     */
    @Test
    public void a1() {

        float f = 0.123456789123456789F;
        System.out.println(f);
        float f2 = 0.000000000123456789F;
        System.out.println(f2);
        float f3 = 0.111111111123456789F;
        System.out.println(f3);
        float f4 = 0.000006666123456789F;
        System.out.println(f4);
    }
}
