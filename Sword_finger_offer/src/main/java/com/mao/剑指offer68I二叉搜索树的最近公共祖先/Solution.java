package com.mao.剑指offer68I二叉搜索树的最近公共祖先;

import com.mao.剑指offer55二叉树的深度.TreeNode;

/**
 * Author: Administrator
 * Date: 2021/7/4 10:38
 * Description:  给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Solution {


//    /**
//     * 思路就是如果 p q 在同一侧，那么就遍历那一侧的 root
//     * 直到 p q 不在同一侧，返回 root
//     * 如果有一个的 val == root.val，
//     * 那么公共祖先就是 root
//     * @param root
//     * @param p
//     * @param q
//     * @return
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
//
//        while (root != null) {
//            // 在左侧
//            if(p.val < root.val && q.val < root.val) root = root.left;
//            // 在右侧
//            else if(p.val > root.val && q.val > root.val) root = root.right;
//            // 如果在不同侧，那公共祖先就是 root
//            else break;
//        }
//        return root;
//    }

    /**
     * 递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {

        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q);
        else if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        // 排除了这两种情况公共祖先就是 root
        return root;
    }
}
