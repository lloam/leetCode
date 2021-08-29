package com.mao.sortalgorithm;

import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/27 11:44
 * Description: 冒泡排序
 */
public class BubbleSort {

    public static void main(String args[]) {

        int[] num = new int[]{32,1,4,0,43,-12,324,65,98};
        System.out.println(Arrays.toString(num));
        bubbleSort(num);
        System.out.println(Arrays.toString(num));
    }


    /**
     * 冒泡排序算法
     * @param num
     */
    public static void bubbleSort(int[] num) {

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }

    }
}
