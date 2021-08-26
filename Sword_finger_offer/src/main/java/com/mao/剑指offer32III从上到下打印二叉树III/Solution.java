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
//     * 使用双端队列存储每一层的节点
//     * 每次遍历都是先遍历奇数层，也就是从左到右打印
//     * 接着遍历偶数层，也就是从右到左打印
//     * 如果是奇数层
//     * @param root
//     * @return
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        // 双端队列
//        Deque<TreeNode> deque = new LinkedList();
//
//        // 存储结果
//        List<List<Integer>> res = new ArrayList<>();
//
//        // 如果树是空的，直接返回
//        if (root == null) return res;
//
//        // 先将 root 根节点加入双端队列
//        deque.addFirst(root);
//
//        // 当队列不为空的时候
//        while (!deque.isEmpty()) {
//
//            // 存储每一层节点
//            List<Integer> list = new ArrayList<>();
//
//            // 这里添加元素要区分清楚实在队尾还是队首存储节点
//
//            // 奇数层，从左到右打印
//            for (int i = deque.size(); i > 0; i--) {
//
//                TreeNode node = deque.removeLast();
//
//                list.add(node.val);
//
//                if (node.left != null) deque.addFirst(node.left);
//
//                if (node.right != null) deque.addFirst(node.right);
//
//            }
//
//            res.add(list);
//
//            if (deque.isEmpty()) break;
//
//            list = new ArrayList<>();
//
//            // 偶数层，从右到左打印
//            for (int i = deque.size(); i > 0; i--) {
//
//                TreeNode node = deque.removeFirst();
//
//                list.add(node.val);
//
//                if (node.right != null) deque.addLast(node.right);
//                if (node.left != null) deque.addLast(node.left);
//            }
//
//            res.add(list);
//        }
//
//        // 返回结果
//        return res;
//    }

    /**
     * 上面这种方法难点在于难于区分是在队尾还是队首添加元素，而取元素也要区分清楚
     * 这种方法则是每次只遍历一层节点，区分是奇数层还是偶数层
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        // 使用双端队列存储元素
        Deque<TreeNode> deque = new LinkedList<>();

        // 返回结果
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        deque.addFirst(root);

        LinkedList<Integer> list;

        while (!deque.isEmpty()) {

            list = new LinkedList<>();

            // 如果 res 大小是奇数，说明已经打印好了奇数层，接下来打印偶数层，从右到左

            for (int i = deque.size(); i > 0; i--) {

                TreeNode node = deque.removeLast();

                // 已经打印好了奇数层，打印偶数层，从右到左
                if ((res.size() & 1) == 1) list.addFirst(node.val);
                // 已经打印好了偶数层，打印奇数层，从左到右
                else list.addLast(node.val);

                if (node.left != null) deque.addFirst(node.left);

                if (node.right != null) deque.addFirst(node.right);
            }

            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        List<List<Integer>> res = new Solution().levelOrder(root);

        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }

    }
}
