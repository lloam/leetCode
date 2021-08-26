package com.mao.剑指offer61扑克牌中的顺子;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Administrator
 * Date: 2021/7/3 22:25
 * Description: 从扑克牌中随机抽5张牌，判断是不是一个顺子，
 * 即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 主要思想就是要知道最大值与最小值得关系
//     * max - min < 5
//     * @param nums
//     * @return
//     */
//    public boolean isStraight(int[] nums) {
//        // 使用 set 集合判断是否有重复
//        Set<Integer> repeat = new HashSet<>();
//        /***************这里真的挺妙的，可以确定最大值和最小值开始遍历的时候一定是第一个不为 0 的数****************/
//        int max = 0,min = 14;
//        for (int num : nums) {
//            // 判断 num 是否是大小王
//            if(num == 0) continue;
//            // 先判断是否有这个数，如果有重复的数直接返回 false
//            if(repeat.contains(num)) return false;
//            max = Math.max(max,num);
//            min = Math.min(min,num);
//            repeat.add(num);
//        }
//        return max-min < 5;
//    }

    /**
     * 还有一种方法就是判断当前数字与下一个数字是否相等，相等就 false，不相等就 true
     * 但是要基于排序数组的情况下
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        // 记录大小王的个数
        int king = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == 0) king++;
            else if(nums[i] == nums[i+1]) return false;
        }
        return nums[nums.length] - nums[king] < 5;
    }
}
