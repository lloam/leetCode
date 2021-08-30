package com.mao.面试题17_16按摩师;

/**
 * Author: 但愿人长久
 * Date: 2021/8/29 23:49
 * Description: 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，
 * 替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。  注意：本题相对原题稍作改动
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 动态规划
     * 将 dp(i,0) 代表按摩师不接 i 号预约的总预约时长
     * dp(i,0) = max(dp(i-1,0),dp(i-1,1)) 即等于前一位预约或者不预约的最大值
     * 将 dp(i,1) 代表按摩师接 i 号预约的总预约时长
     * dp(i,1) = dp(i-1,0) + num(i) 即等于前一位不预约 + num(i)
     * @param nums
     * @return
     */
    public int massage(int[] nums) {

        if (nums.length == 0) return 0;

        // 分别代表不接受和接受第 i 为预约
        int dp0 = 0, dp1 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 第 i 号拒绝
            int no = Math.max(dp0,dp1);
            // 第 i 号接受
            int yes = dp0 + nums[i];

            // 动态赋值
            dp0 = no;
            dp1 = yes;
        }

        return Math.max(dp0,dp1);
    }
}
