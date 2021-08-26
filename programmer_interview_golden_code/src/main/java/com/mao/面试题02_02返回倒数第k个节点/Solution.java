package com.mao.面试题02_02返回倒数第k个节点;

import com.mao.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: 但愿人长久
 * Date: 2021/8/9 22:26
 * Description: 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。  注意：本题相对原题稍作改动
 */
public class Solution {

//    /**
//     * 使用栈存储遍历单向链表
//     * @param head  头节点
//     * @param k     倒数第 k 个节点
//     * @return
//     */
//    public int kthToLast(ListNode head, int k) {
//
//        // 用于存储遍历的单向链表的值
//        Stack<Integer> stack = new Stack<>();
//
//        // 遍历单向链表
//        while (head != null) {
//            stack.add(head.val);
//            head = head.next;
//        }
//
//        // 循环弹出队列的值
//        for (int i = 0; i < k-1; i++) {
//            stack.pop();
//        }
//        return stack.pop();
//    }

    /**
     * 快慢指针
     * j 指针先走 k 步
     * 然后一起走直至 j 走过头
     * @param head  头节点
     * @param k     倒数第 k 个节点
     * @return
     */
    public int kthToLast(ListNode head, int k) {

        // pre：慢指针；cur：快指针
        ListNode pre = head, cur = head;

        // 让快指针先走 k 步
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        // 两个指针一起走
        while (cur != null) {

            cur = cur.next;

            pre = pre.next;
        }

        return pre.val;
    }
}
