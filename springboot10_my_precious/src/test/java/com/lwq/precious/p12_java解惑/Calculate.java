package com.lwq.precious.p12_java解惑;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class Calculate {

    /**
     * 正数的二进制表示,最高位是0 其他位是原码(也可以说是补码,因为正数的原码补码一样)
     * 负数的二进制表示,是数字绝对值的补码(取反+1)
     * 
     * 符号位为0(正)的0代表0
     * 符号位为1 的0代表最小的负数 ,因此负数多一个
     */
    @Test
    public void a11111() {

        System.out.println("127的二进制表示 ==>" + Integer.toBinaryString(127));
        System.out.println("126的二进制表示 ==>" + Integer.toBinaryString(126));
        System.out.println("5的二进制表示   ==>" + Integer.toBinaryString(5));
        System.out.println("1的二进制表示   ==>" + Integer.toBinaryString(1));
        System.out.println("0的二进制表示   ==>" + Integer.toBinaryString(0));
        System.out.println("-1的二进制表示  ==>" + Integer.toBinaryString(-1));
        System.out.println("-5的二进制表示  ==>" + Integer.toBinaryString(-5));
        System.out.println("-126的二进制表示==>" + Integer.toBinaryString(-126));
        System.out.println("-127的二进制表示==>" + Integer.toBinaryString(-127));
        System.out.println("-128的二进制表示==>" + Integer.toBinaryString(-128));

    }

    @Test
    public void a1111() {
        String hexString = Long.toHexString(0xaa);
        System.out.println(hexString);

        String hexString2 = Long.toHexString(170);
        System.out.println(hexString2);

        String hexString3 = Integer.toString(0x80000001);
        System.out.println(hexString3);

        /**
         * 首先，我们把十六进制的0x80000001转换为二进制形式：
         * 
         * 0x80000001 => 1000 0000 0000 0000 0000 0000 0000 0001
         * 这是一个32位的二进制数。在补码表示法中，最高位（即最左边的位）是符号位。0表示正数，1表示负数。因此，这个二进制数表示的是一个负数。
         * 
         * 接下来，我们需要找到它的补码。对于负数，补码的计算方法是取反（除符号位外的所有位取反）然后加1：
         * 
         * 1000 0000 0000 0000 0000 0000 0000 0001 （原始二进制数）
         * 1111 1111 1111 1111 1111 1111 1111 1110 （取反，符号位保持不变）
         * 1111 1111 1111 1111 1111 1111 1111 1111 （加1）
         * 但是，由于我们是在32位整数的范围内操作，所以加1后溢出的位（最左边的1）应该被舍弃，因为32位整数无法表示这么大的数值：
         * 
         * 1111 1111 1111 1111 1111 1111 1111 1111 （最终的补码）
         * 现在，我们需要将这个补码转换回十进制数。由于这是一个补码表示的负数，我们需要先找到它的原码，然后取反，再加上负号：
         * 
         * 1111 1111 1111 1111 1111 1111 1111 1111 （补码）
         * 1000 0000 0000 0000 0000 0000 0000 0000 （原码，符号位不变，其余位取反）
         * 然后，我们计算这个二进制数的十进制值：
         * 
         * -2^31 = -2147483648
         * 因此，0x80000001转换为十进制的int是-2147483648。这是一个32位整数能表示的最小负数。
         */
    }

    @Test
    public void a111() {

        final long l1 = 24 * 60 * 60 * 1000 * 1000;
        final long l2 = 24 * 60 * 60 * 1000;
        System.out.println(l1 / l2);

        final long l3 = 24L * 60L * 60L * 1000L * 1000L;
        final long l4 = 24L * 60L * 60L * 1000L;
        System.out.println(l3 / l4);
    }

    @Test
    public void a1() {
        System.out.println(2 % 2);
        System.out.println(3 % 2);
        System.out.println(0 % 2);

        System.out.println(-2 % 2);
        System.out.println(-3 % 2);
    }

    @Test
    public void a11() {
        System.out.println(5 & 2); // 101 & 010
        System.out.println(5 & 3);// 101 & 011

    }

}
