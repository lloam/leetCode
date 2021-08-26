package com.mao.剑指offer62圆圈中最后剩下的数字_约瑟夫环;

/**
 * Author: Administrator
 * Date: 2021/6/21 22:20
 * Description:0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 约瑟夫环问题，f(n) = (f(n-1) + m%n)%n
     * @param n
     * @param m
     * @return
     */
    public int  lastRemaining(int n,int m){
        int x = 0;
        for(int i = 2; i < n; i++){
            x = (x + m)%i;
        }
        return x;
    }
}
