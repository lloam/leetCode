package com.mao.剑指offer53I在排序数组中查找数字I;

/**
 * Author: Administrator
 * Date: 2021/6/21 22:29
 * Description: 统计一个数字在排序数组中出现的次数。
 */
public class Solution {
    public static int search(int[] nums,int target){
        if(nums.length == 0) return 0;
        // 先使用二分法找出目标值下标
        int start = 0,end = nums.length-1;
        int mid = 0;
        while (start <= end){
            mid = (start + end) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }else if (nums[mid] > target){
                end = mid - 1;
            }else {
                break;
            }
        }
        System.out.println(mid + "=>" + nums[mid]);
        // 找到目标值，下标为 mid
        // 如果 mid 的值不是target，直接返回 0
        if(nums[mid] != target){
            return 0;
        }
        int i = mid - 1,j = mid + 1;
        // 双指针分别向前遍历相等的目标值
        int count1 = 0,count2 = 0;
        while (i >= 0){
            if(nums[i] != target){
                break;
            }
            i--;
            count1++;
        }
        System.out.println("count1=>" +count1);
        while (j <= nums.length-1){
            if(nums[j] != target){
                break;
            }
            j++;
            count2++;
        }
        System.out.println("count2=>" +count2);
        return count1+count2+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,4};
        System.out.println(search(nums, 4));
    }
}
