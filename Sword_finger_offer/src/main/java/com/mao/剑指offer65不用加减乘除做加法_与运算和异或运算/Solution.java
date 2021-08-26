package com.mao.剑指offer65不用加减乘除做加法_与运算和异或运算;

/**
 * Author: Administrator
 * Date: 2021/6/18 23:27
 * Description: 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */
public class Solution {
    /**
     * 还得看大佬才能做得出来题目
     * 此题是考察位运算的运用
     * 将 a b 转化成二进制的数，
     * a&b<<1得到需要进位的二进制数
     * a^b 得到不需要进位的二进制数
     * 循环将 求出与运算和异或运算的二进制数，当与运算二进制数为0的时候，异或运算的结果就是和
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        int c = 0;
        while (b != 0){
            c = (a&b) << 1;
            a = a^b;
            b = c;
        }
        return a;
    }
}
