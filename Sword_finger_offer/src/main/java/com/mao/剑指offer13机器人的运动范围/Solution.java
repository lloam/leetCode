package com.mao.剑指offer13机器人的运动范围;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Administrator
 * Date: 2021/7/4 18:00
 * Description: 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    int m, n, k;
//    boolean[][] visited;
//    /**
//     * 想法直接看大佬的吧，太难记了
//     * @param m
//     * @param n
//     * @param k
//     * @return
//     */
//    public int movingCount(int m,int n,int k) {
//        this.m = m;
//        this.n = n;
//        this.k = k;
//        this.visited = new boolean[m][n];
//        return dfs(0,0,0,0);
//    }
//
//    /**
//     * 深度优先遍历
//     * @param i
//     * @param j
//     * @param si
//     * @param sj
//     * @return
//     */
//    private int dfs(int i, int j, int si, int sj) {
//        // 先排除不符合的情况，越界和位数和大于 k ，被访问过
//        if(i >= m || j >= n || (si + sj) > k || visited[i][j]) return 0;
//        // 标记已访问过
//        visited[i][j] = true;
//        // 回溯
//        return 1 + dfs(i+1,j,(i + 1) % 10 != 0 ? si + 1 : si -8,sj) + dfs(i,j+1,si,(j+1) % 10 != 0 ? sj + 1 : sj - 8);
//    }

//    /**
//     * 广度优先遍历
//     * @param m
//     * @param n
//     * @param k
//     * @return
//     */
//    public int movingCount(int m,int n,int k) {
//        // 使用 队列来保存需要遍历的节点格子，分别有当前格子的位置 i j，以及位数 si, sj
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0,0,0,0});
//        // 依旧使用 boolean 数组来控制是否访问过了
//        boolean[][] visited = new boolean[m][n];
//        // 记录符合的格子数
//        int res = 0;
//        // 开始广度优先便利
//        while (!queue.isEmpty()) {
//            // 首先将队列中的格子取出来
//            int[] poll = queue.poll();
//            // 将格子的取值转换
//            int i = poll[0], j = poll[1], si = poll[2], sj = poll[3];
//            // 判断这个格子是否符合要求，不符合就跳过
//            if(i >= m || j >= n || (si + sj) > k || visited[i][j]) continue;
//            // 标记以及访问过
//            visited[i][j] = true;
//            // 符合的格子数 + 1
//            res++;
//            // 将这个格子的 下 右 的格子放进队列中
//            queue.add(new int[]{i+1,j,(i+1) % 10 != 0 ? si + 1 : si - 8,sj});
//            queue.add(new int[]{i,j+1,si,(j+1) % 10 != 0 ? sj + 1 : sj - 8});
//        }
//        return res;
//    }


    /******************************************************/

    // 变成成员变量，方便在递归的时候使用
    int m, n, k;

    // 用于判断是否已经走过访问过
    boolean[][] visited;
    /**
     * 递归遍历
     * @param m     m 行
     * @param n     n 列
     * @param k
     * @return
     */
    public int movingCount(int m,int n,int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);

    }

    /**
     *
     * @param i     行，也就是二维数组的一维数组索引
     * @param j     列，也就是二维数组的一维数组的元素索引
     * @param si    每个方格的行坐标位数和
     * @param sj    每个方格的列坐标位数和
     * @return
     */
    private int dfs(int i, int j, int si, int sj) {

        // 排除不符合的情况：越界；位数和大于 k；被访问过
        if (i >= m || j >= n || (si+sj) > k || visited[i][j]) return 0;

        // 标记已经访问过
        visited[i][j] = true;

        // 回溯，下  右 方向的格子
        return 1 + dfs(i+1, j, (i+1) % 10 != 0 ? si+1 : si-8, sj) + dfs(i, j+1, si, (j+1) % 10 != 0 ? sj+1 : sj-8);
    }


//    /**
//     * 使用队列来存储二维数组中的元素
//     * @param m
//     * @param n
//     * @param k
//     * @return
//     */
//    public int movingCount(int m,int n,int k) {
//
//        // 存储能走到的方格位置
//        Queue<int[]> queue = new LinkedList<>();
//
//        // 先将第一个位置存进去
//        /**
//         * 一维数组四个索引分别为：
//         * i：元素的行
//         * j：元素的列
//         * si：元素行坐标的位数和
//         * sj：元素列坐标的位数和
//         */
//        queue.add(new int[]{0, 0, 0, 0});
//
//        // 用于标记是否被访问过
//        boolean[][] visited = new boolean[m][n];
//
//        // 记录访问放个数
//        int res = 0;
//
//        // 遍历
//        while (!queue.isEmpty()) {
//
//            // 获取队列元素
//            int[] poll = queue.poll();
//
//            // 将元素中的值取出来，分别对应
//            int i = poll[0], j = poll[1], si = poll[2], sj = poll[3];
//
//            // 不符合就直接下一个循环
//            if (i >= m || j >= n || (si+sj) > k || visited[i][j]) continue;
//
//            // 标记已访问过
//            visited[i][j] = true;
//
//            // 访问格子数 + 1
//            res++;
//
//            // 添加当前格子的下方格子位置
//            queue.add(new int[]{i+1, j, (i+1) % 10 != 0 ? si+1 : si-8, sj});
//
//            // 添加当前格子的右方格子位置
//            queue.add(new int[]{i, j+1, si, (j+1) % 10 != 0 ? sj+1 : sj-8});
//        }
//
//        // 返回
//        return res;
//    }

}
