package com.mao.剑指offer57I和为s的两个数字;

/**
 * Author: Administrator
 * Date: 2021/6/16 22:18
 * Description: 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 这题与和为s的连续正数差不多，都可以用双指针来解决
 * 双指针分别从数组的两端开始向中间移动
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 定位数组下标
        int i = 0,j = nums.length-1;
        int sum = 0;
        int[] res = new int[2];
        while (i < j){
            sum = nums[i] + nums[j];
            // 如果和小于目标值，则总值要变大，也只能i增加
            if(sum < target){
                i++;
                // 如果大于目标值，则总值要变小，也就是只能 j 减小
            }else if(sum > target){
                j--;
            }else {
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            }
        }
        return res;
    }
}
