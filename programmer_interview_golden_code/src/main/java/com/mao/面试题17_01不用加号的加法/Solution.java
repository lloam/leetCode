package com.mao.面试题17_01不用加号的加法;

/**
 * Author: 但愿人长久
 * Date: 2021/8/30 22:46
 * Description: 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 */
public class Solution {

    /**
     * 要理解异或是不进位的加法
     * 也就是说当 a + b 中的二进制没有相同位置的 1 的时候就可以直接使用
     * 异或得到加法结果
     * 所以就是要判断是否要进位，如果要进位就直接进位得到结果
     * @param a     数 a
     * @param b     数 b
     * @return
     */
    public int add(int a, int b) {

        // 先异或得到不需要进位的二进制
        int res = a ^ b;

        // 再相与得到要进位的二进制
        int cur = a & b;

        // 当要进位的二进制为 0 的时候异或就是结果
        while (cur != 0) {

            // 记录这个 temp
            int tem = res;

            // cur 需要进位，即左移一位
            cur <<= 1;

            // 异或
            res ^= cur;

            // 相与
            cur &= tem;
        }

        return res;
    }
}
