package com.mao.sortalgorithm;

import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/27 11:57
 * Description: 插入排序
 */
public class InsertSort {

    public static void main(String args[]) {

        int[] num = new int[]{32,1,4,0,43,-12,324,65,98};
        System.out.println(Arrays.toString(num));
        insertSort(num);
        System.out.println(Arrays.toString(num));
    }

    /**
     * 插入排序
     * @param num
     */
    public static void insertSort(int[] num) {
        int insertIndex, insertValue;
        for (int i = 1; i < num.length; i++) {
            insertIndex = i;
            insertValue = num[i];
            while (insertIndex > 0 && num[insertIndex - 1] > insertValue) {
                num[insertIndex] = num[insertIndex - 1];
                insertIndex--;
            }
            num[insertIndex] = insertValue;
        }
    }
}
