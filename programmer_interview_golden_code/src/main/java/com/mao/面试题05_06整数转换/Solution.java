package com.mao.面试题05_06整数转换;

/**
 * Author: 但愿人长久
 * Date: 2021/8/25 11:39
 * Description: 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 */
public class Solution {


    /**
     * 思想就是先异或得到 A 与 B 不同的二进制位
     * 然后计算 1 的个数
     * @param A
     * @param B
     * @return
     */
    public int convertInteger(int A, int B) {

        int temp = A ^ B;

        // 返回的结果
        int res = 0;

        // 循环，当 temp = 0时结束循环
        while (temp != 0) {

            if ((temp & 1) == 1) {
                // 此时说明 temp 最后一位是 1
                res++;
            }

            // temp 右移一位，考虑到有负数，使用无符号右移
            temp >>= 1;
        }

        return res;
    }
}
