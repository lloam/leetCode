package com.mao.面试题16_07最大数值;

/**
 * Author: 但愿人长久
 * Date: 2021/8/29 14:16
 * Description: 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 */
public class Solution {

//    /**
//     * 使用位运算右移和异或
//     * @param a 比较数 a
//     * @param b 比较数 b
//     * @return
//     */
//    public int maximum(int a, int b) {
//
//        // 先考虑 a b 同号的情况
//        // 当 k = 1 时，说明 a - b < 0 ==> a < b
//        // 当 k = 0 时，说明 a - b > 0 ==> a > b
//        int k = (b - a) >>> 31;
//
//        // 再考虑 a，b 异号的情况
//        int aSign = a >>> 31;
//        int bSign = b >>> 31;
//
//        // 当 diff = 1 时，说明 a，b 异号
//        // 当 diff = 0 时，说明 a，b 同号
//        int diff = aSign ^ bSign;
//
//        // 如果 a，b 异号，之前所算的 k 无效，只需要看 sSign 的值
//        // 如果 bSign == 1，说明 b 是负数，a 是正数，结果就是 a
//        // 如果 bSign == 0，说明 b 是正数，a 是负数，结果就是 b
//        if (diff == 1) {
//            k = bSign;
//        }
//
//        return a * k + b * (k ^ 1);
//    }

//    /**
//     * 直接使用数学表达式
//     * @param a
//     * @param b
//     * @return
//     */
//    public int maximum(int a, int b) {
//        long c = a;
//        long d = b;
//        return (int) ((c + d + Math.abs(c - d))/2);
//    }

    /**
     * 两数相减
     * @param a
     * @param b
     * @return
     */
    public int maximum(int a, int b) {
        long x = (long) a - (long) b;
        int k = (int) (x >> 63);
        return (k + 1) * a - b * k;
    }


    public static void main(String[] args) {
        Integer aValue =-2;
        show(aValue);
        Integer leftMoveValue1 =aValue >>> 1; //无符号右边移1位
        show(leftMoveValue1);
        Integer leftMoveValue2 =aValue >>> 2; //无符号右移2位
        show(leftMoveValue2);
        Integer leftMoveValue3 =aValue >>> 3;//无符号右移3位
        show(leftMoveValue3);
    }
    /**
     * 打印数字对应的二进制字符串
     * @param number
     */
    public static void show(Integer number)
    {
        //打印原值
        System.out.println(number);
        System.out.println(Integer.toBinaryString(number));
    }
}
