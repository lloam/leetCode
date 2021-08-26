package com.mao.剑指offer14II剪绳子II;

/**
 * Author: Administrator
 * Date: 2021/7/5 16:39
 * Description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 这题与上一题的区别就是这题需要考虑大数越界问题，所以结果要对 1000000007 取模
//     * @param n
//     * @return
//     */
//    public int cuttingRope(int n) {
//        if (n <= 3) return n - 1;
//        int b = n % 3, p = 1000000007;
//        long rem = 1, x = 3;
//        for (int a = n / 3 - 1; a > 0; a /= 2) {
//            if(a % 2 == 1) rem = (rem * x) % p;
//            x = (x * x) % p;
//        }
//        // 这里还要乘余 3 是因为我们前面 for 循环只循环了 n / 3 - 1，因为当 b = 1的时候要拆出一个 3 来转换成 2 * 2
//        if (b == 0) return (int) ((rem * 3) % p);
//        else if (b == 1) return (int) ((rem * 4) % p);
//        else return (int) ((rem * 3 * 2) % p);
//    }


    /**
     * 这一题与另外一题的区别就是要考虑大数求余的问题
     * 考虑大数求余就要考虑 3 的 a 次方大数越界问题
     * 不能直接对结果求余
     * @param n     绳子的长度
     * @return
     */
    public int cuttingRope(int n) {

        // 如果长度小于等于 3
        if (n <= 3) return n - 1;

        // long 类型保证可以存储 1000000007 的 平方
        long rem = 1, x = 3;

        // 最后一段的长度
        int b = n % 3;

        // 考虑大数越界问题，使用快速幂求余法进行求余
        for (int a = n / 3 - 1; a > 0; a /= 2) {

            // 如果 a 是奇数
            if (a % 2 == 1) rem = (rem * x) % 1000000007;

            // 抵消 a /= 2
            x = (x * x) % 1000000007;

        }

        // 还有一个 3 要乘，因为循环从 n / 3 - 1,开始，用于当 b 为 2 时使乘积最大化
        if (b == 0) return (int) ((rem * 3) % 1000000007);

        // 最后一段为 1，将剩下一段 3 与 1 拆分为 2*2
        else if (b == 1) return (int) ((rem * 4) % 1000000007);

        // 最后一段为 2，剩下一段为 3，相乘就是 6
        else return (int) ((rem * 3 * 2) % 1000000007);

    }
}
