package com.mao.lc384打乱数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author: lloam
 * Date: 2021/9/28 16:45
 * Description: 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * 实现 Solution class:  Solution(int[] nums) 使用整数数组 nums 初始化对象 int[] reset()
 * 重设数组到它的初始状态并返回 int[] shuffle() 返回数组随机打乱后的结果
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 洗牌算法：重置就是恢复原来的顺序
 * 打乱的话呢首先可以用暴力的算法每次获取随机值来遍历数组下标
 * 而洗牌算法就是每次遍历的时候，随机值是从当前下标到数组末尾的值，这样就能防止重复获取和省去一个额外的数组空间
 */
public class Solution {

//    /******************暴力解法*******************/
//    private int[] array;
//    // 存储初始状态的数组
//    private int[] original;
//    private Random rand = new Random();
//
//    // 用于打乱数组的时候先将数组存起来
//    private List<Integer> getArrayCopy() {
//        List<Integer> asList = new ArrayList<Integer>();
//        for (int i = 0; i < array.length; i++) {
//            asList.add(array[i]);
//        }
//        return asList;
//    }
//
//
//    /**
//     * 初始化
//     * @param nums
//     */
//    public Solution(int[] nums) {
//        array = nums;
//        original = nums.clone();
//    }
//
//    /** Resets the array to its original configuration and return it. */
//    public int[] reset() {
//        array = original;
//        original = original.clone();
//        return array;
//    }
//
//    /** Returns a random shuffling of the array. */
//    public int[] shuffle() {
//        List<Integer> asList = getArrayCopy();
//        for (int i = 0; i < array.length; i++) {
//            int removeIdx = rand.nextInt(asList.size());
//            array[i] = asList.get(removeIdx);
//            asList.remove(removeIdx);
//        }
//        return array;
//    }





    /******************洗牌算法*******************/
    private int[] array;
    // 存储初始状态的数组
    private int[] original;
    private Random rand = new Random();

    /**
     * 初始化
     * @param nums
     */
    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            // 获取当前下标之后的元素
            int nextIdx = rand.nextInt(array.length - i) + i;
            // 交换当前元素和获取之后的元素
            int temp = array[i];
            array[i] = array[nextIdx];
            array[nextIdx] = temp;
        }
        return array;
    }
}
