package com.mao.剑指offer35复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Administrator
 * Date: 2021/7/5 20:43
 * Description: 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 这题难点就在于节点的 random 值难以复制
//     * 因为可能在指向 random 的时候那个节点可能还没有创建出来
//     * 所以就可以想想能不能先将全部节点创建出来
//     * 再进行 next random 赋值
//     * @param head
//     * @return
//     */
//    public Node copyRandomList(Node head) {
//        // 使用 HashMap 存储创建的节点
//        Map<Node,Node> map = new HashMap<>();
//        Node cur = head;
//        while (cur != null) {
//            // 存储原节点和新建的节点
//            map.put(cur,new Node(cur.val));
//            cur = cur.next;
//        }
//        // 这里新建点都已经创建出来了，并且存储在 HashMap 中与原节点对应
//        cur = head;
//        // 对新建进行赋值 next random
//        while (cur != null) {
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);
//    }

//    /**
//     * 还有一种想法就是在原节点的下一个节点创建新节点
//     * 然后原节点.next = 原节点.next.next
//     * 原节点.random = 原节点.next.random
//     * @param head
//     * @return
//     */
//    public Node copyRandomList(Node head) {
//        if(head == null) return null;
//        // 先创建出节点
//        Node cur = head;
//        while (cur != null) {
//            Node temp = new Node(cur.val);
//            temp.next = cur.next;
//            cur.next = temp;
//            cur = temp.next;
//        }
//        // 新节点的 random 指向
//        cur = head;
//        while (cur != null) {
//            if(cur.random != null) {
//                cur.next.random = cur.random.next;
//            }
//            cur = cur.next.next;
//        }
//        // 将原链表与新链表分开
//        Node pre = head;
//        cur = pre.next;
//        Node res = cur;
//        while (cur.next != null) {
//            pre.next = cur.next;
//            cur.next = cur.next.next;
//            pre = pre.next;
//            cur = cur.next;
//        }
//        // 还原原节点
//        pre.next = null;
//        return res;
//    }

//    /**
//     *
//     * @param head
//     * @return
//     */
//    public Node copyRandomList(Node head) {
//
//        Node cur = head;
//
//        // 使用 map 集合将各节点点存储起来，并建立新的节点
//        Map<Node,Node> map = new HashMap<Node, Node>();
//
//        while (cur != null) {
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//
//        cur = head;
//
//        while (cur != null) {
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//
//        return map.get(head);
//    }

    /**
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        // 先创建出新的节点，在原节点的下一个节点创建新节点
        Node cur = head;
        Node temp;
        while (cur != null) {
            temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }

        // 然后直接新节点的 random 节点
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 接着分离新链表与旧链表
        Node pre = head;
        cur = pre.next;
        Node res = cur;
        while (cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }

        // 还原链表
        pre.next = null;
        return res;
    }
}
