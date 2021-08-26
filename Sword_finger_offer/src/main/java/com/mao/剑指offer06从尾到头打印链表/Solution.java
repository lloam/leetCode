package com.mao.剑指offer06从尾到头打印链表;

import com.mao.剑指offer52.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: Administrator
 * Date: 2021/6/1 22:09
 * Description: 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 解题思路：利用栈的先进后出的特性，先遍历head将节点存储到stack中，再依次弹栈，存储到数组中
 */
public class Solution {
//    public static void main(String[] args) {
//    }
//
//    public static int[] reversePrint(ListNode head) {
//        // 临时节点
//        ListNode node = head;
//        // 将临时节点存入到栈中
//        Stack<ListNode> stack = new Stack<>();
//        while (node != null){
//            stack.push(node);
//            node = node.next;
//        }
//        int[] prints = new int[stack.size()];
//        for (int i = 0; i < prints.length; i++) {
//            prints[i] = stack.pop().val;
//        }
//        return prints;
//    }

//    /**
//     * 辅助栈
//     * @param head
//     * @return
//     */
//    public static int[] reversePrint(ListNode head) {
//
//        // 辅助栈
//        Stack<Integer> stack = new Stack<>();
//
//        // 遍历链表
//        while (head.next != null) {
//
//            stack.add(head.val);
//
//            head = head.next;
//
//        }
//
//        // 存储结果的数组
//        int[] res = new int[stack.size()];
//
//        // 遍历辅助栈
//        for (int i = 0; i < res.length; i++) {
//
//            res[i] = stack.pop();
//
//        }
//        return res;
//    }

    List<Integer> listNodes = new ArrayList<>();

    /**
     * 递归，回溯
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {

        // 递归将链表节点倒序添加到集合
        recur(head);

        int[] res = new int[listNodes.size()];

        // 遍历出链表
        for (int i = 0; i < res.length; i++) {
            res[i] = listNodes.get(i);
        }

        return res;
    }

    void recur(ListNode node) {

        if (node == null) return;

        recur(node.next);

        listNodes.add(node.val);
    }
}
