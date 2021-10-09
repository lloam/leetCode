package com.mao.剑指offer48最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: Administrator
 * Date: 2021/7/24 23:39
 * Description: 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Solution {

//    /**
//     * 动态规划
//     * 看题解
//     * 思路：
//     * 从前往后看，设 dp[j] 是第 j 个字符往左数最长的不重复字符串的长度，此时再往左一格就有重复
//     * 索引为 i，如果这个 i 在前一个子字符串 dp[j-1] 的范围里面，说明此时 dp[j] = j - i
//     * 反之，如果这个 i 在前一个子字符串 dp[j-1] 的范围外面，也就是在子字符串左侧
//     * 说明此时子字符串 j-1 到 i 位置有重复元素，那么 dp[j] = dp[j-1] + 1
//     * @param s
//     * @return
//     */
//    public int lengthOfLongestSubstring(String s) {
//        Map<Character,Integer> dic = new HashMap<>();
//        int res = 0, temp = 0;
//
//        // 遍历字符串的字符
//            for (int j = 0; j < s.length(); j++) {
//            // 判断此时字典中是否包含该字符，包含就返回索引下标，不包含就返回 -1
//            Integer i = dic.getOrDefault(s.charAt(j), -1);
//
//            // 更新哈希表
//            dic.put(s.charAt(j), j);
//
//            // 判断 i 位于子字符串的位置
//            temp = temp < j - i ? temp + 1 : j - i;
//
//            // 比较此时最长的字符长度
//            res = Math.max(res, temp);
//        }
//            return res;
//    }


//    public int lengthOfLongestSubstring(String s) {
//        int res = 0, temp = 0;
//
//            for (int j = 0; j < s.length(); j++) {
//            int i = j - 1;
//            while (i >= 0 && s.charAt(i) != s.charAt(j)) i--;
//            temp = temp < j - i ? temp + 1 : j - i;
//            res = Math.max(res, temp);
//        }
//            return res;
//    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, i = -1;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) i = Math.max(i, map.get(s.charAt(j)));
            map.put(s.charAt(j), j);
            maxLength = Math.max(maxLength, j - i);
        }
        return maxLength;
    }
    //        Map<Character,Integer> dic = new HashMap<>();
//        int res = 0, i = -1;
//
//        for (int j = 0; j < s.length(); j++) {
//            if(dic.containsKey(s.charAt(j))) {
//                i = Math.max(i, dic.get(s.charAt(j)));
//            }
//            dic.put(s.charAt(j), j);
//            res = Math.max(res, j - i);
//        }
//        return res;
    public static void main(String[] args) {
        int maxLength = new Solution().lengthOfLongestSubstring(" ");
        System.out.println(maxLength);
    }

}
