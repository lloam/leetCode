package com.mao.剑指offer44数字序列中某一位的数字;

/**
 * Author: Administrator
 * Date: 2021/7/6 21:13
 * Description: 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 其实就是找规律
     * 具体看 k 神
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9;
        // 找到 n 所在数字的位数
        while (n > 9) {
            n -= count;
            start = start * 10;
            digit++;
            count = 9 * digit * start;
        }
        // 找到 n 所在的数字
        long num = start + (n - 1) / digit;
        // 确定 n 是所在数字的第几位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
