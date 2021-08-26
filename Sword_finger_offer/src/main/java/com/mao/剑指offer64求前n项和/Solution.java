package com.mao.剑指offer64求前n项和;

/**
 * Author: Administrator
 * Date: 2021/7/18 23:19
 * Description: 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 */
public class Solution {

//    // 前 n 项和
//    int sum = 0;
    /**
     * 要求前 n 项和肯定会有循环
     * 有循环肯定会有结束条件
     * 不能有寻常的结束条件
     * 可以考虑使用 && 短路与        A && B
     * 如果第一个条件 A 不成立为 false，则不会在执行 B
     * 循环不能有 while 等循环，可以用递归代替
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean b = (n >= 1) && (n += sumNums(n-1)) > 0;
//        sum += n;
        // 如果放在这里递归没有结束条件导致栈溢出，可以放在上面的短路与最后，如果 n < 0，就不递归
//        sumNums(n);
        return n;
    }
}
