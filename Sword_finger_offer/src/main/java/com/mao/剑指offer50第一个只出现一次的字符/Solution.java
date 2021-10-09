package com.mao.剑指offer50第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Administrator
 * Date: 2021/7/3 17:21
 * Description: 在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Solution {


    /**
     * 首先将字符串转化成字符 toCharArray()
     * 然后再遍历字符数组，存在哈希表中，因为哈希表的作用是去重
     * 所以如果只有一个则让hash的 value 为 true
     * 如果多于一个则让 hash 的 value 为 false
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], !map.containsKey(chars[i]));
        }
        for (char aChar : chars) {
            if (map.get(aChar)) return aChar;
        }
        return ' ';
    }

    public static void main(String[] args) {
        char c = new Solution().firstUniqChar("leetcode");
        System.out.println(c);
    }
}
