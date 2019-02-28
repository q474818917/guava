package com.google.guava.arithmetic;

import java.util.Scanner;

/**
 * 负数转二进制：先反码、后补码、再移动
 * 二进制转负数：先移动，后反码、再补码
 * 无符号右移>>> ，高位补0
 * 负数右移>>，高位补1，正数右移>>，高位补0
 */
public class Operator {

    public static void main(String args[]) {

        // -3：原码（也就是3的二进制）：00000000 00000000 00000000 00000011
        // -3：反码：11111111 11111111 11111111 11111100
        // -3：补码（正数转负数需要+1）：11111111 11111111 11111111 11111101
        System.out.println(Integer.toBinaryString(-3));  //打印二进制 11111111111111111111111111111101
        System.out.println(Integer.toBinaryString(3));  //打印二进制 11

        System.out.println(Integer.toBinaryString(-3 >>> 1)); // 高位补0，011111111 11111111 11111111 1111110
        System.out.println(Integer.toBinaryString(-3 >> 1));  // 高位补1，11111111 11111111 11111111 11111110
        System.out.println(3 >> 1);
    }


}
