package com.mao.面试题17_04消失的数字;

/**
 * Author: 但愿人长久
 * Date: 2021/8/31 23:57
 * Description: 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。
 * 你有办法在O(n)时间内完成吗？
 */
public class Solution {


    /**
     * 使用异或特性，同一个值异或两次返回本身
     * 例如 0 ^ 3 = 3
     * 再次异或 0 ^ 3 = 0
     * 所以对数组元素异或两次，结果就是缺失的那个数
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {

            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
