package com.mao.面试题10_05稀疏数组搜索;

/**
 * Author: 但愿人长久
 * Date: 2021/8/26 11:47
 * Description: 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 */
public class Solution {

//    /**
//     * 因为字符串数组是有序的，所以可以用二分法进行查找
//     * @param words     字符串数组
//     * @param s         待找出的字符串
//     * @return
//     */
//    public int findString(String[] words, String s) {
//
//        // 排除数组为空和字符串为空的情况
//        if (words.length == 0 || s == null) return -1;
//
//        // 二分法双指针
//        int l = 0, f = words.length - 1, mid;
//
//        while (l <= f) {
//
//            // 中间点
//            mid = (l + f) / 2;
//
//            // 排除空字符串的情况
//            while (mid > l && words[mid].equals("")) mid--;
//
//            if (s.compareTo(words[mid]) == 0) return mid;
//            else if (s.compareTo(words[mid]) < 0) f = mid - 1;
//            else l = mid + 1;
//        }
//        return -1;
//    }

    /**
     *
     * 另一种方法
     * @param words
     * @param s
     * @return
     */
    public int findString(String[] words, String s) {

        int length = 0;

        if (words != null && (length = words.length) == 0) return -1;

        int index;
        if ((length & 1) == 1) {
            length = length - 1;
            if (s.equals(words[length])) {
                return length;
            }
        }

        index = length / 2;
        for (int i = 0; i < index; i++) {
            if (s.equals(words[i])) return i;

            if (s.equals(words[i+index])) return i+index;
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};

        System.out.println(new Solution().findString(words, "ball"));
    }

}
