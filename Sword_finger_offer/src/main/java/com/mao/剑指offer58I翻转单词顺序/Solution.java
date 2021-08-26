package com.mao.剑指offer58I翻转单词顺序;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: Administrator
 * Date: 2021/7/3 17:31
 * Description: 输入一个英文句子，翻转句子中单词的顺序，
 * 但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 双指针 i,j
     * j 用来定位每个单词的最后面一个字母的位置
     * i 用来向前遍历，当遇到 ' ' 时，就将 (i+1,j+1) 之间的单词加入到 StringBuffer 里面
     * 遍历栈
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            // 没有遇到 ' ' 向前遍历
            if(s.charAt(i) != ' ') i--;
            // 遇到之后，截取字符串
            res.append(s.substring(i+1,j+1) + " ");
            // 继续去掉中间的空字符串
            i--;
            if(i>= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString();
    }
}
