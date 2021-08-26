package com.mao.剑指offer59II队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Administrator
 * Date: 2021/7/10 16:31
 * Description: 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxQueue {

    /**
     * 使用双端队列，如果使用栈的话，假设弹出了一个最大值之后，那么不知道下一个最大值是哪个
     * 所以使用双端队列为辅助队列
     * 保持双端队列为递减序列
     * 每当 push 值得时候先判断是否大于双端队列的队尾元素的值
     * 如果大于的话就要先将小于 push 的值全部 remove，再进行 push
     */
    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    /**
     * 直接返回双端队列的队首元素
     * @return
     */
    public int max_value() {
        if(deque.isEmpty()) return -1;
        return deque.peekFirst();
    }

    /**
     * 先在对队列中添加，然后在双端队列中添加
     * @param value
     */
    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        queue.offer(value);
        deque.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        Integer pop = queue.poll();
        if (pop.equals(deque.peekFirst())) return deque.pollFirst();
        return pop;
    }
}
