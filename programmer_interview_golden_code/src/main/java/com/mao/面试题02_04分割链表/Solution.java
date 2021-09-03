package com.mao.面试题02_04分割链表;

import com.mao.ListNode;

/**
 * Author: lloam
 * Date: 2021/9/3 21:16
 * Description: 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 维护两个链表
     * 一个节点值均小于 x
     * 一个节点值均大于 x
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;

        ListNode left = new ListNode(-1);

        ListNode leftHead = left;

        ListNode right = new ListNode(-1);

        ListNode rightHead = right;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            }else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        // 需要将尾节点置为 null，否则会出现循环链表
        right.next = null;
        left.next = rightHead.next;

        return leftHead.next;
    }

}
