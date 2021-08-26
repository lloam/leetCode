package com.mao.剑指offer10II青蛙跳台阶问题;

/**
 * Author: Administrator
 * Date: 2021/6/22 22:41
 * Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
//    /**
//     * 依旧是斐波那契数列的第 n 项，只不过这个时候 f(0) = 1， f(1) = 1
//     * @param n
//     * @return
//     */
//    public int numWays(int n) {
//        int a = 1,b = 1,sum;
//        for(int i = 0; i < n; i++){
//            sum = (a + b) % 1000000007;
//            a = b;
//            b = sum;
//        }
//        return a;
//    }


    /**
     * 斐波那契
     * 跳上 n 阶台阶有 f(n) 种调法
     * 最后一次跳有两种情况， 跳 1 阶或者跳 2 阶
     * 则 f(n) = f(n - 1) + f(n - 2)
     * 只不过这个斐波那契是 f(0) = 1, f(1) = 1
     * @param n
     * @return
     */
    public int numWays(int n) {

        // 定义 f(0) f(1)
        int a = 1, b = 1, sum = 0;

        for (int i = 0; i < n; i++) {

            sum = (a + b) % 1000000007;

            a = b;

            b = sum;
        }

        return a;
    }
}
