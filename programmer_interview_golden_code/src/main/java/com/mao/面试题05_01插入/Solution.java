package com.mao.面试题05_01插入;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;

/**
 * Author: 但愿人长久
 * Date: 2021/8/16 22:20
 * Description: 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/insert-into-bits-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 首先将数字 N 的二进制的第 i ~ j 位变成 0
     * 然后将数字 M 左移 i 位
     * 然后再将 M | N 得到返回结果
     * @param N 被插入的数字
     * @param M 需要插入的数字
     * @param i 从右往左第 i 位
     * @param j 从右往左第 j 位
     * @return
     */
    public int insertBits(int N, int M, int i, int j) {

        // 1、将数字 N 的二进制的第 i ~ j 位变成 0
        // ① 要使数字 N 的二进制的 第 i ~ j 位变成 0，就要让数字 N 和 一个数相与，
        // 这个数字的二进制数为除了 i ~ j 位的数字为 0，其他的数字均为 1 例如 j = 5，i = 1
        // 则这个相与的数字是 11111000001
        // 得到这个数字
        int mask = ((1 << (j - i + 1)) - 1) << i;
        // 取反得到这个数字
        mask =~ mask;

        // ② 数字 N 与 mask 相与:将数字 N 的二进制的第 i ~ j 位变成 0
        N &= mask;

        // 2、将数字 M 左移 i 位
        M = M << i;

        // 3、将 M | N 得到结果
        return M | N;
    }

//    static StringBuilder s = new StringBuilder();
//    public static void main(String[] args) {
//
//        System.out.println(test());
//
//        System.out.println(s);
//    }
//
//    public static StringBuilder test() {
//
//        try {
//            s.append("hello");
//
//            return s;
//        } finally {
//
//            s.append("world");
//
//            return s.append("hhh");
//        }
//
//    }
}
