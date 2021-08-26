package com.mao.剑指offer68II二叉树的最近公共祖先;

import com.mao.剑指offer55二叉树的深度.TreeNode;

/**
 * Author: Administrator
 * Date: 2021/7/4 11:14
 * Description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 这题和前一题的区别是前一题是二叉搜索树，这一题是二叉树，不符合左节点小于父节点，右节点大于父节点的规律
     * 思路呢就是遍历左右子节点
     * 如果遍历的节点的值有一个等于 p 或 q，那么直接返回当前遍历的节点
     * 递归左右节点，如果返回值都不为 null ，说明 p q 异侧，root则为公共祖先
     * 如果 left != null || right != null，说明 p q 同侧，返回不为 null 的那一侧
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if(root == null) return null;
        // 有一个相等就直接返回 root
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        else return left != null ? left : right;
    }
}
