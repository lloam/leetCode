package com.mao.面试题10_01合并排序的数组;

import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/26 11:17
 * Description: 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。  初始化 A 和 B 的元素数量分别为 m 和 n。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 双指针
     * 一个指向 A 数组下标
     * 一个指向 B 数组下标
     * 考虑到前面添加会覆盖 A 中的元素
     * 于是从后面开始往前添加
     * @param A     A 排序数组
     * @param m     A 元素数量
     * @param B     B 排序数组
     * @param n     B 元素数量
     */
    public void merge(int[] A, int m, int[] B, int n) {

        // A B 中的下标
        int i = m - 1, j = n - 1;

        // 合并后 A 的下标
        int index = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (A[i] <= B[j]) A[index--] = B[j--];
            else A[index--] = A[i--];

        }

        // 因为 A 有足够的空间容纳 B 中的元素，所以循环结束 i >= 0
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }

    public static void main(String[] args) {

        int[] A = new int[]{1, 2, 3, 0, 0, 0};

        int[] B = new int[]{2, 5, 6};

        new Solution().merge(A, 3, B, 3);

        System.out.println(Arrays.toString(A));
    }
}
