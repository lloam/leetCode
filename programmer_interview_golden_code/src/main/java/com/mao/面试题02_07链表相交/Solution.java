package com.mao.面试题02_07链表相交;

import com.mao.ListNode;

/**
 * Author: 但愿人长久
 * Date: 2021/8/16 8:23
 * Description: 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class Solution {

    /**
     * 双指针 A，B，设公共节点有 x 个，headA 有 m 个，headB 有 n 个节点
     * A 先遍历 headA，再遍历 headB，当走到 m + n - x 个节点时，刚好走到 公共节点
     * B 先遍历 headB，再遍历 headA，当走到 m + n - x 个节点时，刚好走到 公共节点
     * @param headA A 链表
     * @param headB B 链表
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 不能改变原链表，所以采用中间节点
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        // 循环，当 nodeA == nodeB 时，退出循环
        while (nodeA != nodeB) {

            // 如果 nodeA != null
            if (nodeA != null) {

                // 遍历下一个节点
                nodeA = nodeA.next;

            }else {

                // 当 nodeA == null时，说明 headA 已经遍历完成，开始遍历 headB
                nodeA = headB;
            }


            // nodeB 与 nodeA 同样的道理
            if (nodeB != null) {

                nodeB = nodeB.next;

            }else {

                nodeB = headA;

            }

        }

        // 最终返回 nodeA
        return nodeA;
    }
}
