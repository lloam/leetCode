package com.mao.剑指offer22链表中倒数第k个节点;

import com.mao.剑指offer52.ListNode;

/**
 * Author: Administrator
 * Date: 2021/7/2 23:21
 * Description: 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 使用双指针，让前一个指针先走 k 步，然后两个指针一起走
//     * @param head
//     * @param k
//     * @return
//     */
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        ListNode front = head, end = head;
//        for(int i = 0; i < k; i++){
//            front = front.next;
//        }
//        // 接着两个指针一起走，知道front为 null
//        while (front != null) {
//            front = front.next;
//            end = end.next;
//        }
//        return end;
//    }

    /**
     * 快慢指针
     * @param head  头节点
     * @param k     倒数第 k 个数
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        // 快慢指针
        ListNode low = head, fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {

            fast = fast.next;
            low = low.next;

        }

        return low;
    }

}
