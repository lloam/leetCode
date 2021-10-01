package com.mao.面试题04_03特定深度节点链表;

import com.mao.ListNode;
import com.mao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: lloam
 * Date: 2021/10/1 23:46
 * Description: 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 */
public class Solution {

//    /**
//     * 层序遍历
//     * 使用队列存储每一层的元素
//     * @param tree
//     * @return
//     */
//    public ListNode[] listOfDepth(TreeNode tree) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(tree);
//        List<ListNode> listNodes = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            ListNode listNode = new ListNode(0);
//            ListNode temp = listNode;
//            for (int i = queue.size(); i > 0; i--) {
//                TreeNode node = queue.poll();
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//                ListNode lNode = new ListNode(node.val);
//                temp.next = lNode;
//                temp = temp.next;
//            }
//            listNodes.add(listNode.next);
//        }
//        ListNode[] res = new ListNode[listNodes.size()];
//        return listNodes.toArray(res);
//    }
    /**
     * 层序遍历
     * 使用队列存储每一层的元素
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        // 使用队列保存每层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        // 将每一个节点的值存在集合当中
        List<List<Integer>> listNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 每一层都有一个集合
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                ListNode lNode = new ListNode(node.val);
                list.add(node.val);
            }
            listNodes.add(list);
        }
        // 将集合进行转化
        ListNode[] res = new ListNode[listNodes.size()];
        for (int i = 0; i < res.length; i++) {
            ListNode listNode = new ListNode(0);
            ListNode temp = listNode;
            List<Integer> list = listNodes.get(i);
            for (int j = 0; j < list.size(); j++) {
                temp.next = new ListNode(list.get(j));
                temp = temp.next;
            }
            res[i] = listNode.next;
        }
        return res;
    }
}
