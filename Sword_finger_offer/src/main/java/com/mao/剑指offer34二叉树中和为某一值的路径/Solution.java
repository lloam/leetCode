package com.mao.剑指offer34二叉树中和为某一值的路径;

import com.mao.剑指offer55二叉树的深度.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Administrator
 * Date: 2021/6/10 22:19
 * Description: 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class Solution {
    List<List<Integer>> allPath = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return allPath;
    }

    /**
     * 核心是递归，二叉树的先序遍历（根，左，右）和路径记录
     * @param root
     * @param target
     * @return
     */
    private void recur(TreeNode root, int target) {
        // 递归的结束条件
        if(root == null) return;
        // 将节点的值加入路径
        path.add(root.val);
        // target要减去节点值
        target -= root.val;
        // 如果当target 值为 0 时，而且root没有子节点，
        // 也就是root是叶子结点的时候target == 0，那么此路径就是符合的
        if(target == 0 && root.left == null && root.right == null){
            allPath.add(new LinkedList<>(path));
        }
        // 继续递归遍历子节点
        // 先遍历左节点，再遍历右节点，因为是先序遍历
        recur(root.left,target);
        recur(root.right,target);
        // 每次遍历完一条路线，就要一次删除路径中的值，方便父节点的兄弟节点的遍历
        path.removeLast();
    }
}
