package com.mao.剑指offer67把字符串转换成整数;

/**
 * Author: Administrator
 * Date: 2021/6/4 22:00
 * Description: 写一个函数 StrToInt，实现把字符串转换成整数这个功能。
 * 不能使用 atoi 或者其他类似的库函数
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int strToInt(String str){
        // 用于存储字符串去除空格后转化为字符
        char[] chars = str.trim().toCharArray();
        // 如果字符数组为0，直接返回0
        if(chars.length == 0) return 0;
        /**
         * sign:用户判断是正还是负数
         * i：用于判断起始位置
         */
        int sign = 1,i = 1;
        /**
         * res:结果
         * bndry：可能会越界，用来判断是否越界
         */
        int res = 0,bndry = Integer.MAX_VALUE / 10;
        if(chars[0] == '-'){
            sign = -1;
        }else if(chars[0] != '+') {
            // 如果是正数就要从0开始遍历
            i = 0;
        }
        for(int j = i; j < chars.length; j++){
            // 如果遇到不是数字的其他字符就直接退出for循环
            if(chars[j] < '0' || chars[j] > '9') break;
            // Integer.MIN_VALUE:2147483647
            // 如果结果res大于临界值，或者==临界值，最后一个字符大于'7'，就超过了Integer的最大值，就要返回别的
            if(res > bndry || res == bndry && chars[j] > '7') return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            // 结果就是每次循环的res * 10 ，然后字符转数字就是 此数字的ASCII码 - '0'的ASCII码，'0':48,'1':49
            res = res * 10 + (chars[j] - '0');
        }
        return res*sign;
    }
}
