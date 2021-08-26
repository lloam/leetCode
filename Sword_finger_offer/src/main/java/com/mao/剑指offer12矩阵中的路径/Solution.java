package com.mao.剑指offer12矩阵中的路径;

/**
 * Author: Administrator
 * Date: 2021/7/4 16:16
 * Description: 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 将二维数组看成一个图
//     * 进行深度优先遍历，不符合的路径直接回退，并标记不符合，俗称剪枝
//     * @param board
//     * @param word
//     * @return
//     */
//    public boolean exist(char[][] board,String word) {
//        if(board.length == 0) return false;
//        char[] words = word.toCharArray();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if(dfs(board,words,i,j,0)) return true;
//            }
//        }
//        // 循环完成没有返回就返回 false
//        return false;
//    }
//
//    /**
//     * 深度优先遍历
//     * 遍历上下左右四个方向可不可行
//     * @param board
//     * @param words
//     * @param i
//     * @param j
//     * @param k
//     * @return
//     */
//    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
//        // 先排除掉不可能的情况，越界和不相等
//        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || words[k] != board[i][j]) return false;
//        // 如果是单词最后一个字母直接返回
//        if(k == words.length - 1) return true;
//        // 让遍历过的元素为 ''，防止再次遍历
//        board[i][j] = '\0';
//        // 向 上下左右 四个方向遍历
//        boolean res = dfs(board,words,i+1,j,k+1) || dfs(board,words,i-1,j,k+1) ||
//                dfs(board,words,i,j+1,k+1) || dfs(board,words,i,j-1,k+1);
//        // 还原
//        board[i][j] = words[k];
//        return res;
//    }


    /**
     * 深度优先遍历
     * 首先找到第一个符合的字符，然后进行深度优先遍历
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board,String word) {

        // 二维数组长度为 0，返回 false
        if (board.length == 0) return false;

        // 单词的字符数组
        char[] words = word.toCharArray();

        // 遍历二维数组，寻找第一个字符符合的元素，进行深度优先遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }

        // 没有返回说明没有符合的单词，返回 false
        return false;
    }

    /**
     * 深度优先遍历
     * @param board 二维数组
     * @param words 单词
     * @param i     二维数组中一维数组的下标
     * @param j     二维数组中一维数组的元素的下标
     * @param k     单词字符数组的元素的下标
     * @return
     */
    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {

        // 首先判断不符合情况，直接返回：越界、不相等
        if (i < 0 || j < 0 || i > board.length || j > board[0].length || words[k] != board[i][j]) return false;

        // 如果递归到单词数组的最后一个元素，说明整个单词字符都在二维数组中，返回 true
        if (k == words.length - 1) return true;

        // 标记已经遍历过的元素，俗称“剪枝”
        board[i][j] = '\0';

        // 递归，寻找符合的字符
        boolean res = dfs(board, words, i-1, j, k+1) || dfs(board, words, i, j+1, k+1)
                || dfs(board, words, i+1, j, k+1) || dfs(board, words, i, j-1, k+1);

        // 将数组还原
        board[i][j] = words[k];

        // 返回结果
        return res;

    }
}
