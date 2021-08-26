package com.mao.面试题01_09字符串轮转;

/**
 * Author: 但愿人长久
 * Date: 2021/8/9 21:22
 * Description: 字符串轮转。给定两个字符串s1和s2，
 * 请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 */
public class Solution {


    /**
     * 既然是旋转而成，那么 s1 + s1 肯定包含了 s2
     * @param s1    字符串 s1
     * @param s2    字符串 s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        s1 += s1;

        return s1.contains(s2);
    }
}
