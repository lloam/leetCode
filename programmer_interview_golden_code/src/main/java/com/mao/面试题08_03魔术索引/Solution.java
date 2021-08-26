package com.mao.面试题08_03魔术索引;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: 但愿人长久
 * Date: 2021/8/25 11:58
 * Description: 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，
 * 满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，
 * 若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，
 * 返回索引值最小的一个。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 二分思想，当然直接遍历也可以出结果
     * @param nums
     * @return
     */
    public int findMagicIndex(int[] nums) {

//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == i) return i;
//        }
//        return -1;

        return getAnswer(nums, 0, nums.length - 1);
    }

    /**
     * 递归返回结果
     * @param nums  目标数组
     * @param left  左边界
     * @param right 右边界
     * @return
     */
    private int getAnswer(int[] nums, int left, int right) {

        // 递归结束，没有结果返回 -1
        if (left > right) return -1;

        int mid = (right - left) / 2 + left;

        // 先判断左边有没有值
        int leftAnswer = getAnswer(nums, left, mid - 1);

        if (leftAnswer != -1) {
            // 如果左边值返回的不是 -1，说明已经找到合法值，直接返回
            return leftAnswer;
        }else if (nums[mid] == mid) {
            // 如果左边值返回的是 -1，但是中间值合法，直接返回
            return mid;
        }

        // 如果左边值和中间值都不合法，递归右边值
        return getAnswer(nums, mid + 1, right);
    }
}
