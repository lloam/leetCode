package com.mao.剑指offer32III从上到下打印二叉树III;

import com.mao.剑指offer55二叉树的深度.TreeNode;

import java.util.*;

/**
 * Author: Administrator
 * Date: 2021/7/9 20:37
 * Description:
 */
public class Solution {

//    /**
//     * 这题和其他两题类型
//     * 只不过这题使用双端队列来保存每一层的节点值
//     * 然后定义一个变量，其实这个变量就是我们的二叉树遍历的层数，也就是List的 size
//     * 如果是偶数就在尾部保存节点
//     * 如果是奇数就在头部保存节点
//     * @param root
//     * @return
//     */
//    public List<List<Integer>> levelOrder(TreeNode root){
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> list = new ArrayList<>();
//        if(root == null) return list;
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            LinkedList<Integer> listLevel = new LinkedList<>();
//            for (int i = queue.size(); i > 0; i--) {
//                TreeNode node = queue.poll();
//                if(list.size() % 2 == 0) listLevel.addLast(node.val);
//                else listLevel.addFirst(node.val);
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//            }
//            list.add(listLevel);
//        }
//        return list;
//    }

//    /**
//     *
//     * @param root
//     * @return
//     */
//    public List<List<Integer>> levelOrder(TreeNode root){
//        Deque<TreeNode> deque = new LinkedList<>();
//        List<List<Integer>> list = new ArrayList<>();
//        if(root == null) return list;
//        deque.add(root);
//        while (!deque.isEmpty()) {
//            List<Integer> listLevel = new ArrayList<>();
//            // 遍历偶数层
//            for (int i = deque.size(); i > 0; i--) {
//                TreeNode node = deque.removeFirst();
//                listLevel.add(node.val);
//                if(node.left != null) deque.addLast(node.left);
//                if(node.right != null) deque.addLast(node.right);
//            }
//            list.add(listLevel);
//            if (deque.isEmpty()) break;
//            listLevel = new ArrayList<>();
//            // 遍历奇数层
//            for (int i = deque.size(); i > 0; i--) {
//                TreeNode node = deque.removeLast();
//                listLevel.add(node.val);
//                if(node.left != null) deque.addFirst(node.right);
//                if(node.right != null) deque.addFirst(node.left);
//            }
//            list.add(listLevel);
//        }
//        return list;
//    }
    /**
     * 如果是奇数层，就反转一下集合
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> listLevel = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                listLevel.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(list.size() % 2 == 1) Collections.reverse(listLevel);
            list.add(listLevel);
        }
        return list;
    }
}
