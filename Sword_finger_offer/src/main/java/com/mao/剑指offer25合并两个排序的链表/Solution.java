package com.mao.剑指offer25合并两个排序的链表;

import com.mao.剑指offer52.ListNode;

import java.awt.print.Pageable;

/**
 * Author: Administrator
 * Date: 2021/6/29 22:12
 * Description: 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Solution {
//    /**
//     * 定义一个空链表，分别存储节点
//     * @param l1
//     * @param l2
//     * @return
//     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode node = new ListNode(0); ListNode cur = node;
//        int  i = 0,j = 0;
//        while (l1 != null && l2 != null){
//            if(l1.val < l2.val){
//                // 如果 l1 的值更小，那么将 l1 存储到空链表 node 中
//                cur.next = l1;
//                l1 = l1.next;
//            }else {
//                // l2 的值更小，就将 l2 存储到空链表中
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        // 此时可能 l1 或者 l2 还有节点
//        cur.next = l1 != null ? l1 : l2;
//        return node.next;
//    }

    /**
     * 简单点就是遍历两个链表，比较当前遍历的节点值的大小
     * 最后遍历完成有可能有一个链表还有节点，直接赋值
     * @param l1    第一个递增排序的链表
     * @param l2    第二个递增排序的链表
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 要返回的链表的头节点
        ListNode head = new ListNode(0), cur = head;

        // 遍历链表
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                // 如果 l1 链表的节点值更小就将 l1 当前节点赋值给 head 的下一个节点
                cur.next = l1;
                l1 = l1.next;
            }else {
                // 如果 l2 链表的节点值更小
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        // 遍历完成，有可能有一个链表还有节点，直接循环
        cur.next = l1 != null ? l1 : l2;

        // 返回头节点
        return head.next;
    }
}
