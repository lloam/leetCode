package com.mao.剑指offer24反转链表;

import com.mao.剑指offer52.ListNode;

/**
 * Author: Administrator
 * Date: 2021/7/2 23:26
 * Description: 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Solution {

//    /**
//     * 双指针，一个指向前一个，一个指向后一个
//     * 定义一个伪链表头为 null cur
//     * 依次遍历链表，让节点的下一个节点成为 cur
//     * @param head
//     * @return
//     */
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null){
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    /**
     * 使用前后指针
     * 使用 pre 存储上一个遍历的节点
     * 当前遍历节点的下一个节点是上一个遍历的节点 pre
     * @param head  头节点
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null, cur = head, temp;

        while (cur != null) {

            temp  = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }

        return pre;
    }
}
