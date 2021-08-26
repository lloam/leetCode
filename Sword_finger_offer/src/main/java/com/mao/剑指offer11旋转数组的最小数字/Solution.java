package com.mao.剑指offer11旋转数组的最小数字;

import java.util.ArrayList;

/**
 * Author: Administrator
 * Date: 2021/6/23 22:43
 * Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
 * 该数组的最小值为1。 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
//    /**
//     * 遇到顺序数组一般都是用二分法进行解决，具体细节看题解，太多了
//     * @param numbers
//     * @return
//     */
//    public int minArray(int[] numbers) {
//        int i = 0,j = numbers.length - 1,mid;
//        while (i < j){
//            mid = (i + j) / 2;
//            // i <= m < j
//            if(numbers[mid] > numbers[j]){
//                // mid 一定在左顺排序数组中
//                i = mid + 1;
//            }else if(numbers[mid] < numbers[j]){
//                // mid 一定在右排序数组中，这里不 + 1 是因为mid可能就是那个旋转中心点
//                j = mid;
//            }else {
////                // mid 无法判断在哪边，但是 i ~ m 之间的元素是相等的
////                int x = i;
////                for (int k = i; k < j; k++){
////                    if(numbers[k] < numbers[x]) x = k;
////                }
////                return numbers[x];
//                j--;
//            }
//        }
//        return numbers[i];
//    }


//    /**
//     * 第一种
//     * 遍历数组
//     * 遇到数字比前一个数字小的数就是要求的值
//     * 遍历完没有返回说明没有反转
//     * 直接返回第一个数字
//     * @param numbers
//     * @return
//     */
//    public int minArray(int[] numbers) {
//
//        for (int i = 1; i < numbers.length; i++) {
//
//            if (numbers[i] < numbers[i-1]) {
//                return numbers[i];
//            }
//
//        }
//
//        return numbers[0];
//
//    }



    public int minArray(int[] numbers) {

        int i = 0, j = numbers.length - 1, mid;

        while (i < j) {

            mid = (i + j) / 2;

            if (numbers[j] < numbers[mid]) {
                // mid 在左排序数组中
                i = mid + 1;
            }else if (numbers[j] > numbers[mid]) {
                // mid 在右排序数组中
                j = mid;
            }else {
                // 二者相等说明有相等的元素
//                j--;
                int x = i;
                for (int k = i; k < j; k++) {
                    if (numbers[k] < numbers[x]) x = k;
                }

                return numbers[x];
            }
        }

        return numbers[i];
    }

}
