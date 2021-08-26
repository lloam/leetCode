package com.mao.剑指offer36二叉搜索树与双向链表;

/**
 * Author: Administrator
 * Date: 2021/7/5 22:17
 * Description:
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
