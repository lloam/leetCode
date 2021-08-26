package com.mao.面试题01_01判定字符是否唯一;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: 但愿人长久
 * Date: 2021/8/6 23:31
 * Description: 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */
public class Solution {

//    /**
//     * 自己的想法就是使用 set 集合的不可重复
//     * @param astr
//     * @return
//     */
//    public boolean isUnique(String astr) {
//
//        // 用于存储遍历出来的字符
//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < astr.length(); i++) {
//
//            // 如果已经存在这个字符就返回 false
//            if (set.contains(astr.charAt(i))) return false;
//
//            // 否则就添加这个字符到 set 集合
//            set.add(astr.charAt(i));
//        }
//
//        // 遍历完成没有返回，说明全都不同，返回 true
//        return true;
//    }

    /**
     * 尝试不用额外的数据结构解题
     * 使用位运算解题
     * 维护一个长度为 26 的 bool 二进制数组 00000000...0000
     * 遍历字符串，得到字符，减去 'a' 的 ASCII 码得到该字符的偏移量，最多偏移 26 位
     * 再与二进制数组相与，若结果为 0，说明没有相同的，
     * 若结果不为 0，说明有相同的字符，因为每个偏移量都是不同的
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {

        int bool = 0;

        for (int i = 0; i < astr.length(); i++) {

            // 得到该位置字符 c
            char c = astr.charAt(i);

            // 获取字符偏移量
            int cc = c - 'a';

            // 得到偏移后的值，即 1 左移 cc 位，这个偏移值每一个字符都是不同的
            int bb = 1 << cc;

            // 将字符偏移值与 bool 相与，如果结果不为 0，说明之前有过这个字符
            if ((bool & bb) != 0) return false;

            // 将这个字符的偏移值存储到 bool 中
            bool |= bb;
        }

        // 遍历完成没有返回，说明没有相同的返回 true
        return true;
    }
}
