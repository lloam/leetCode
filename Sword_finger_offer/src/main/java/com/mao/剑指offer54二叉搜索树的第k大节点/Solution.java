package com.mao.剑指offer54二叉搜索树的第k大节点;

import com.mao.剑指offer55二叉树的深度.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/7/3 21:47
 * Description: 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Solution {

    int res,k;
    /**
     * 二叉搜索树的中序遍历是递增的序列，求第 k 大的节点其实就是
     * 求二叉搜索树中序遍历的倒叙的第 k 个元素
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root,int k) {
        this.k = k;
        reverseMid(root);
        return res;
    }

    /**
     * 二叉搜索树的中序遍历的倒叙
     * @param root
     * @return
     */
    private void reverseMid(TreeNode root) {
        if(root == null) return;
        // 先遍历右节点
        reverseMid(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        reverseMid(root.left);
    }
}
