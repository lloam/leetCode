package com.mao.面试题04_04检查平衡性;

import com.mao.TreeNode;

/**
 * Author: 但愿人长久
 * Date: 2021/8/16 17:11
 * Description: 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 */
public class Solution {

//    /**
//     * 递归求树的深度
//     * @param root  根节点
//     * @return
//     */
//    public boolean isBalanced(TreeNode root) {
//
//        if (root == null) return true;
//
//        // 如果左子树的深度 - 右子树的深度 > 1 说明深度差超过 1，不是平衡二叉树，返回 false
//        if (Math.abs(high(root.left) - high(root.right)) > 1) return false;
//
//        // 以上仅仅判断 root 是平衡二叉树，但是要保证其子树也是平衡二叉树
//        return isBalanced(root.left) && isBalanced(root.right);
//
//    }
//
//
//    /**
//     * 求 node 树的深度 = 子树的深度 + 1
//     * @param node
//     * @return
//     */
//    private int high(TreeNode node) {
//
//        // 如果是叶子结点，深度为 0
//        if (node == null) return 0;
//
//        // 递归求子树的深度
//        return Math.max(high(node.left), high(node.right)) + 1;
//    }

    /**
     * 判断是否为平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {

        // 如果不是平衡二叉树，应该返回 -1
        return recur(root) != -1;

    }


    /**
     * 求树的深度
     * 并判断是否为平衡二叉树
     * @param root
     * @return
     * 如果左右子树高度差 >= 2 返回 -1：不是平衡二叉树
     * 如果左右子树高度差 < 2 说明这个子树暂时是平衡二叉树，子树深度 + 1
     */
    private int recur(TreeNode root) {

        if (root == null) return 0;

        // 求左子树深度
        int left = recur(root.left);
        // 如果左子树深度 = -1，直接返回 -1
        if (left == -1) return -1;

        // 求右子树深度
        int right = recur(root.right);
        // 如果右子树深度 = -1，直接返回 -1
        if (right == -1) return -1;

        // 左右子树已经是平衡树了，再判断左右子树深度差是否 >= 2，判断这棵树是否是平衡二叉树
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
