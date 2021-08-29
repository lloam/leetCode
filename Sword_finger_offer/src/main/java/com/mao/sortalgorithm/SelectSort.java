package com.mao.sortalgorithm;

import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/27 11:49
 * Description: 选择排序
 */
public class SelectSort {

    public static void main(String args[]) {

        int[] num = new int[]{32,1,4,0,43,-12,324,65,98};
        System.out.println(Arrays.toString(num));
        selectSort(num);
        System.out.println(Arrays.toString(num));
    }

    /**
     * 选择排序算法
     * @param num
     */
    public static  void selectSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            int minIndex = i;
            int minValue = num[i];
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < minValue) {
                    minIndex = j;
                    minValue = num[j];
                }
            }
            if (minIndex != i) {
                num[minIndex] = num[i];
                num[i] = minValue;
            }
        }
    }
}
