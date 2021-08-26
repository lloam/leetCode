package com.mao.面试题05_07配对交换;

/**
 * Author: 但愿人长久
 * Date: 2021/8/25 11:45
 * Description: 配对交换。编写程序，交换某个整数的奇数位和偶数位，
 * 尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 */
public class Solution {


    /**
     * 先得到这个数的奇数位与偶数位
     * 奇数位左移，偶数位右移
     * 然后异或
     * @param num
     * @return
     */
    public int exchangeBits(int num) {

        // 得到奇数位
        int odd = num & 0x55555555;

        // 得到偶数位
        int even = num & 0xaaaaaaaa;

        // 奇数位左移
        odd <<= 1;

        // 偶数位右移
        even >>= 1;

        // 两者异或返回结果
        return odd ^ even;
    }
}
