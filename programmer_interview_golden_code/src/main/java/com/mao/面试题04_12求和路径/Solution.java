package com.mao.面试题04_12求和路径;

import com.mao.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lloam
 * Date: 2021/10/15 23:34
 * Description: 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    int count;

    /**
     * 前缀和 currNum
     * 假设当前节点的前缀和为 currNum，如果前面有一个节点的前缀和为 currNum - sum
     * 那么这两个节点直接的节点就是一条路径
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        // 存储前缀和个数，key 是前缀和，value 是前缀和为 key 出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为 0 的路径为 0 条
        prefixSumCount.put(0,1);
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    /**
     *
     * @param node
     * @param prefixSumCount
     * @param targetSum
     * @param currSum
     * @return
     */
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int targetSum, int currSum) {
        // 递归终止
        if (node == null) return 0;

        // 本层路径数
        int res = 0;

        // 当前节点前缀和
        currSum += node.val;

        // 当前节点满足 targetSum 的之前的节点个数，也就是路径数
        res += prefixSumCount.getOrDefault(currSum-targetSum,0);

        // 更新前缀和为 currNum 的路径数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum,0)+1);

        // 递归左右子树
        res += recursionPathSum(node.left, prefixSumCount, targetSum, currSum);
        res += recursionPathSum(node.right, prefixSumCount, targetSum, currSum);

        // 返回本层节点，需要 - 1，恢复状态，避免影响其他节点计算前缀和个数
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }
}
