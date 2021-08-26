package com.mao.剑指offer14I剪绳子;

/**
 * Author: Administrator
 * Date: 2021/7/5 15:43
 * Description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 使用数学推导公式，可知分为长度为 3 的段乘积会最大化
//     * @param n
//     * @return
//     */
//    public int cuttingRope(int n) {
//        // 如果 n <= 3，那么乘积最大是 n-1
//        if(n <= 3) return n - 1;
//        // a 为分成长度为 3 的段数，d 为最后剩下的一段的长度
//        int a = n / 3, d = n % 3;
//        if(d == 0) return (int) Math.pow(3,a);
//        else if(d == 1) return (int) (Math.pow(3,a-1) * 4);
//        else return (int) (Math.pow(3,a) * 2);
//    }

    /**
     * 使用数学公式的
     * 可知分为长度为 3 的段会使得乘积最大
     * @param n     绳子的长度
     * @return
     */
    public int cuttingRope(int n) {

        // 如果长度小于等于 3，直接返回 n - 1
        if (n <= 3) return n - 1;

        // 获取可以截取的 3 的段数，以及最后一段的长度
        int a = n / 3, b = n % 3;

        // 如果刚好分完，全是 3 的长度
        if (b == 0) return (int) Math.pow(3, a);

        // 如果最后一段为 1，那么应该将一段长度为 3 的绳子分为 2 * 2，使得乘积最大
        else if (b == 1) return (int) (Math.pow(3, a-1) * 4);

        // 如果最后一段长度为 2，直接相乘
        else return (int) (Math.pow(3, a) * 2);
    }
}
