package com.mao.剑指offer47礼物的最大价值;

/**
 * Author: Administrator
 * Date: 2021/7/10 16:10
 * Description: 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 动态规划，一个格子的礼物价值 = max(上面格子价值，左边格子价值) + 自己格子的价值
     * 前提是上面格子的价值是他的最多的价值，所以就能使用动态规划来求解
     * 具体思路可以看题解 k 神
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
//        // 先将第一行的每个格子价值计算出来，并赋值给自己
//        for (int k = 1; k < grid[0].length; k++) {
//            grid[0][k] = grid[0][k-1] + grid[0][k];
//        }
//        // 再将第一列的每个格子价值计算出来，并赋值给自己
//        for (int k = 1; k < grid.length; k++) {
//            grid[k][0] = grid[k-1][0] + grid[k][0];
//        }
//        // 再将中间其余的格子的价值计算出来，并且使用较大的数作为自己的角度
//        for (int i = 1; i < grid.length; i++) {
//            for (int j = 1; j < grid[0].length; j++) {
//                grid[i][j] = Math.max(grid[i-1][j],grid[i][j-1]) + grid[i][j];
//            }
//        }
//        // 这个时候右下角格子的价值就是所求的最多价值
//        return grid[grid.length-1][grid[0].length-1];
        /**
         * 另一种可以解决边界值的办法
         * 空间换时间，其实时间没有较少，只是省去了边界值判断
         */
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row+1][col+1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[row][col];
    }
}
