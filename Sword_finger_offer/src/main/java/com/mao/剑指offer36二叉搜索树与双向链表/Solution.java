package com.mao.剑指offer36二叉搜索树与双向链表;

/**
 * Author: Administrator
 * Date: 2021/7/5 22:18
 * Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Solution {

    // 指定头节点与最后一个节点
    Node head, pre;
//    /**
//     * 中序遍历
//     * @param root
//     * @return
//     */
//    public Node treeToDoublyList(Node root) {
//        if (root == null) return null;
//        dfs(root);
//        // 遍历完成之后在将首位节点的前驱和后继指明
//        head.left = pre;
//        pre.right = head;
//        return head;
//    }
//
//    /**
//     * 中序遍历，每次遍历都为遍历的节点指向下一个与上一个
//     * @param cur
//     */
//    private void dfs(Node cur) {
//        if (cur == null) return;
//        // 先遍历左节点
//        dfs(cur.left);
//        // pre 为 null ，说明遍历的是头节点
//        if (pre == null) head = cur;
//        else pre.right = cur;
//        cur.left = pre;
//        pre = cur;
//        // 遍历右节点
//        dfs(cur.right);
//    }

    /**
     * 中序遍历出来的序列是有序的
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {

        if (root == null) return null;

        dfs(root);

        head.left = pre;
        pre.right = head;

        return head;
    }

    /**
     * 中序遍历
     * 每次遍历都将当前节点的左节点指向尾节点 pre
     * 尾节点的 right 指向 cur
     * @param cur
     */
    private void dfs(Node cur) {

        // 递归结束条件
        if (cur == null) return;

        // 先遍历左节点
        dfs(cur.left);

        // 再遍历当前节点，也就是父节点
        if (pre == null) head = cur;
        else pre.right = cur;

        cur.left = pre;

        // 将当前节点设为尾节点
        pre = cur;

        // 遍历右节点
        dfs(cur.right);
    }
}
