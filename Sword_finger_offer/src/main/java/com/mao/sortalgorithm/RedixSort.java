package com.mao.sortalgorithm;

import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/27 15:16
 * Description: 基数排序
 */
public class RedixSort {

    public static void main(String args[]) {

        int[] num = new int[]{24, 74, 3, 34, 14, 4, 34, 3434, 24, 3435, 324, 544, 234, 124};
        System.out.println(Arrays.toString(num));
        // 临时存储合并之后的数组
        int[] temp = new int[num.length];
        redixSort(num);
        System.out.println(Arrays.toString(num));
    }

    /**
     * 基数排序
     * @param num
     */
    public static void redixSort(int[] num) {
        // 创建 10 个桶
        int[][] bucket = new int[10][num.length];
        // 存储每个桶的元素个数
        int[] bucketElementCounts = new int[10];
        // 找出最大值，确定排序次数
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            if (max < num[i]) max = num[i];
        }
        // 确定排序次数
        int maxCount = (max + "").length();
        // 排序
        for (int i = 0; i < maxCount; i++) {
            
        }
    }
}
