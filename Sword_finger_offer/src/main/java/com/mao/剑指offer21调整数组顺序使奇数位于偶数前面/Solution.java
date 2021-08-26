package com.mao.剑指offer21调整数组顺序使奇数位于偶数前面;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author: Administrator
 * Date: 2021/6/17 22:33
 * Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Solution {
//    /**
//     * 我觉得这种将一个数组分成两类的就类似与快速排序
//     * 快速排序就是将小的数放到前面，大的数放到后面
//     * 和这个都差不多的意思，只不过快速排序是要递归遍历
//     * 而这种情况只需要遍历一遍就行了
//     * 也就是使用双指针的方法
//     * @param nums
//     * @return
//     */
//    public static int[] exchange(int[] nums) {
//        // 双指针，分别指向数组的第一个与最后一个
//        int i = 0,j = nums.length-1;
//        // 分别从前和后判断是否为奇数或者偶数来讲指针移动
//        // 结束条件就是 i = j
//        while (i < j){
//            // 如果是奇数，那就向后继续判断
//            while ((nums[i]&1) == 1 && i<j){
//                i++;
//            }
//            // 此时 i 位置的应该就是偶数了
//            while ((nums[j]&1) == 0 && i < j) {
//                // 如果是偶数，那就继续向前判断
//                j--;
//            }
//            // 此时 j 位置的应该就是奇数了，交换 i j 位置的数
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//        }
//        return nums;
//    }

//    /**
//     * 类似于快速排序的一步
//     * 使用双指针
//     * 一个用于辨别奇数
//     * 一个用于辨别偶数
//     * @param nums  输入的数组
//     * @return
//     */
//    public int[] exchange(int[] nums) {
//
//        // 双指针
//        int i = 0, j = nums.length - 1, temp;
//
//        while (i < j) {
//
//            while (i < j && (nums[i] & 1) == 1) {
//                // 如果是奇数 i 就 ++
//                i++;
//            }
//
//            while (i < j && (nums[j] & 1) != 1) {
//                // 如果是偶数 j 就 --
//                j--;
//            }
//
//            // 此时 i 下标的数是偶数，j 下标的数十奇数，交换两个数
//           temp = nums[i];
//           nums[i] = nums[j];
//           nums[j] = temp;
//        }
//
//        return nums;
//    }

    /**
     * 使用快慢指针
     * 快指针 fast 向前移动，当遇到奇数时停下来，交换慢指针 low 位置的元素
     * low 指针就是下一个奇数的位置
     * @param nums  输入的数组
     * @return
     */
    public int[] exchange(int[] nums) {

        // 快慢指针
        int low = 0, fast = 0, temp;

        // 循环
        while (fast < nums.length) {

            if ((nums[fast] & 1) == 0) {
                // 快指针位置是偶数，指针向前移动
                fast++;
            }else {
                // 快指针位置是奇数，交换快慢指针位置元素
                temp = nums[low];
                nums[low] = nums[fast];
                nums[fast] = temp;

                // 两个指针都需要向前移动
                fast++;
                low++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        boolean isOk = 1 > 2;
        try {
            assert isOk : "测试程序错误";
            System.out.println("程序正常");
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
    }
}
