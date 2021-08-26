package com.mao.剑指offer52;

import java.util.Objects;

/**
 * Author: Administrator
 * Date: 2021/5/30 22:34
 * Description: 节点
 */
// Definition for singly-linked list.
public class ListNode {
     public int val;
    public ListNode next;
     public ListNode(int x) {
         val = x;
         next = null;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode node = (ListNode) o;
        return val == node.val &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return  + val +
                ", " + next;
    }
}
