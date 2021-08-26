package com.mao.面试题02_06回文链表;

import com.mao.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 但愿人长久
 * Date: 2021/8/13 17:24
 * Description: 编写一个函数，检查输入的链表是否是回文的。
 */
public class Solution {

//    /**
//     * 使用集合来存储链表元素
//     * @param head
//     * @return
//     */
//    public boolean isPalindrome(ListNode head) {
//
//        // 存储链表元素
//        List<Integer> list = new ArrayList<>();
//
//        // 将链表元素存入集合
//        while (head != null) {
//
//            list.add(head.val);
//            head = head.next;
//
//        }
//
//        // 双指针
//        int front = 0, end = list.size() - 1;
//
//        while (front < end) {
//
//            // 判断是否相等，不相等就不是回文，返回 false
//            if (!list.get(front).equals(list.get(end))) return false;
//            front++;
//            end--;
//
//        }
//
//        return true;
//    }

//    ListNode frontNode;
//
//    /**
//     * 递归
//     * @param head  头节点
//     * @return
//     */
//    public boolean isPalindrome(ListNode head) {
//        frontNode = head;
//        return recur(head);
//    }
//
//    /**
//     *
//     * @param node  递归节点
//     * @return
//     */
//    private boolean recur(ListNode node) {
//
//        if (node != null) {
//
//            if (!recur(node.next)) return false;
//
//            if (node.val != frontNode.val) return false;
//
//            frontNode = frontNode.next;
//
//        }
//
//        return true;
//    }

    /**
     * 快慢指针
     * 将链表分为两段，然后第二段反转链表一下
     * 然后就可以开始快慢循环了
     * @param head  头节点
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        // 得到链表的第一段的最后一个节点
        ListNode firstHalfEnd = endOfFirstHalf(head);

        // 得到链表第二段的第一个节点，也就是将第二段反转之后的第一个节点
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode node1 = head;
        ListNode node2 = secondHalfStart;

        // 遍历两个节点，如果是回文链表，这两个节点应该是一样的
        boolean result = true;
        while (result && node2 != null) {

            // 如果节点值不相等就返回 false
            if (node1.val != node2.val) result = false;

            node1 = node1.next;
            node2 = node2.next;

        }

        // 还原链表
        firstHalfEnd.next = reverseList(secondHalfStart);

        return result;
    }

    /**
     * 反转链表
     * @param head  头节点
     * @return
     */
    private ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        // 临时存储的变量节点
        ListNode temp;

        while (cur != null) {
            // 先将下一个节点存起来
            temp = cur.next;

            // 下一个节点等于上一个节点，达到反转的效果
            cur.next = pre;

            // 上一个节点等于当前结点
            pre = cur;

            // 遍历下一个节点
            cur = temp;
        }

        // 返回反转后的头节点
        return pre;
    }

    /**
     * 得到链表的第一段的最后一个节点
     * @param head  头节点
     * @return
     */
    private ListNode endOfFirstHalf(ListNode head) {

        // 快慢指针
        ListNode fast = head;
        ListNode low = head;

        // 快指针一次跳两个节点、慢指针一次跳一个节点
        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;

            low = low.next;

        }

        // 这样返回的慢节点就是第一段的最后一个节点
        return low;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        head.next = new ListNode(0);

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
    }


}
