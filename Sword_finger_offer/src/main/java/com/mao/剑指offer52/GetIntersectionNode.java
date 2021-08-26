package com.mao.剑指offer52;

/**
 * Author: Administrator
 * Date: 2021/5/30 22:33
 * Description: 剑指offer52
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(8);
        ListNode headB = new ListNode(4);
        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node2.next = headA;
        headB.next = node2;
        ListNode res = getIntersectionNode(headA, headB);
        System.out.println(res);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB){
            if(nodeA != null){
                nodeA = nodeA.next;
            }else {
                nodeA = headB;
            }
            if(nodeB != null){
                nodeB = nodeB.next;
            }else {
                nodeB = headA;
            }
        }
        return nodeA;
    }
}
