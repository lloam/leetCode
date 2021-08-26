package com.mao.面试题01_06字符串压缩;

/**
 * Author: 但愿人长久
 * Date: 2021/8/7 22:49
 * Description: 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 自己的想法
     * 维护一个结果字符数组用于存储压缩后的字符
     * count    存储字符的个数
     * tem      存储当前遍历的字符
     * @param S
     * @return
     */
    public String compressString(String S) {

        // 如果字符串长度为 0
        if (S.length() == 0) return "";

        // 用于存储当前相等字符的个数
        int count = 1;

        // 用于存储当前遍历的字符
        char tem = S.charAt(0);

        // 用于存储返回结果
        StringBuilder res = new StringBuilder();

        // 遍历字符
        for (int i = 1; i < S.length(); i++) {

            // 如果当前遍历的字符是一样的
            if (S.charAt(i) == tem) {

                // 字符个数 ++
                count++;
            }else {

                // 当前遍历的字符不是一样的，添加字符到字符串
                res.append(tem);

                // 字符个数
                res.append(count);

                // 重新设置字符与字符个数
                tem = S.charAt(i);
                count = 1;
            }
        }

        // 由于最后一次不能添加字符，所以要在外面再次添加
        res.append(tem);
        res.append(count);

        // 获取结果字符串的长度
        int resLength = res.length();

        return resLength < S.length() ? res.toString() : S;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String string = solution.compressString("aabcccccaa");

        System.out.println(string);
    }

}
