package com.mao.面试题01_08零矩阵;

/**
 * Author: lloam
 * Date: 2021/9/2 16:45
 * Description: 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class Solution {

//    /**
//     *
//     * @param matrix
//     */
//    public void setZeroes(int[][] matrix) {
//
//        int m = matrix.length, n = matrix[0].length;
//
//        boolean[] row = new boolean[m];
//        boolean[] col = new boolean[n];
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) {
//                    // 标记对应行和列是 0
//                    row[i] = true;
//                    col[j] = true;
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (row[i] || col[j]) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }

    /**
     * 使用二维数组的第一行和第一列来代替方法一中的两个 boolean 数组
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        boolean flagRow = false;
        boolean flagCol = false;

        // 将第一行和第一列是否有 0 元素记录下来
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                flagCol = true;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                flagRow = true;
            }
        }

        // 使用第一行和第一列记录
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 根据第一行和第一列清零
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 将第一行和第一列清零
        if (flagRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (flagCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
