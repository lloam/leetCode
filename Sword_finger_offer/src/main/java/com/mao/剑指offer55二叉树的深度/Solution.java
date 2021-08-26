package com.mao.剑指offer55二叉树的深度;

/**
 * Author: Administrator
 * Date: 2021/5/31 22:37
 * Description:二叉树的深度
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode treeNode){
        if(treeNode == null)
            return 0;
        return Math.max(maxDepth(treeNode.left),maxDepth(treeNode.right)) + 1;
    }
}
