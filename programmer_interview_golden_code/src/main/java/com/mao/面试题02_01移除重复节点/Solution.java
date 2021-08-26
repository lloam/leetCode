package com.mao.面试题02_01移除重复节点;


import com.mao.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: 但愿人长久
 * Date: 2021/8/9 21:45
 * Description: 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class Solution {

    /**
     * 使用 set 集合存储已经存在的节点
     * 如果存在就遍历下一个节点
     * 不存在就存储进 set 集合，并且当前节点的下一个节点就是这个遍历节点
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {

        if (head == null) return head;

        // 用于存储链表中不重复的值
        Set<Integer> set = new HashSet<>();

        // 先将头节点的值存入
        set.add(head.val);

        // 上一个节点
        ListNode pre = head;

        // 循环，当前节点不为空
        while (pre.next != null) {

            // 如果集合包含这个节点值，说明是重复出现的节点
            if (set.contains(pre.next.val)) {

                // 上一个节点不用动，只需改变下一个节点
                pre.next = pre.next.next;
            }else {
                // 如果不包含这个节点值，说明还未出现这个节点，一切照常，遍历下一个节点
                set.add(pre.next.val);

                // 使得上一个节点 = 当前节点
                pre = pre.next;
            }
        }
        return head;
    }
//
//    /**
//     * 以时间换空间，双重循环，不使用哈希表
//     * 不建议
//     * @param head
//     * @return
//     */
//    public ListNode removeDuplicateNodes(ListNode head) {
//
//        ListNode ob = head;
//
//        // 第一重遍历
//        while (ob != null) {
//
//            // 记录当前遍历节点值
//            ListNode cur = ob;
//
//            // 第二重遍历
//            while (cur.next != null) {
//
//                // 如果第二重遍历当前节点的下一个节点值 == 第一重遍历节点值
//                if (cur.next.val == ob.val) {
//                    cur.next = cur.next.next;
//                }else {
//                    cur = cur.next;
//                }
//            }
//            ob = ob.next;
//        }
//        return head;
//    }
}
