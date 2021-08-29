package com.mao.面试题16_17连续数列;

/**
 * Author: 但愿人长久
 * Date: 2021/8/29 18:14
 * Description: 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 */
public class Solution {

    /**
     * 动态规划
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

    public static void main(String[] args) {
        int res = new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(res);
    }
}
