package com.mao.lc42接雨水;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Author: lloam
 * Date: 2021/9/28 17:12
 * Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution {


//    /**
//     * 双层 for 循环
//     * @param height
//     * @return
//     */
//    public int trap(int[] height) {
//        int res = 0;
//        int left_max = 0, right_max = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            for (int j = i; j >= 0; j--) {
//                left_max = Math.max(left_max, height[j]);
//            }
//            for (int j = i; j < height.length; j++) {
//                right_max = Math.max(right_max, height[j]);
//            }
//            res += Math.min(left_max, right_max) - height[i];
//        }
//        return res;
//    }

//    /**
//     * 定义两个数组
//     * 一个记录当前位置下标左边的值
//     * 一个记录当前位置下标的右边的值
//     * 那么当前位置能接的雨水就是两者之差
//     * @param height
//     * @return
//     */
//    public int trap(int[] height) {
//        int length = height.length;
//        if (length == 0) return 0;
//        int[] left_max = new int[length];
//        left_max[0] = height[0];
//        for (int i = 1; i < length; i++) {
//            left_max[i] = Math.max(left_max[i - 1], height[i]);
//        }
//        int[] right_max = new int[length];
//        right_max[length - 1] = height[length - 1];
//        for (int i = length - 2; i >= 0; i--) {
//            right_max[i] = Math.max(right_max[i + 1], height[i]);
//        }
//        int res = 0;
//        for (int i = 0; i < length; i++) {
//            res += Math.min(left_max[i], right_max[i]) - height[i];
//        }
//        return res;
//    }

    /**
     * 单调栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();
                if (stack.isEmpty()) break;
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                res += currWidth * currHeight;
            }
            stack.push(i);
        }
        return res;
    }
}
