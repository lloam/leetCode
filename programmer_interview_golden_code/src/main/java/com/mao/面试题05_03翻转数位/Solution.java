package com.mao.面试题05_03翻转数位;

/**
 * Author: 但愿人长久
 * Date: 2021/8/24 23:56
 * Description: 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 */
public class Solution {

//    /**
//     * 维护一个数组
//     * 遇到一个 1 数组当前下标元素 + 1
//     * 遇到一个 0 数组下标 + 1
//     * 最后返回数组相邻元素和 + 1
//     * @param num   数字
//     * @return
//     */
//    public int reverseBits(int num) {
//
//        if (num == -1) {
//            return 32;
//        }
//
//        // 保存连续 1 的个数
//        int[] res = new int[32];
//
//        // 数组下标
//        int index = 0;
//
//        // 循环
//        while (num != 0) {
//
//            // num & 1
//            if ((num & 1) == 1) {
//                //如果 == 1，说明 num 的最后一位是 1
//                res[index]++;
//            }else {
//                // 如果 ！= 1，说明 num 最后一位是 0，那么数组下标 + 1
//                index++;
//            }
//
//            // 遍历完一位，数组右移一位，考虑有负数，使用无符号右移
//            num >>= 1;
//        }
//
//        int max = 0;
//
//        // 循环结束，遍历数组，寻找最大数字
//        for (int i = 0; i < res.length - 1; i++) {
//
//            // 找出最大值
//            max = Math.max(max, res[i] + res[i+1] + 1);
//        }
//        return max;
//    }


    /**
     * 使用动态规划
     * 每次维护三个变量
     * cur：当前位置为止连续 1 的个数，遇到 0 归 0，遇到 1 加 1
     * insert：在当前位置变成 1，往前数连续 1 的最大个数，遇到 0 变为 cur + 1，遇到 1 加 1
     * res：保存 insert 的最大值
     * @param num   数字
     * @return
     */
    public int reverseBits(int num) {

        int cur = 0, insert = 0, res = 1;

        for (int i = 0; i < 32; i++) {

            if ((num & (1 << i)) != 0) {
                // 如果 num 的第 i 位是 1
                cur++;
                insert++;
            }else {
                // 如果 num 的第 i 位是 0
                insert = cur + 1;
                cur = 0;
            }

            res = Math.max(res, insert);
        }

        return res;
    }
}
