package com.mao.剑指offer53II0到n减1中缺失的数字;

import java.util.HashMap;

/**
 * Author: Administrator
 * Date: 2021/6/19 23:33
 * Description: 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
 * 请找出这个数字。  来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
//    /**
//     * 自己想的
//     * 就是循环遍历前一个数字与后一个数字之间的差值应该 == 1
//     * 一定不能用这种方法，时间太长了
//     * @param nums
//     * @return
//     */
//    public int missingNumber(int[] nums) {
//        int i = 0;
//        while (i < nums.length-1){
//            if(nums[i+1] - nums[i] > 1){
//                i = nums[i] + 1;
//            }
//        }
//        return i;
//    }
//    /**
//     * 网上的方法太妙了，直接让 nums[i] != i
//     * 一定不能用这种方法，时间太长了
//     * @param nums
//     * @return
//     */
//    public int missingNumber(int[] nums) {
//        if(nums[0] == 1) return 0;
//        int i = 0;
//        while (i < nums.length){
//            if(nums[i] != i){
//                break;
//            }
//            i++;
//        }
//        return i;
//    }
    /**
     * 借鉴与 k神的方法
     * 使用二分法进行查找
     * 每次查找中间的那个数，如果值 == 下标则丢失的数字应该在右边，否则就在左边
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j){
            int mid = (i + j) / 2;
            if(nums[mid] == mid) i = mid + 1;
            else j = mid - 1;
        }
        return i;
    }
}
