package com.mao.剑指offer57II和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/6/15 22:12
 * Description: 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。  来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 滑动窗口
     * 使用双指针的方法
     * 一个指向序列的第一个数
     * 另一个指向序列的最后一个数
     * 使用等差数列的求和方式求得i~j的总和sum
     * 如果sum==target，则返回，
     * 如果sum > target，则i向前移一位
     * 如果sum < target，则j向前移一位，
     * i和j指针只能向前移动
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        // 两个指针
        int i = 1,j = 1;
        // 记录序列的集合
        List<int[]> res = new ArrayList<>();
        // 总和
        int sum = 0;
        // i 最大为 target 的一半
        while (i <= target/2){
            sum = ((j - i + 1)*(i + j))/2;
            // 如果和就是target，则遍历赋值
            if(sum == target){
                int[] ints = new int[j - i + 1];
                for(int k = 0; k < j-i+1; k++){
                    ints[k] = k+i;
                }
                // 将序列加入到集合
                res.add(ints);
                // 加入完后，需要将 i 向右移一位
                i++;
            }else if(sum < target){
                // 如果和小于target，那么 j 就要向右移
                j++;
            }else if(sum > target){
                // 如果和大于target，那么 i 就要向右移
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(9);
        for (int[] ints : continuousSequence) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
