package com.mao.剑指offer17打印从1到最大的n位数;

/**
 * Author: Administrator
 * Date: 2021/6/2 22:38
 * Description: 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Solution {
    public static void main(String[] args) {

    }
//    int[] res;
//    /**
//     * nine 用来记录我的字符串已经加到个位数，还是十分位，还是百分位
//     * count 用来记录数组的下标
//     * start 用来记录需要截取的前面的 0 的个数
//     */
//    int nine = 0,count = 0,start,n;
//    // 用来存储每次写出去的字符穿=串
//    char[] num,loop = {'0','1','2','3','4','5','6','7','8','9'};
//    public int[] printNumbers(int n) {
//        this.n = n;
//        start = n - 1;
//        res = new int[(int) Math.pow(10,n)-1];
//        num = new char[n];
//        dfs(0);
//        return res;
//    }
//
//    void dfs(int x) {
//        if(x == n){
//            // 截取掉字符串的前面的 0
//            String s = String.valueOf(num).substring(start);
//            // 如果不是 0 ，就添加到数组里面，目的是为了第一个数字不是 0
//            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
//            // 这里目的是让我的数字到了 9 之后向前进一位，前面就只有一个 0 了，所以截取的 0 要减少一位
//            if(n - start == nine) start--;
//            return;
//        }
//        for (char i : loop) {
//            if(i == '9') nine++;
//            num[x] = i;
//            // 其实这一步就是为了让 num 字符每次都能够写到数组里面去
//            dfs(x+1);
//        }
//        nine--;
//    }

    // 返回的结果
    int[] res;

    /**
     * nine     用于判断 009 ~ 010 之间转换的时候需要去除的前面的 0 的个数
     * count    用于记录 res 的下标
     * start    用于记录当组合成一个数之后需要删除的前面的 0 时从 start 下标位置截取字符串
     * n        n 位数
     */
    int nine = 0, count = 0, start, n;

    /**
     * num      用于存储每次递归生成的一个三位数
     * loop     用于记录字符
     */
    char[] num, loop = {'0','1','2','3','4','5','6','7','8','9'};

    /**
     *
     * @param n     n 位数
     * @return
     */
    public int[] printNumbers(int n) {

        // 初始化成员变量
        this.res = new int[(int) Math.pow(10, n)-1];
        this.start = n - 1;
        this.n = n;
        this.num = new char[n];

        // 递归遍历，回溯
        dfs(0);

        return res;
    }

    /**
     *
     * @param x     递归
     */
    private void dfs(int x) {

        // 先确定输出字符串的条件，也就是递归结束条件
        if (x == n) {
            // 此时说明 num 数组已经有三位数了，直接输出存储在 res 中

            // 获取 num 中的字符生成字符串，并去除 s 前面的 0
            String s = new String(num).substring(start);

            // 判断这个数是否是 0，如果不是 0，就添加进 res 数组中
            if (!s.equals("0")) res[count++]  = Integer.parseInt(s);

            // 确定下次输出字符串去除的 0 是多少个，也就是更新 start
            if ((n - start) == nine) start--;

            return;
        }

        // 循环递归
        for (char c : loop) {

            if (c == '9') nine++;

            num[x] = c;

            dfs(x+1);

        }

        nine--;
    }
}
