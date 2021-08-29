package com.mao.sortalgorithm;

import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/27 12:14
 * Description: 快速排序
 */
public class QuickSort {

    public static void main(String args[]) {

        int[] num = new int[]{32,1,4,0,43,-12,324,65,98};
        System.out.println(Arrays.toString(num));
        quickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }

    /**
     * 快速排序
     * @param num
     */
    public static void quickSort(int[] num, int left, int right) {
        if (left > right) {
            // 递归退出条件
            return;
        }
        int l = left, r = right;
        while (l < r) {
            while (num[r] > num[left]) r--;
            while (num[l] < num[left]) l++;
            if (l == r) {
                int temp = num[l];
                num[l] = num[left];
                num[left] = temp;
            }else {
                int temp = num[l];
                num[l] = num[r];
                num[r] = temp;
            }
        }
        // 左边快速排序
        quickSort(num, left, l - 1);
        // 右边快速排序
        quickSort(num, r + 1, right);
    }
}
