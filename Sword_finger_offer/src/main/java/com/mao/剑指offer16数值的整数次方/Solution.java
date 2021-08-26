package com.mao.剑指offer16数值的整数次方;

/**
 * Author: Administrator
 * Date: 2021/7/5 20:01
 * Description:  实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * 不得使用库函数，同时不需要考虑大数问题。
 */
public class Solution {

//    /**
//     * 使用快速幂法计算 n 次幂
//     * @param x
//     * @param n
//     * @return
//     */
//    public double myPow(double x, int n) {
//        if(x == 0) return 0;
//        // java 代码中 int32 变量 -2147483648 <= n <= 2147483647，当 n -2147483748 时，转换会出错，所以用 long 类型进行操作
//        long b = n;
//        double res = 1.0;
//        // 如果是负数次幂的话需要转化一下
//        if(b < 0) {
//            x = 1 / x;
//            b = -b;
//        }
//        // 循环，直到 b <= 0
//        while (b > 0) {
//            if((b & 1) == 1) res *= x;
//            x *= x;
//            b >>= 1;
//        }
//        return res;
//    }

    /**
     * 使用快速幂的方法
     * 采取二分法的思想
     * @param x 底数
     * @param n 指数
     * @return
     */
    public double myPow(double x, int n) {

        if (x == 0) return 0;

        double res = 1.0;

        // java 中的 int32 变量范围 -2147483648 <= n <= 2147483647
        // 当 n = -2147483648 时，变成相反数 2147483648 会造成越界问题，因此将 int 类型转换为 long 类型
        long b = n;

        // 如果指数是负数，就要将指数变成相反数并且将底数变成倒数
        if (b < 0) {

            // 将 b 变成相反数
            b = -b;

            // 底数变为倒数
            x = 1 / x;
        }

        // 二分思想快速幂求指数
        while (b != 0) {

            // 使用与运算判断 b 是否为奇数
            if ((b & 1) != 0) res *= x;

            // 将 b 右移一位
            b >>= 1;

            // b 右移了一位， x 就要平方
            x *= x;
        }

        // 循环结束返回结果 res
        return res;
    }
}
