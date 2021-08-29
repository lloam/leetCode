package com.mao.面试题17_12BiNode;

import com.mao.TreeNode;

/**
 * Author: 但愿人长久
 * Date: 2021/8/29 18:54
 * Description: 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，
 * 也就是在原始的二叉搜索树上直接修改。  返回转换后的单向链表的头节点。
 * 注意：本题相对原题稍作改动
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    // 为了存储返回节点的头节点，先创建一个节点
    TreeNode head = new TreeNode(-1);
    TreeNode prev;

    /**
     * 递归遍历，先遍历左节点，再遍历右节点
     * @param root
     * @return
     */
    public TreeNode convertBiNode(TreeNode root) {

        helper(root);

        return head.right;
    }

    /**
     * 递归遍历
     * @param root
     */
    private void helper(TreeNode root) {

        if (root == null) return;

        // 先遍历左节点
        helper(root.left);

        // 遍历根节点
        if (prev == null) {
            prev = root;
            head.right = root;
        }else {
            prev.right = root;
            prev = root;
        }

        // 将左节点置为空
        root.left = null;

        // 遍历右节点
        helper(root.right);
    }

}
