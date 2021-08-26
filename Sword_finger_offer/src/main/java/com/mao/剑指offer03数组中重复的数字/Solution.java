package com.mao.剑指offer03数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Administrator
 * Date: 2021/5/30 22:06
 * Description: 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

//    public static int findRepeatNumber(int[] nums){
//        int repeat = -1;
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(!set.add(nums[i])){
//                repeat = nums[i];
//                break;
//            }
//        }
//        return repeat;
//    }
//
//    /**
//     * 第一种
//     * 使用 hashset 集合
//     * set 集合是不可重复的
//     * @param nums
//     * @return
//     */
//    public static int findRepeatNumber(int[] nums) {
//
//        // 创建一个 set 集合
//        Set<Integer> set = new HashSet<>();
//
//        for (int i = 0; i < nums.length; i++) {
//
//            // 如果 set 集合已经含有这个数字
//            if(set.contains(nums[i])) {
//                return nums[i];
//            }
//
//            set.add(nums[i]);
//        }
//        return -1;
//    }

    /**
     * 第二种
     * 长度为 n 的数组存储 0~n - 1 的数字
     * 如果有重复元素
     * 说明数组的下标对应下标数字，但是有别的下标也对应这个数字
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            if (nums[i] == i) {
                i++;
                continue;
            }

            if(nums[nums[i]] == nums[i]) {
                return nums[i];
            }

            int temp = nums[i];

            nums[i] = nums[temp];

            nums[temp] = temp;
        }
        return -1;
    }
}
