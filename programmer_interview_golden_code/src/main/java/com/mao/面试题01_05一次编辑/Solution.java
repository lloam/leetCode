package com.mao.面试题01_05一次编辑;

/**
 * Author: lloam
 * Date: 2021/9/1 23:19
 * Description: 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
public class Solution {

    /**
     * 首先排除不符合的情况
     * 然后遍历更短的字符串
     * 当遇到不相等的字符时
     * leetcode leetode
     * leetcode leetkode
     * 看长度是否相等
     * 相等，直接比较下一字符之后的所有
     * 不相等，比较 first 下一个字符和 second 当前字符之后的字符
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {

        if (first == null || second == null) return false;

        int len1 = first.length(), len2 = second.length();

        // 长度相差 2 直接返回 false
        if (Math.abs(len1-len2) > 1) return false;

        // 始终保持 first 的长度大于 second
        if (len1 < len2) return oneEditAway(second, first);

        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(i+1).equals(second.substring(len1 == len2 ? i+1 : i));
            }
        }

        return true;
    }
}
