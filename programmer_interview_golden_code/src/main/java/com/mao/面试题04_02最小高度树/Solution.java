package com.mao.面试题04_02最小高度树;


import com.mao.TreeNode;

/**
 * Author: 但愿人长久
 * Date: 2021/8/16 16:34
 * Description: 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 */
public class Solution {

    /**
     * 递归遍历
     * 这个方法是返回树的根节点
     * 那么就可以递归这个方法，返回根节点的左右子树
     * @param nums  待创建二叉树的数组
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return recurGetSunTree(nums, 0, nums.length - 1);
    }

    /**
     * 获取左右子树
     * @param nums  数组
     * @param left  子树左边界
     * @param right 子树右边界
     * @return
     */
    private TreeNode recurGetSunTree(int[] nums, int left, int right) {

        if (left > right) return null;

        int nodeValIndex = (right - left) / 2 + left;

        // 创建子树
        TreeNode node = new TreeNode(nums[nodeValIndex]);

        // 设置子树的左子树
        node.left = recurGetSunTree(nums, left, nodeValIndex - 1);

        // 设置子树的右子树
        node.right = recurGetSunTree(nums, nodeValIndex + 1, right);

        // 返回子树
        return node;
    }
}
