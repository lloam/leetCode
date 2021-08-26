package com.mao.剑指offer28对称的二叉树;

import com.mao.剑指offer55二叉树的深度.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: Administrator
 * Date: 2021/6/29 22:28
 * Description: 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Solution {

//    /**
//     * 按我的理解涉及到二叉树一般都要用到递归
//     * @param root
//     * @return
//     */
//    public boolean isSymmetric(TreeNode root) {
//        return root == null ? true : recur(root.left,root.right);
//    }
//
//    /**
//     * 比较左右两个子树的值是否相等
//     * @param left
//     * @param right
//     */
//    private boolean recur(TreeNode left, TreeNode right) {
//        // 如果两个节点同时为 null，则返回 true
//        if(left == null && right == null) return true;
//        // 如果只有一个为null或者 val 不相等，则返回false
//        if(left == null || right == null || left.val != right.val) return false;
//        // 两者都不为空，则递归
//        return recur(left.left,right.right) && recur(left.right,right.left);
//    }


    /**
     * 递归判断左右子树是否是对称的
     * @param root  根节点
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        return root == null ? true : recur(root.left, root.right);

    }

    /**
     * 判断这两个节点是否为对称节点
     * 两个同时为空，是对称节点，返回 true
     * 一个为空，一个不为空，不是对称节点，返回 false
     * 两个 val 不相等，不是对称节点，返回 false
     * 两者都不为空，并且值相等，递归遍历左右子节点，判断是否为对称节点
     * @param left  左节点
     * @param right 右节点
     * @return
     */
    private boolean recur(TreeNode left, TreeNode right) {

        // 两者都为空
        if (left == null && right == null) return true;

        // 有一个为空，或者值不相等
        /**
         * 这里用或是因为：二者一定有一个为 null 或者两个都不为 null
         * 如果 left == null，那么另一个一定不为 null ，不需要进行以后的判断，因此使用 || 直接返回 false
         * 如果 left ！= null，那么另一个可能为 null，如果 right == null，同理直接返回 false
         * 如果 right ！= null ，那么才有可能进行下面的 val 判断，所以使用 ||
         */
        if (left == null || right == null || left.val != right.val) return false;

        // 如果两个都不为 null，判断左右子节点
        return recur(left.left, right.right) && recur(left.right, right.left);
    }


    /***********************************************************************/
    public static void main(String[] args) {
        String[][] s1 = {
                {"A1","B1","C1","D1","E1"},
                {"A2","B2","C2","D2","E2"},
                {"A3","B3","C3","D3","E3"}
        };
        String[][] s2 = new String[s1.length][s1[0].length];

        System.arraycopy(s1, 0, s2, 0, s2.length);
        for(int i = 0;i < s1.length ;i++){

            for(int j = 0; j< s1[0].length ;j++){
                System.out.print(" " + s1[i][j] + " ");
            }
            System.out.println();
        }
        s2[0][0] = "V";
        s2[0][1] = "X";
        s2[0][2] = "Y";
        s2[0][3] = "Z";
        s2[0][4] = "U";

        System.out.println("----修改值后----");


        for(int i = 0;i < s1.length ;i++){
            for(int j = 0; j< s1[0].length ;j++){
                System.out.print(" " + s1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
