package com.mao.剑指offer18删除链表的节点;

import com.mao.剑指offer52.ListNode;

/**
 * Author: Administrator
 * Date: 2021/6/13 22:46
 * Description: 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。  注意：此题对比原题有改动
 */
public class Solution {
//    public ListNode deleteNode(ListNode head, int val) {
//        ListNode preNode = findPreNode(head,val);
//        ListNode node = preNode.next;
//        preNode.next = node.next;
//        return head;
//    }
//
//    /**
//     * 先找到目标节点的上一个节点
//     * 递归查找
//     * @param preNode
//     * @param val
//     * @return
//     */
//    private ListNode findPreNode(ListNode preNode, int val) {
//        if(preNode.next == null) return null;
//        if(preNode.next.val == val) return preNode;
//        return findPreNode(preNode.next,val);
//    }

//    /**
//     * 自我解题失败，还是看大佬如何遍历的吧
//     * 其实思想是一样的，只不过不会实现
//     * 就是先找出目标节点，然后目标节点cur的上一个节点pre，令pre.next = cur.next
//     * @param head
//     * @param val
//     * @return
//     */
//    public ListNode deleteNode(ListNode head, int val) {
//        // 首先判断头节点是否是目标节点
//        if(head.val == val) return head.next;
//        ListNode pre = head;
//        ListNode cur = head.next;
//        while (cur != null && cur.val != val){
//            // 如果cur不是目标节点就往下找
//            pre = cur;
//            cur = cur.next;
//        }
//        // 程序运行到这里说明已经找到了目标节点或者是目标节点 == null
//        if(cur != null){
//            pre.next = cur.next;
//        }
//        return head;
//    }


//    /**
//     * 找到要删除的节点的上一个节点 preNode
//     * 使 preNode.next = 要删除节点.next
//     * @param head      头节点
//     * @param val       要删除的节点值
//     * @return
//     */
//    public ListNode deleteNode(ListNode head, int val) {
//
//        if (head == null) return null;
//
//        // 如果头节点就是要删除的节点
//        if (head.val == val) return head.next;
//
//        // 找到要删除节点的上一个节点
//        ListNode preNode = findPreNode(head, val);
//
//        // 如果没有找到上一个节点说明不存在要删除的节点，直接返回头节点
//        if (preNode == null) return head;
//
//        // 获得当前要删除的节点
//        ListNode cur = preNode.next;
//
//        // 使上一个节点的 next = 要删除节点的 next
//        preNode.next = cur.next;
//
//        // 返回头节点
//        return head;
//    }
//
//    /**
//     * 寻找要删除节点的上一个节点
//     * @param node      递归节点
//     * @param val       要删除节点的值
//     * @return
//     */
//    private ListNode findPreNode(ListNode node, int val) {
//
//        if (node.next == null) return null;
//
//        if (node.next.val == val) return node;
//
//        return findPreNode(node.next, val);
//    }

    /**
     * 上面是递归找到上一个节点
     * 这个是循环找到上一个节点
     * @param head  头节点
     * @param val   要删除的节点值
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {

        if (head.val == val) return head.next;

        // cur：要删除的节点
        // preNode：要删除节点的上一个节点
        ListNode cur = head, preNode = head;

        // while 循环遍历
        while (cur != null) {

            if (cur.val == val) {
                break;
            }

            preNode = cur;

            cur = cur.next;
        }

        // 此时 cur 是要删除的节点
        if (cur != null) {
            preNode.next = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(-3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(-99);

        System.out.println(new Solution().deleteNode(head, -3));
    }
}
