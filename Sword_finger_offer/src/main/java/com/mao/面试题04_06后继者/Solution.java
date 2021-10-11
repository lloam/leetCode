package com.mao.面试题04_06后继者;

import com.mao.剑指offer55二叉树的深度.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lloam
 * Date: 2021/10/11 23:35
 * Description: 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 */
public class Solution {

    /**
     * 主要看二叉树中指定的节点有没有右节点
     * 实在忘了就看题解,
     * 先遍历得到指定的节点
     * 如果指定节点有右节点，则返回右节点中最左边的孩子节点
     * 如果指定节点没有右节点
     *      如果该节点是左节点，则返回该节点的父节点
     *      如果该节点是右节点，则返回，依旧返回该节点右子节点的最左边节点
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while (root.val != p.val) {
            if (root.val < p.val) {
                // 指定节点在右边
                root = root.right;
            }else {
                // 指定节点在左边
                pre = root;
                root = root.left;
            }
        }

        // 得到指定节点
        // 判断该节点是否有右子节点
        if (root.right == null) {
            // 没有右节点
            return pre;
        }else {
            // 该节点有右子节点
            root = root.right;
            while (root.left != null) root = root.left;
            return root;
        }
    }
}
