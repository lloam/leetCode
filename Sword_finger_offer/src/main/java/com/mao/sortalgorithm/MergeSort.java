package com.mao.sortalgorithm;

import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/27 14:43
 * Description: 归并排序
 */
public class MergeSort {

    public static void main(String args[]) {

        int[] num = new int[]{24, 74, 3, 34, 14, 4, 34, 3434, 24, 3435, 324, 544, 234, 124};
        System.out.println(Arrays.toString(num));
        // 临时存储合并之后的数组
        int[] temp = new int[num.length];
        mergeSort(num, 0, num.length - 1, temp);
        System.out.println(Arrays.toString(num));
    }

    /**
     *
     * @param num
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] num, int left, int right, int[] temp) {
        if (left < right) {
            // 分
            int mid = (left + right) / 2;
            // 将左边部分继续分
            mergeSort(num, left, mid, temp);
            // 将右边部分继续分
            mergeSort(num, mid + 1, right, temp);
            // 合
            merge(num, left, mid, right, temp);
        }
    }

    /**
     * 合并方法
     * @param num
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void merge(int[] num, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        // 临时存储合并之后的数组的下标
        int t = 0;
        while (i <= mid && j <= right) {
            if (num[i] < num[j]) {
                temp[t] = num[i];
                i++;
                t++;
            }else {
                temp[t] = num[j];
                j++;
                t++;
            }
        }

        // 合并可能剩下的数组元素
        while (j <= right) {
            temp[t] = num[j];
            t++;
            j++;
        }
        while (i <= mid) {
            temp[t] = num[i];
            t++;
            i++;
        }
        // 将临时存储的数组合并到原数组当中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            num[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
