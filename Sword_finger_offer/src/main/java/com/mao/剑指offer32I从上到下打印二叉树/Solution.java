package com.mao.剑指offer32I从上到下打印二叉树;

import com.mao.剑指offer55二叉树的深度.TreeNode;

import java.util.*;

/**
 * Author: Administrator
 * Date: 2021/7/6 17:03
 * Description: 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Solution {

//    /**
//     * 使用层序遍历，先遍历完一层再遍历下一层
//     * 每一层的元素存放在一个队列里面
//     * @param root
//     * @return
//     */
//    public int[] levelOrder(TreeNode root) {
//        if(root == null) return new int[0];
//        List<Integer> temp = new ArrayList<>();
//        // 存放每一层的节点
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            for (int i = queue.size(); i > 0; i--) {
//                TreeNode node = queue.poll();
//                temp.add(node.val);
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//            }
//        }
//        int[] res = new int[temp.size()];
//        for (int i = 0; i < temp.size(); i++) {
//            res[i] = temp.get(i);
//        }
//        return res;
//    }

    /**
     * 使用队列存储每一层的节点
     * 从上到下，从左到右打印
     * @param root 树的根节点
     * @return
     */
    public int[] levelOrder(TreeNode root) {

        if (root == null) return new int[0];

        // 一开始不能用数组存储节点值，因为节点个数未知，只能后面再转化成数组
        List<Integer> list = new ArrayList<>();

        // 存储每一层节点的队列
        Deque<TreeNode> deque = new LinkedList<>();

        // 先将根节点存入队列
        deque.addLast(root);

        // 循环遍历队列中的节点
        while (!deque.isEmpty()) {

            // 遍历队列，将队列中的同一层的元素节点值添加到集合中
            for (int i = deque.size(); i > 0; i--) {

                // 获取队列中的节点
                TreeNode node = deque.removeFirst();

                // 添加节点值
                list.add(node.val);

                // 添加左右子节点到队列中
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
        }

        // 遍历完成，将集合元素转化成数组
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        // 返回 res 数组
        return res;
    }
}
