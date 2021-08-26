package com.mao.剑指offer55II平衡二叉树;

import com.mao.剑指offer55二叉树的深度.TreeNode;

/**
 * Author: Administrator
 * Date: 2021/7/3 22:53
 * Description: 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Solution {

//    /**
//     * 我的想法是先分别求出左右子树的高度，再相减，如果差 > 1，则返回 false
//     * 否则，就递归判断左右子树是否是平衡二叉树
//     * @param root
//     * @return
//     */
//    public boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        if(Math.abs(high(root.left) - high(root.right)) > 1) {
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
//    /**
//     * 求树的高度
//     * @param node
//     * @return
//     */
//    private int high(TreeNode node) {
//        if(node == null) return 0;
//        return Math.max(high(node.left),high(node.right)) + 1;
//    }
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * 判断是否为平衡二叉树，如果当前树的左右子树深度相差 2 ，则返回 -1，不是平衡二叉树
     * 如果当前树的左右子树的深度相差 < 2，则返回子树深度 + 1
     * @param root
     * @return
     */
    private int recur(TreeNode root) {
        if(root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }
}
