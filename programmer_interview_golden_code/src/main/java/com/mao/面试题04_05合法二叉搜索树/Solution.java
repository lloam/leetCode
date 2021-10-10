package com.mao.面试题04_05合法二叉搜索树;

import com.mao.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Author: lloam
 * Date: 2021/10/10 23:04
 * Description: 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 */
public class Solution {

//    /**
//     * 判断是否是一颗二叉搜索树
//     * 左右子树也必须是二叉搜索树
//     * @param root
//     * @return
//     */
//    public boolean isValidBST(TreeNode root) {
//        return helper(root, null, null);
//    }
//
//    private boolean helper(TreeNode node, Integer lower, Integer upper) {
//        if (node == null) return true;
//
//        // 根节点的值
//        int val = node.val;
//
//        // 左节点的值都要比根节点小
//        if (lower != null && val <= lower) return false;
//
//        // 右节点的值都要比根节点大
//        if (upper != null && val >= upper) return false;
//
//        // 递归遍历左节点
//        if (!helper(node.left, lower, val)) return false;
//
//        // 便利右节点
//        if (!helper(node.right, val, upper)) return false;
//
//        return true;
//    }

    /**
     * 判断是否是一颗二叉搜索树
     * 中序遍历一定是升序
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        double inOrder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            // 先将所有左子节点都加入栈中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 取出最下面的左子节点
            root = stack.pop();

            // 取出来的节点肯定比前一个数大，不大则不是二叉搜索树
            if (root.val <= inOrder) return false;

            // 更新中序遍历节点
            inOrder = root.val;

            // 右节点其实是空的，所以下一个遍历的就是该节点的父节点，达到了中序遍历
            root = root.right;
        }
        return true;
    }
}
