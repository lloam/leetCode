package com.mao.面试题01_04回文排列;

import java.util.*;

/**
 * Author: 但愿人长久
 * Date: 2021/8/8 23:11
 * Description: 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。  回文串不一定是字典当中的单词。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 个人想法
//     * 首先要是某个回文串的排列之一就代表字符串的字符
//     * 必须成对出现或者只能有一个奇数个的字符
//     * 例如：abccba、abcecba
//     * 而 abcefcba 就不是
//     * @param s
//     * @return
//     */
//    public boolean canPermutePalindrome(String s) {
//
//        // 使用 int 数组存储的话不知道字符个数是多少个、因此使用集合 map 存储：key 是各个字符相对于 'a' 的偏移量，value 是各个字符的个数
//        Map<Character,Integer> map = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//
//            // 获取字符
//            char c = s.charAt(i);
//
//            // 获取 map 集合中该字符的个数
//            Integer count = map.getOrDefault(c, 0);
//
//            // 如果个数不为 0，说明前面有该字符，个数 value ++
//            if (count != 0) {
//                map.put(c, ++count);
//            }else {
//                // 没有就直接设置为 1
//                map.put(c, 1);
//            }
//        }
//
//        // 遍历 map 集合
//        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
//
//        // 判断字符个数为奇数个的字符数量
//        int res = 0;
//
//        for (Map.Entry<Character, Integer> entry : entries) {
//            if ((entry.getValue() & 1) != 0) {
//                // 如果字符个数是奇数个
//                res++;
//            }
//        }
//
//        // 奇数个的字符必须小于等于 1
//        return res <= 1;
//    }

    /**
     * 题解：思想都是一样的
     * 1、也是使用哈希表
     * 1 ms, 在所有 Java 提交中击败了 64.88%的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了74.40%的用户
     * 2、使用位运算
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了87.05%的用户
     * 3、使用数组
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了52.41%的用户
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        /******************** 1、也是使用哈希表 ********************/
//        Set<Character> set = new HashSet<>();
//
//        int count = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//
//            char c = s.charAt(i);
//
//            if (!set.add(c)) {
//                // 添加 c 不成功，说明已经存在这个字符了，再删除这个字符
//                set.remove(c);
//            }
//        }
//
//        return set.size() <= 1;


        /******************** 2、使用位运算 ********************/
        long highBitMap = 0l, lowBitMap = 0l;

        for (char c : s.toCharArray()) {

            if (c >= 64) {
                highBitMap ^= 1l << (c - 64);
            }else {
                lowBitMap ^= 1l << c;
            }
        }

        return Long.bitCount(highBitMap) + Long.bitCount(lowBitMap) <= 1;


        /******************** 3、使用数组 ********************/
//        int[] map = new int[128];
//
//        // 用于记录字符个数是奇数的字符数量
//        int count = 0;
//
//        for (char c : s.toCharArray()) {
//
//            if ((map[c]++ & 1) == 1 ) {
//
//                // 如果当前遍历的字符个数是奇数个，也就是加上当前遍历的字符个数是偶数个，count--，表示消去一个奇数个的字符
//                count--;
//            }else {
//                // 当前遍历的字符个数是奇数
//                count++;
//            }
//        }
//        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPermutePalindrome("tactocoa"));
    }
}

