package com.mao.面试题17_10主要元素;

/**
 * Author: 但愿人长久
 * Date: 2021/9/1 10:39
 * Description: 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。
 * 若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 摩尔投票法
     * 数组中主要元素超过数组长度的一半
     * 那么这些元素与其他元素两两抵消
     * 剩下一个就是主要元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int count = 0;

        // 可能为主要元素
        int candidate = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                // count 为 0，先赋值 i
                candidate = nums[i];
            }

            if (candidate == nums[i]) {
                count++;
            }else {
                count--;
            }
        }

        // 此时 candidate 可能是主要元素，但不一定有主要元素，比如说 0,1,2,3,3,3
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) count++;
        }
        return count > nums.length/2 ? candidate : -1;
    }
}
