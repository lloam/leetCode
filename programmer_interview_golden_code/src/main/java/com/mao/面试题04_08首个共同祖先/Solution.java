package com.mao.面试题04_08首个共同祖先;

import com.mao.TreeNode;

/**
 * Author: lloam
 * Date: 2021/10/13 23:50
 * Description: 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
 * 不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 */
public class Solution {

    /**
     * 递归
     * 第一次完全靠自己做出来了，虽然复杂度不是最优
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 如果当前节点为空，直接返回 null
        if (root == null) return null;

        // 如果当前节点的值 == 其中一个节点值，说明当前节点是这个节点的祖先
        if (root.val == p.val || root.val == q.val) return root;

        // 递归左节点，看左节点中是否有目标节点的祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 递归右节点，看右节点中是否有目标节点的祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果返回的左右节点都没有目标节点祖先，则返回 null
        if (left == null && right == null) return null;

        // 如果返回的左右节点中都有目标节点的祖先，说明目标节点分布在两侧，返回 root
        if (left != null && right != null) return root;

        // 如果左节点不为空，右节点就是空，说明左节点含有共同祖先，返回左节点
        if (left != null) return left;
        else return right;
    }
}
