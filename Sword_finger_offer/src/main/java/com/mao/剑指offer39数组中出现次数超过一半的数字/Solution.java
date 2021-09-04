package com.mao.剑指offer39数组中出现次数超过一半的数字;

/**
 * Author: Administrator
 * Date: 2021/7/3 16:03
 * Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution {

//    /**
//     * 求众数
//     * 假设第一个数 x 是众数，那么记票数 votes = 1
//     * 如果遇到第二个数仍然 = x，那么票数 votes++
//     * 否则 votes--
//     * 当 votes = 0的时候，当前数字设为众数
//     * @param nums
//     * @return
//     */
//    public int majorityElement(int[] nums) {
//        // 假设第一个为众数
//        int votes = 0, x = 0;
//        for(int i = 1; i < nums.length; i++) {
//            // 如果票数为 0 ，则当前数字为众数
//            if(votes == 0) x = nums[i];
//            if(nums[i] == x) {
//                votes++;
//            }else {
//                votes--;
//            }
//        }
//        return x;
//    }

    /**
     * 求众数
     * 维护两个变量
     * 一个是票数，票数最多的就是众数 vote
     * 一个是当前的众数 x
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int vote = 1, x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (vote == 0) x = nums[i];
            if (nums[i] == x) {
                // 相同的数，票数 + 1
                vote++;
            }else {
                // 不同的数，票数 - 1
                vote--;
            }
        }
        return x;
    }
}
