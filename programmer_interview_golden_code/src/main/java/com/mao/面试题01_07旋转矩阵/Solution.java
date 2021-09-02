package com.mao.面试题01_07旋转矩阵;

/**
 * Author: lloam
 * Date: 2021/9/2 15:55
 * Description: 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。
 * 请你设计一种算法，将图像旋转 90 度。  不占用额外内存空间能否做到？
 */
public class Solution {

//    /**
//     * 方法一
//     * 使用辅助矩阵
//     * 需要额外的 N^2 的空间
//     * @param matrix
//     */
//    public void rotate(int[][] matrix) {
//
//        int[][] res = new int[matrix.length][matrix[0].length];
//
//        int n = matrix.length;
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                res[j][n - i - 1] = matrix[i][j];
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[i][j] = res[i][j];
//            }
//        }
//
//        return;
//    }


    /**
     * 方法二
     * 有点绕
     * 就是找到关系
     * 具体可看题解
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }


//    /**
//     * 方法三
//     * 先将二维数组水平翻转
//     * 再将二维数组根据对角线翻转
//     * 即可得到值
//     * @param matrix
//     */
//    public void rotate(int[][] matrix) {
//
//        int n = matrix.length;
//
//        // 水平翻转
//        for (int i = 0; i < matrix.length/2; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n - i - 1][j];
//                matrix[n - i - 1][j] = temp;
//            }
//        }
//
//        // 对角线翻转
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//    }
}
