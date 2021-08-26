package com.mao.剑指offer56I数组中数字出现的次数;

/**
 * Author: Administrator
 * Date: 2021/7/9 22:10
 * Description: 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Solution {

    /**
     * 异或运算
     * 考虑如果只有一个只出现一次的数字的话，那么只需要将数组元素异或就可以得到这个数字
     * 如果是两个的话就要想办法将这两个数字分开成两组，然后每一组各自异或
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        // 将得到这两个只出现一次的数字的异或的数
        for (int num : nums) {
            res ^= num;
        }
        // 然后得到异或数字其中二进制的一位数字 1
        int div = 1;
        while ((div&res) == 0) {
            div <<= 1;
        }
        // 得到这个 div 之后，因为这个是 1，所以所求的两个数字肯定有一个在这个位置为 0，一个为 1
        // 因此就能将这两个数字分开
        int a = 0, b = 0;
        for (int num : nums) {
            if((div&num) != 0) {
                a ^= num;
            }else {
                b ^= num;
            }
        }
        // 找到两个数字即位 a， b
        return new int[]{a,b};
    }
}
