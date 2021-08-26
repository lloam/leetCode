package com.mao.剑指offer32II从上到下打印二叉树II;

import com.mao.剑指offer55二叉树的深度.TreeNode;

import java.awt.print.Pageable;
import java.util.*;

/**
 * Author: Administrator
 * Date: 2021/7/3 16:31
 * Description: 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，
 * 每一层打印到一行。
 */
public class Solution {

//    /**
//     * 首先将 root 存入到一个队列中
//     * 然后分层打印
//     * 在 for 循环那里要注意要从高到低循环，因为队列的长度是时刻变化的
//     * @param root
//     * @return
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if(root == null) return null;
//        Queue<TreeNode> level = new LinkedList<>();
//        level.add(root);
//        while (!level.isEmpty()) {
//            List<Integer> list = new ArrayList<>();
//            for(int i = level.size(); i > 0; i--) {
//                TreeNode node = level.poll();
//                list.add(node.val);
//                if(node.left != null) level.add(node.left);
//                if(node.right != null) level.add(node.right);
//            }
//            res.add(list);
//        }
//        return res;
//    }


    /**
     * 与 I 思想一样
     * 只不过这个是返回 list 集合
     * @param root  根节点
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        // 存储结果的集合
        List<List<Integer>> res = new ArrayList<>();

        // 存储每一层节点的队列
        Queue<TreeNode> queue = new LinkedList<>();

        // 先将根节点存储到队列中
        if (root != null) queue.add(root);

        // 存储每一层的节点
        List<Integer> list;

        // 循环
        while (!queue.isEmpty()) {

            // 每执行一次 for 循环就遍历出一层节点，因此这个 list 要放在 for 循环外面初始化
            list = new ArrayList<>();

            // 队列中存储的节点是同一层的，遍历每一层的节点
            for (int i = queue.size(); i > 0; i--) {

                // 获取队列中的节点
                TreeNode node = queue.poll();

                // 添加节点值
                list.add(node.val);

                // 将该节点的左右子节点添加进队列中
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // for 循环结束，一层的节点遍历完成，添加这个集合到结果集合中
            res.add(list);
        }

        // 循环结束，返回结果集合
        return res;
    }

}
