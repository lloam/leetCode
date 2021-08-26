package com.mao.剑指offer66构建乘积数组;

/**
 * Author: Administrator
 * Date: 2021/7/18 22:56
 * Description: 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 思想就是将第 i 个位置的左边部分元素相乘，存入一个数组 B[]
     * 然后将右边部分相乘，结果再乘于B[i]
     * 如果看不懂，直接看题解吧
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int length = a.length;
        // 保存乘积的数组
        int[] B = new int[length];
        if(length == 0) return B;

        B[0] = 1;

        // 先将左边部分相乘，遍历集合 A
        for (int i = 1; i < length; i++) {
            B[i] = B[i-1] * a[i-1];
        }

        // 此时 B 中元素是第 i 个元素左边部分的乘积
        // 再次遍历右边部分

        // 记录右边部分乘积
        int temp = 1;

        for (int i = length - 2; i >= 0; i--) {
            temp *= a[i+1];
            B[i] *= temp;
        }

        return B;
    }
}
