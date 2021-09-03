package com.mao.面试题02_05链表求和;

import com.mao.ListNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Author: lloam
 * Date: 2021/9/3 21:46
 * Description: 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。  编写函数对这两个整数求和，并
 * 用链表形式返回结果。
 */
public class Solution {

//    /**
//     * 遍历 l1 和 l2
//     * 然后获取相加后的数，如果是个位数则直接加入
//     * 如果是十位数就要获取进位数，方便下一次遍历进位
//     * @param l1
//     * @param l2
//     * @return
//     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        // 需要遍历添加的节点
//        ListNode cur = new ListNode(0);
//
//        // 保存引用
//        ListNode res = cur;
//
//        // 保存进位数
//        int carry = 0;
//
//        // 保存每一次相加的和
//        int sum = 0;
//
//        while (l1 != null || l2 != null || carry != 0) {
//
//            // 获取相加的和
//            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
//
//            // 获取进位数
//            carry = sum / 10;
//
//            // 添加节点
//            cur.next = new ListNode(sum % 10);
//
//            cur = cur.next;
//
//            // 如果 l1 已经是 null 了，就保存 l1 是 null
//            l1 = l1 != null ? l1.next : l1;
//            l2 = l2 != null ? l2.next : l2;
//        }
//
//        return res.next;
//    }

    /**
     * 递归实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);

        recur(l1, l2, res, 0, 0);

        return res.next;
    }

    /**
     * 递归代替循环
     * @param l1
     * @param l2
     * @param res
     * @param carry     每次相加的进位数
     * @param sum       每次相加之后的个位数
     */
    private void recur(ListNode l1, ListNode l2, ListNode res, int carry, int sum) {

        if (l1 == null && l2 == null && carry == 0) return;

        sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;

        // 获取进位数
        carry = sum / 10;

        // 添加节点
        res.next = new ListNode(sum % 10);

        res = res.next;

        // 如果 l1 已经是 null 了，就保存 l1 是 null
        l1 = l1 != null ? l1.next : l1;
        l2 = l2 != null ? l2.next : l2;

        recur(l1, l2, res, carry, sum);
    }
}
