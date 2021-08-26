package com.mao.剑指offer49丑数;

/**
 * Author: Administrator
 * Date: 2021/6/13 22:19
 * Description: 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 */
public class Solution {
    public int nthUglyNumber(int n) {
        // 用于定位前多少个丑数，
        // a代表前a个丑数*2就是第n个丑数，
        // b代表前b个丑数*3就是第n个丑数，
        // c代表前c个丑数*5就是第n个丑数
        // 总之，第n个丑数一定是前a，b，c个丑数分别乘于各自的系数得到的最小的数就是第n个丑数
        int a = 0,b = 0,c = 0;
        // 用来存放前 n 个丑数
        int[] dp = new int[n];
        // 我们知道第一个丑数是 1
        dp[0] = 1;
        // 那么第二个丑数一定是 dp[0] * 2,dp[0] * 3,dp[0] * 5中最小的数，显然是2
        for (int i = 1; i < n; i++){
            // 第 i 个丑数一定是dp[a] * 2,dp[b] * 3,dp[c] * 5中最小的数
            int n1 = dp[a]*2;
            int n2 = dp[b]*3;
            int n3 = dp[c]*5;
            // 求这三个数中最小的数就是下一个丑数，也就是第 i 个丑数
            dp[i] = Math.min(Math.min(n1,n2),n3);
            if(n1 == dp[i]) a++;// 如果dp[a]乘于2是下一个丑数，那么前a个丑数乘于2一定不是再下一个丑数了，所以a要加一了
            if(n2 == dp[i]) b++;// 同理
            if(n3 == dp[i]) c++;// 同理，有的时候可能前a个丑数乘于2和前c个丑数乘于3得到的是同一个丑数，同样的道理都要进行加一
        }
        // 程序执行到这里，说明得到了第 n 个丑数
        return dp[n-1];
    }
}
