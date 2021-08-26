package com.mao.剑指offer35复杂链表的复制;

/**
 * Author: Administrator
 * Date: 2021/7/5 20:44
 * Description:
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
