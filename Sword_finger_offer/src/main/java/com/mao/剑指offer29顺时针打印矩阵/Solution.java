package com.mao.剑指offer29顺时针打印矩阵;

/**
 * Author: Administrator
 * Date: 2021/7/1 22:31
 * Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Solution {
//    /**
//     * 这题直接看大神吧
//     * @param matrix
//     * @return
//     */
//    public int[] spiralOrder(int[][] matrix) {
//        if(matrix.length == 0) return new int[0];
//        // l 是左边界，r 是右边界，t 是上边界，b 是下边界
//        int l = 0, r = matrix[0].length-1, t = 0, b = matrix.length-1, x = 0;
//        // 存储结果的数组
//        int[] res = new int[(r+1)*(b+1)];
//        while (true){
//            for(int i = l;i <= r;i++) res[x++] = matrix[t][i];// 从左往右 t 会加 1
//            if(++t > b) break;
//            for (int i = t;i <= b;i++) res[x++] = matrix[i][r];// 从上往下 r 会减 1
//            if(--r < l) break;
//            for (int i = r;i >= l;i--) res[x++] = matrix[b][i]; // 从右往左 b 会减 1
//            if(--b < t) break;
//            for (int i = b;i >= t;i--) res[x++] = matrix[i][l]; // 从下往上 l 会加 1
//            if(++l > r) break;
//        }
//        return res;
//    }

    /**
     * 就是将想法转变为代码表达出来
     * @param matrix    要打印的二维数组
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {

        if (matrix.length == 0) return new int[0];

        // 记录二维数组的四个边界
        /**
         * t：top、上边界
         * r：right、有边界
         * b：bottom、下边界
         * l：left、左边界
         */
        int t = 0, r = matrix[0].length-1, b = matrix.length-1, l = 0;

        // 用于存储返回的结果
        int[] res = new int[matrix.length * matrix[0].length];

        // 记录结果数组的下标
        int size = 0;

        // 循环遍历
        while (true) {

            // 遍历上边界元素
            for (int j = l; j <= r; j++) res[size++] = matrix[t][j];
            // 如果上边界大于下边界，退出循环
            if (++t > b) break;

            // 遍历右边界元素
            for (int i = t; i <= b; i++) res[size++] = matrix[i][r];
            // 如果右边界小于左边界，退出循环
            if (--r < l) break;

            // 遍历下边界元素
            for (int j = r; j >= l; j--) res[size++] = matrix[b][j];
            // 如果下边界小于上边界，退出循环
            if (--b < t) break;

            // 遍历左边界元素
            for (int i = b; i >= t; i--) res[size++] = matrix[i][l];
            // 如果左边界大于右边界，退出循环
            if (++l > r) break;
        }

        return res;
    }
}
