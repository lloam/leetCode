package com.mao.剑指offer42连续子数组的最大和;

import java.util.Map;

/**
 * Author: Administrator
 * Date: 2021/7/3 15:48
 * Description: 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。  要求时间复杂度为O(n)。
 */
public class Solution {

//    /**
//     * 动态规划
//     * 设 dp[i] 是那个和最大的值，nums[i] 是连续子数组的最后一位
//     * 则如果 dp[i-1] < 0 ，dp[i-1] 对 dp[i] 产生的就是负贡献，那么就舍弃 i-1 以前的数
//     * 如果 dp[i-1] > 0 ，dp[i] 就要等于 dp[i -1] + nums[i]
//     * @param nums
//     * @return
//     */
//    public int maxSubArray(int[] nums) {
//        int res = nums[0];
//        for(int i = 1; i < nums.length; i++){
//            nums[i] += Math.max(nums[i-1],0);
//            res = Math.max(res,nums[i]);
//        }
//        return res;
//    }

    /**
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
