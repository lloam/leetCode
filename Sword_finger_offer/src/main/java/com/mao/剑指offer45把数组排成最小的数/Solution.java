package com.mao.剑指offer45把数组排成最小的数;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author: Administrator
 * Date: 2021/7/10 10:12
 * Description: 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class Solution {

//    /**
//     * 比较两个组合数调番顺序哪个更大，更小的顺序就是我们要求的顺序
//     * 如何比较，其实可以通过 compareTo() 方法
//     * 具体还有通过快排
//     * @param nums
//     * @return
//     */
//    public static String minNumber(int[] nums) {
//        // 要先将 nums 转换成字符串数组才能进行遍历
//        String[] str = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            str[i] = String.valueOf(nums[i]);
//        }
//        // 双指针用于快速排序
//        quickSort(str,0,str.length-1);
//        // 排序完之后就可以将数组转换成字符串了
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int k = 0; k < str.length; k++) {
//            stringBuilder.append(str[k]);
//        }
//        return stringBuilder.toString();
//    }
//
//    /**
//     * 快速排序
//     * @param str
//     * @param start
//     * @param end
//     */
//    private static void quickSort(String[] str, int start, int end) {
//        if (start >= end) return;
//        int i = start, j = end;
//        String temp = str[i];
//        while (i < j) {
//            while ((str[start] + str[j]).compareTo(str[j] + str[start]) <= 0 && i < j) j--;
//            while ((str[start] + str[i]).compareTo(str[i] + str[start]) >= 0 && i < j) i++;
//            // 交换两个不符合条件的元素
//            temp = str[i];
//            str[i] = str[j];
//            str[j] = temp;
//        }
//        str[i] = str[start];
//        str[start] = temp;
//        quickSort(str,start,i-1);
//        quickSort(str,i+1,end);
//    }

    public static String minNumber(int[] nums) {
        // 使用小根堆
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for (int num : nums) {
            queue.add("" + num);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            stringBuilder.append(queue.poll());
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(minNumber(nums));
    }
}
