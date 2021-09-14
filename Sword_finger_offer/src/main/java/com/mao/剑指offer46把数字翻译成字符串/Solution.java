package com.mao.剑指offer46把数字翻译成字符串;

/**
 * Author: Administrator
 * Date: 2021/7/10 11:59
 * Description: 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * X1X2X3......Xi-2Xi-1Xi...Xn
//     * 如果要求第 i 个数字以前的翻译方法的话，假设第 i 个为 dp[i]，就要看 i-1 与 i 能不能一起翻译，
//     * 如果可以，则 dp[i] = dp[i-2] + dp[i-1]
//     * 如果不可以，只能单独翻译，则 dp[i] = dp[i-1]
//     * @param num
//     * @return
//     */
//    public int translateNum(int num) {
//        // 先将 num 转换成字符串
//        String str = String.valueOf(num);
//        int a = 1, b = 1;
//        for (int i = 2; i <= str.length(); i++) {
//            // 如果  10 <= Xi-1Xi <= 25，则 Xi-1Xi 能一起翻译
////            if(str.substring(i-2,i).compareTo("10") >= 0 && str.substring(i-2,i).compareTo("25") <= 0) {
////                int c = a + b;
////                b = a;
////                a = c;
////            }else {
////                int c = a;
////                b = a;
////                a = c;
////            }
//            String temp = str.substring(i-2,i);
//            int c = (temp.compareTo("10") >= 0 && temp.compareTo("25") <=0) ? a + b : a;
//            b = a;
//            a = c;
//        }
//        return a;
//    }

    /**
     * 动态规划
     * 看最后两位数是否能一起翻译
     * @param num
     * @return
     */
    public int translateNum(int num) {

        // int a = 1, b = 1;
        // String str = String.valueOf(num);
//        for (int i = 2; i < str.length(); i++) {
//            // Xi-1Xi
//            String temp = str.substring(i-2, i);
//            int c = (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) ? a + b : a;
//            b = a;
//            a = c;
//
//        }
//        // 此题的动态规划计算是对称的
//        for (int i = str.length() - 2; i >= 0; i--) {
//            String temp = str.substring(i, i+2);
//            int c = (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) ? a + b : a;
//            b = a;
//            a = c;
//        }
        // 使用数字求余，省去字符串的空间
        int a = 1, b = 1, x, y = num % 10;
        while (num != 0) {
            num /= 10;
            x = num % 10;
            int temp = x * 10 + y;
            int c = (temp >= 10 && temp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = num % 10;
        }
        return a;

    }
}
