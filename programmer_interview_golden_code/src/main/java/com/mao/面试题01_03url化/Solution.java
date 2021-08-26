package com.mao.面试题01_03url化;

/**
 * Author: 但愿人长久
 * Date: 2021/8/7 21:53
 * Description: URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 题目的意思是我们需要在一个字符数组上操作
     * 字符串的长度尾部有足够多的空间存放新增字符
     * 这也就意味着我们可以从后往前开始新增字符
     * 然后截取字符数组新建字符串就行了
     * @param S         需要变化的字符串
     * @param length    字符串的真是长度
     * @return
     */
    public String replaceSpaces(String S, int length) {

        // 获取字符串的字符数组
        char[] chars = S.toCharArray();

        // 得到字符数组长度，足够替换新增所有的空格
        int index = chars.length - 1;

        // 遍历字符数组，循环 length - 1 次，保证字符串真实字符被替换
        for (int i = length - 1; i >= 0; i--) {

            // 如果是空格就替换 20%
            if (chars[i] == ' ') {

                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            }else {
                // 不是空格就直接替换
                chars[index--] = chars[i];
            }
        }

        // 返回字符串，从 index + 1 下标开始，长度为 chars.length - index - 1
        return new String(chars, index+1, chars.length - index - 1);
    }
}
