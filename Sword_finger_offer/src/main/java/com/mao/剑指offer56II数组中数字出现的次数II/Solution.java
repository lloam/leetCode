package com.mao.剑指offer56II数组中数字出现的次数II;

/**
 * Author: Administrator
 * Date: 2021/7/9 23:19
 * Description: 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class Solution {

//    /**
//     * 太过复杂
//     * 具体看 k 神
//     * 核心就是位运算
//     * @param nums
//     * @return
//     */
//    public int singleNumbers(int[] nums) {
//        int ones = 0, twos = 0;
//        for (int num : nums) {
//            ones = ones ^ num & ~twos;
//            twos = twos ^ num & ~ones;
//        }
//        return ones;
//    }

    /**
     * 第二种方法更好理解
     * 将所求数字的 32 为二进制全部求出来再求数字
     * @param nums
     * @return
     */
    public int singleNumbers(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < count.length; i++) {
                count[i] += num & 1;
                // 逐个求出当前遍历数字的每一位，注意第一个二进制位跑到 count[31] 了
                num >>= 1;
            }
        }
        // 然后将 count 的每一个值 % 3 得到所求数字的二进制位
        for (int i = 0; i < count.length; i++) {
            count[i] = count[i] % 3;
        }

        // 现在 count 的每个值就是所求数字的二进制位，只不过是反过来的
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            res <<= 1;
            res |= count[31 - i]; // 因为是反过来的，所以要从后往前算
        }
        return res;
    }

}
