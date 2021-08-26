package com.mao.剑指offer15二进制中1的个数;

/**
 * Author: Administrator
 * Date: 2021/6/30 22:40
 * Description: 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 */
public class Solution {
    // you need to treat n as an unsigned value
//
//    /**
//     * 涉及到二进制一般都会有与运算
//     * 可以让 n & 1，如果返回 1，则二进制 n 最后一位是 1
//     * 如果返回 0 ，则二进制 n 最后一位是 0，
//     * 然后让 n 右移一位，重新记录 n 的最后一位是否为 1
//     * @param n
//     * @return
//     */
//    public static int hammingWeight(int n) {
//        // 存储结果
//        int res = 0;
//        // 如果 n 不为 0 ，就一直循环 & 1
//        while (n != 0){
//            res += n & 1;
//            // 将 n 右移一位
//            n >>= 1;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(hammingWeight(128));
//    }

//    /**
//     * 大神的方法，使用 n & (n -1)，当 n 为 0 的时候跳出循环，循环的次数就是 1 的个数
//     * @param n
//     * @return
//     */
//    public static int hammingWeight(int n) {
//        int res = 0,i = 0;
//        while (n != 0){
//            n &= (n-1);
//            res++;
//        }
//        return res;
//    }

//    /**
//     * 采用 n 和 1 相与
//     * 返回 0 表示 n 的二进制最后一位是 0
//     * 返回 1 表示 n 的二进制最后一位是 1
//     * @param n 输入的无符号整数
//     * @return
//     */
//    public static int hammingWeight(int n) {
//
//        // 用于记录 1 的个数
//        int res = 0;
//
//        // 循环相与
//        while (n != 0) {
//
//            res += n & 1;
//
//            // 记录完最后一位就将 n 右移一位
//            n >>= 1;
//        }
//
//        return res;
//    }


    /**
     * 巧妙使用 n & (n-1)
     * 使 n &= (n-1) 这样每次都能使 n 的二进制数减少一个 1
     * 直至 n = 0
     * @param n 输入的无符号整数
     * @return
     */
    public int hammingWeight(int n) {

        // 用于存储 1 的个数
        int  res = 0;

        while (n != 0) {

            // 使 n 的二进制中 1 的个数减少一个
            n &= (n-1);

            // 每次减少一个 1，结果就 + 1
            res++;
        }

        // 循环结束，返回结果 res
        return res;

    }
}
