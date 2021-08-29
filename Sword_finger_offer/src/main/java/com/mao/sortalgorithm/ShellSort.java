package com.mao.sortalgorithm;

import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/27 12:07
 * Description: 希尔排序
 */
public class ShellSort {

    public static void main(String args[]) {

        int[] num = new int[]{32,1,4,0,43,-12,324,65,98};
        System.out.println(Arrays.toString(num));
        shellSort(num);
        System.out.println(Arrays.toString(num));
    }


    /**
     * 希尔排序
     * @param num
     */
    public static void shellSort(int[] num) {
        int insertIndex, insertValue;
        for (int gap = num.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < num.length; i++) {
                insertIndex = i;
                insertValue = num[i];
                while (insertIndex >= gap && num[insertIndex - gap] > insertValue) {
                    num[insertIndex] = num[insertIndex - gap];
                    insertIndex -= gap;
                }
                num[insertIndex] = insertValue;
            }
        }
    }
}
