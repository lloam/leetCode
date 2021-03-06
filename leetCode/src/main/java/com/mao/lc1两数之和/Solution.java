package com.mao.lc1两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: lloam
 * Date: 2021/10/11 10:01
 * Description: 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。  你可以假设每种输入只会对应一个答案。但是，
 * 数组中同一个元素在答案里不能重复出现。  你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 双层 for 循环可以解决
     * 但时间复杂度高，可以先将数组元素存在 hash 表中
     * 省去一次 for 循环
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] res = new Solution().twoSum(new int[]{3, 3}, 6);
        System.out.println(Arrays.toString(res));
    }
}
