package com.mao.剑指offer10I斐波那契数列;

/**
 * Author: Administrator
 * Date: 2021/6/22 22:03
 * Description: 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
 * 斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
//    /**
//     * 利用斐波那契数列的公式很容易就得出来了
//     * 利用动态规划分别求 f(n - 1) 和 f(n - 2)
//     * 当 n 为 0 的时候为 0，当 n 为 1 的时候为1
//     * 但是算出的结果还要进行 取模，也就是当 返回的数字 > 1000000007 的时候
//     * 不能用递归的原因是当求 f(n - 1)的时候要求f(n - 2)，后面还要再递归求 f(n - 2)，也就是说会增加递归次数，重复递归
//     * @param n
//     * @return
//     */
//    public int fib(int n) {
//        int a = 0,b = 1;
//        int sum = 0;
//        for(int i = 0;i < n; i++){
//            // 仔细想想这也是斐波那契数列的公式的转化 F(N) = F(N - 1) + F(N - 2)
//            sum = (a + b) % 1000000007;
//            a = b;
//            b = sum;
//        }
//        return a;
//    }


    /**
     * 不能用递归，不然会造成重复递归，增加递归次数
     * 采用动态规划记忆增加法
     * 斐波那契数列就是循环求和
     * @param n
     * @return
     */
    public int fib(int n) {

        // 定义 f(0) f(1)
        int a = 0, b = 1, sum = 0;

        for (int i = 0; i < n; i++) {

            sum = (a + b) % 1000000007;

            a = b;

            b = sum;
        }

        return a;

    }
}
