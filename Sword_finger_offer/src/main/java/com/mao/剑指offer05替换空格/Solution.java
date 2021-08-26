package com.mao.剑指offer05替换空格;

/**
 * Author: Administrator
 * Date: 2021/6/4 22:33
 * Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Solution {

//    public String replaceSpace(String s) {
////        return s.replaceAll(" ","%20");
//        int length = s.length();
//        // 用于字符串转化为字符，长度为字符串的3倍
//        char[] chars = new char[length*3];
//        int size = 0;// 遍历字符串的下标
//        for(int i = 0; i < length; i++){
//            // 获得字符串的第 i 个位置的字符
//            char c = s.charAt(i);
//            // 如果字符为 ' '，就替换
//            if(c == ' '){
//                chars[size++] = '%';
//                chars[size++] = '2';
//                chars[size++] = '0';
//            }else {
//                chars[size++] = c;
//            }
//        }
//        return new String(chars,0,size);
//    }

    /**
     * replaceAll 虽然可以但是不能用
     * 时间复杂度不行
     * 使用字符替换
     * @param s
     * @return
     */
    public String replaceSpace(String s) {

        // 获取字符串长度
        int length = s.length();

        // 用于存储改变后的字符串的字符，因为空格变成 '%20' 长度变为 3
        // 所以极端情况下全为空格，所以长度为 3 倍
        char[] chars = new char[length*3];

        int size = 0;

        for (int i = 0; i < length; i++) {

            // 获取对应位置字符
            char c = s.charAt(i);

            if (c == ' ') {

                // 如果字符为空，就替换
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';

            }else {
                // 不是空字符就直接添加
                chars[size++] = c;
            }
        }

        return new String(chars,0,size);
    }
}
