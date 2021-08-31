package com.mao.sortalgorithm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/30 23:20
 * Description: 堆排序
 */
public class HeapSort {

    public static void main(String args[]) {

        int[] num = new int[]{9, 45234 ,342, 6, 8, 7, 45, 1, 0, 4, 2,32423,22,13, -2};
        System.out.println(Arrays.toString(num));
        heapSort(num);
        System.out.println(Arrays.toString(num));
    }


    /**
     * 堆排序
     * @param num
     */
    public static void heapSort(int[] num) {

        // 堆排序的起始下标，也就是最后一个叶子结点的父节点的下标
        int start = (num.length - 2) / 2;

        // 将数组调整为大顶堆
        for (int i = start; i >= 0; i--) {
            maxHeap(num, num.length, i);
        }

        for (int i = num.length - 1; i > 0; i--) {
            // 交换大顶堆第一个元素的位置和数组最后一个元素
            int temp = num[i];
            num[i] = num[0];
            num[0] = temp;
            // 交换完之后，再次将剩下的元素调整为大顶堆
            maxHeap(num, i, 0);
        }
    }


    /**
     * 将数组调整为大顶堆
     * @param num       数组
     * @param size      数组中需要调整的大顶堆的数组长度，依次减小
     * @param index     需要调整为大顶堆的根节点的数组下标
     */
    public static void maxHeap(int[] num, int size, int index) {

        // 获取当前需要调整为大顶堆节点的左右子节点的下标
        int leftNodeIndex = 2 * index + 1;
        int rightNodeIndex = 2 * index + 2;

        // 调整大顶堆（即根节点，左右子节点中最大的数调整为根节点
        int max = index;
        if (leftNodeIndex < size && num[max] < num[leftNodeIndex]) {
            // 左节点是更大的元素
            max = leftNodeIndex;
        }

        if (rightNodeIndex < size && num[max] < num[rightNodeIndex]) {
            // 右节点是更大的元素
            max = rightNodeIndex;
        }

        // 此时最大的值位于 max 下标，只需要将 max 下标的元素值与 index 下标的元素值替换即可
        if (max != index) {
            int temp = num[max];
            num[max] = num[index];
            num[index] = temp;
            // 调整之后可能 max 节点下方的左右子节点的大顶堆会被打乱，所以要重新调整
            maxHeap(num, size, max);
        }
    }
}
