package com.mao.面试题02_08环路检测;

import com.mao.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: lloam
 * Date: 2021/9/3 22:23
 * Description: 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，
 * 请返回 null。  如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 使用额外的存储空间的话，可以使用hashmap
//     * @param head
//     * @return
//     */
//    public ListNode detectCycle(ListNode head) {
//
//        if (head == null || head.next == null) return null;
//
//        Set<ListNode> set = new HashSet<>();
//
//        while (head != null) {
//            if (set.contains(head)) return head;
//
//            set.add(head);
//
//            head = head.next;
//        }
//
//        return null;
//    }

    /**
     * 快慢指针，具体看题解
     * fast 指针走两格，slow 指针走一格
     * 当 fast 与 slow 相遇时满足 a = c + (n - 1)(b + c)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode fast = head, slow = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }else {
                return null;
            }

            if (fast == slow) {
                ListNode ple = head;
                while (ple != slow) {
                    ple = ple.next;
                    slow = slow.next;
                }
                return ple;
            }
        }
        return null;
    }
}
