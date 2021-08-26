package com.mao.剑指offer04二维数组中的查找;

/**
 * Author: Administrator
 * Date: 2021/7/4 15:31
 * Description: 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 想法就是这个二维数组向右是递增的，向下时递增的
//     * 那么我们定位元素的时候就可以取右上角的元素 flag 判断
//     * 大于右上角的元素那一行都不用考虑了，也就是 i++
//     * 小于右上角的元素那一列都不用考虑了，也就是 j--
//     * @param matrix
//     * @param target
//     * @return
//     */
//    public boolean findNumberIn2DArray(int[][] matrix,int target) {
//        if(matrix.length == 0) return false;
//        // j 是一维数组的长度 i 是0,也就是从右上角开始搜索
//        int j = matrix[0].length - 1, i = 0;
//        while (j >= 0 && i < matrix.length) {
//            // 如果 target 小于右上角的元素，那么一定在左边找，i--
//            if(target < matrix[i][j]) j--;
//            // 相反， 如果 target 大于右上角的元素，那么一定在下边找，j++
//            else if(target > matrix[i][j]) i++;
//            // 如果相等返回 true
//            else return true;
//        }
//        return false;
//    }

    /**
     * 对角递减判断
     * 取右上角为开始
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix,int target) {

        if (matrix.length == 0) return false;

        // 取右上角开始
        int j = matrix[0].length-1, i = 0;

        while (j >= 0 && i <= matrix[0].length-1) {

            // 如果大于右上角的元素就往下遍历
            if (target > matrix[i][j]) i++;

            // 如果小于右上角的元素就往左遍历
            else if (target < matrix[i][j]) j--;

            // 相等就返回 true
            else if (target == matrix[i][j]) return true;

        }

        // 遍历完成还没有 return ，就是没有该元素，返回 false
        return false;
    }
}
