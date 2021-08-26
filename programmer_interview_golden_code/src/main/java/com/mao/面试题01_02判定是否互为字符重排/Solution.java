package com.mao.面试题01_02判定是否互为字符重排;


import java.util.Arrays;

/**
 * Author: 但愿人长久
 * Date: 2021/8/7 20:30
 * Description: 给定两个字符串 s1 和 s2，请编写一个程序，
 * 确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class Solution {


//    /**
//     * 其实就是判断两个字符串的字符是否完全一样
//     * 思想：
//     * 将两个字符串的字符数组排序，然后变成字符串，看是否相等
//     * @param s1    字符串1
//     * @param s2    字符串2
//     * @return
//     */
//    public boolean CheckPermutation(String s1, String s2) {
//
//        // 得到 s1 的字符数组
//        char[] chars1 = s1.toCharArray();
//
//        // 得到 s2 的字符数组
//        char[] chars2 = s2.toCharArray();
//
//        // 对 s1 的字符数组排序
//        Arrays.sort(chars1);
//
//        // 对 s2 的字符数组排序
//        Arrays.sort(chars2);
//
//        // 判断两个排序组成的字符串是否相等
//        return new String(chars1).equals(new String(chars2));
//    }

    /**
     * 解法2：
     * 遍历两个字符串
     * 维护一个长度为 26 的 int 数组
     * 每次遍历得到相应的字符就在数组就 + 1
     * 然后遍历另一个字符串对应的字符 - 1
     * 遍历得到的字符 - 'a' 就是数组的下标
     * @param s1    字符串1
     * @param s2    字符串2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {

        // 如果两个字符串长度不相等直接返回 false
        if (s1.length() != s2.length()) return false;

        // 用于存储字符个数的数组
        int[] index = new int[26];

        // 获得对应的数组下标
        for (int i = 0; i < s1.length(); i++) {

            int i1 = s1.charAt(i) - 'a';
            int i2 = s2.charAt(i) - 'a';

            index[i1]++;
            index[i2]--;
        }

        // 遍历存储字符的数组，如果有元素不为 0，说明有字符不相等，返回 false
        for (int num : index) {
            if (num != 0) return false;
        }

        // 循环完成，返回 true
        return true;
    }
}
