package com.mao.面试题08_01三步问题;

/**
 * Author: 但愿人长久
 * Date: 2021/8/25 11:50
 * Description: 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，
 * 小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 动态规划
     * 和斐波那契差不多的意思
     * @param n n 个台阶
     * @return
     */
    public int waysToStep(int n) {

        // 如果 n 小于 3，直接返回 n
        if (n < 3) return n;

        int zero = 1, one = 1, two = 2, sum = 0;

        for (int i = 2; i < n; i++) {

            sum = ((zero + one) % 1000000007 + two) % 1000000007;

            zero = one;

            one = two;

            two = sum;
        }

        return sum;
    }
}
