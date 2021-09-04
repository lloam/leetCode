package com.mao.剑指offer40最小的k个数;

import java.util.*;

/**
 * Author: Administrator
 * Date: 2021/6/5 22:28
 * Description: 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 考察的主要是快速排序，有两种，一种是大顶堆，还有一种就是快速排序，千万不要直接排序，太拉垮了
 */
public class Solution {
//     public int[] getLeastNumbers(int[] arr,int k){
//         int[] res = new int[k];
//         // 先排除 k 为 0 的情况
//         if(k == 0){
//             return res;
//         }
//         // 建立一个优先队列，先将前 k 个的数放进来形成大顶堆
//         PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//             @Override
//             public int compare(Integer o1, Integer o2) {
//                 return o2 - o1;
//             }
//         });
//         for(int i = 0; i < k; i++){
//             queue.offer(arr[i]);
//         }
//         // 再一次遍历剩下的元素，如果有比大顶堆的根小的数就替换之
//         for(int i = k; i < arr.length; i++){
//             if(queue.peek() > arr[i]){
//                 queue.poll();
//                 queue.offer(arr[i]);
//             }
//         }
//         // 将大顶堆中的数据遍历出来
//         for (int i = 0; i < k; i++) {
//             res[i] = queue.poll();
//         }
//         return res;
//     }

//    /*******************************快速排序**********************************/
//    public int[] getLeastNumbers(int[] arr,int k){
//        // 快速排序，将数组前k个小的数移到前面
//        randomizedSelected(arr,0,arr.length-1,k);
//        int[] vec = new int[k];
//        for (int i = 0; i < k; i++) {
//            vec[i] = arr[i];
//        }
//        return vec;
//    }
//
//    /**
//     * 找出前 k 个小的数
//     * @param arr
//     * @param start
//     * @param end
//     * @param k
//     */
//    private void randomizedSelected(int[] arr, int start, int end, int k) {
//        // 此时数组为空
//        if(start >= end){
//            return;
//        }
//        // 随机取出一个数，将比这个数更小的数排到前面，更大的数排到后面
//        int pos = randomizedPartition(arr,start,end);
//        int num = pos - start + 1;
//        // 判断这个位置的元素是否是第 k 个
//        // 如果是第 k 个，直接返回
//        if(num == k){
//            return;
//        }else if (k < num){
//            randomizedSelected(arr,start,pos - 1,k);
//        }else {
//            randomizedSelected(arr,pos + 1,end,k - num);
//        }
//    }
//
//    /**
//     * 随机划分
//     * @param nums
//     * @param start
//     * @param end
//     * @return
//     */
//    private int randomizedPartition(int[] nums, int start, int end) {
//        // 随机取出一个数，将比这个数更小的数排到前面，更到的数排到后面
//        int i = new Random().nextInt(end - start + 1) + start;
//        // 先将这个目标数字交换到最后一个
//        swap(nums,i,end);
//        // 得到比目标数字小的前面的数字，返回下标
//        return partition(nums,start,end);
//    }
//
//    /**
//     * 返回比目标数字更小的数字的个数
//     * @param nums
//     * @param start
//     * @param end
//     * @return
//     */
//    private int partition(int[] nums, int start, int end) {
//        // 将目标数字保存下来,此时最后一个数字就是目标数字
//        int pivot = nums[end];
//        int i = start - 1;
//        // 开始遍历数组，将比目标数字小的数进行交换
//        for(int j = start; j < end; j++){
//            // 如果小，就将此位置数字与 i 位置数字交换
//            if(nums[j] <= pivot){
//                // 一开始 i 是比最小下标还小的
//                i = i + 1;
//                swap(nums,j,i);
//            }
//        }
//        /**
//         * 遍历完成，第 i + 1 位数字前的数字都不目标数字pivot 小，
//         *          直接将pivot赋值给i+ 1下标元素，保证前面数字都比目标数字小，
//         *          后面数字都比目标数字大
//         */
//        swap(nums,i + 1,end);
//        return i + 1;
//    }
//
//    /**
//     * 交换两个位置的数字
//     * @param nums
//     * @param i
//     * @param j
//     */
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

//    /**
//     * 使用小根堆
//     * @param arr
//     * @param k
//     * @return
//     */
//    public int[] getLeastNumbers(int[] arr,int k) {
//
//        int[] res = new int[k];
//
//        if (k == 0) {
//            return res;
//        }
//
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1,o2)->{
//            return o2-o1;
//        });
//
//        for (int i = 0; i < k; i++) {
//            priorityQueue.offer(arr[i]);
//        }
//
//        for (int i = k; i < arr.length; i++) {
//            if (priorityQueue.peek() > arr[i]) {
//                priorityQueue.poll();
//                priorityQueue.offer(arr[i]);
//            }
//        }
//
//        for (int i = 0; i < res.length; i++) {
//            res[i] = priorityQueue.poll();
//        }
//        return res;
//    }

    int k;

    /**
     * 快速排序
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr,int k) {

        if (k >= arr.length) return arr;
        this.k = k;

        // 经过快速排序之后，前 k 个数就是最小的数
        return quickSort(arr, 0, arr.length-1);
    }

    /**
     * 快速排序
     * 寻找出前 k 小的数放到数组的最前面
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int[] quickSort(int[] arr, int left, int right) {

        int l = left;
        int r = right;
        while (l < r) {

            while (l < r && arr[r] >= arr[left]) r--;
            while (l < r && arr[l] <= arr[left]) l++;

            // 交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        // 循环结束
        int temp = arr[l];
        arr[l] = arr[left];
        arr[left] = temp;

        if (l > k) return quickSort(arr, left, l - 1);
        if (l < k) return quickSort(arr, l + 1, right);

        // 当 l == k 时，可以返回了
        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,1};
        int[] leastNumbers = new Solution().getLeastNumbers(arr, 1);

        System.out.println(Arrays.toString(leastNumbers));
    }


}
