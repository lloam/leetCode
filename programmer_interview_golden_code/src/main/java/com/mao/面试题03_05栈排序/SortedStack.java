package com.mao.面试题03_05栈排序;

import javax.imageio.stream.IIOByteBuffer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Author: lloam
 * Date: 2021/9/4 22:12
 * Description: 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
 * 但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。
 * 当栈为空时，peek 返回 -1。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedStack {

//    Stack<Integer> stack1;
//    Stack<Integer> stack2;
//
//    public SortedStack() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//    }
//
//    /**
//     * 第一种是每次将栈顶小于 val 的值都弹出 push 到 辅助栈，完事后在放回去
//     * @param val
//     */
//    public void push(int val) {
//        while (!stack1.isEmpty() && stack1.peek() < val) {
//            stack2.push(stack1.pop());
//        }
//        stack1.push(val);
//        while (!stack2.isEmpty()) {
//            stack1.push(stack2.pop());
//        }
//    }
//
//    public void pop() {
//        if (!stack1.isEmpty()) {
//            stack1.pop();
//        }
//    }
//
//    public int peek() {
//        if (!stack1.isEmpty()) {
//            return stack1.peek();
//        }else {
//            return -1;
//        }
//    }
//
//    public boolean isEmpty() {
//        return stack1.isEmpty();
//    }

    Deque<Integer> deque1;
    Deque<Integer> deque2;

    public SortedStack() {
        deque1 = new LinkedList<>();
        deque2 = new LinkedList<>();
    }

    /**
     * 第二种就是使用队列实现栈，每次 push 的时候先将 stack1 中的全部 < val 的值都 push 到 stack2，
     * 然后将 stack2 中的全部 > val 的值都 push 到 stack1
     * 这样 stack1 中全部都是大于 val 的元素，stack2 中全部都是 小于 val 的元素
     * @param val
     */
    public void push(int val) {
        while (!deque1.isEmpty() && deque1.peek() < val) {
            deque2.push(deque1.pop());
        }

        while (!deque2.isEmpty() && deque2.peek() > val) {
            deque1.push(deque2.pop());
        }

        // 最后将 val 添加进 deque1
        deque1.push(val);
    }

    public void pop() {
        // 先将 deque2 中的元素都弹到 deque1
        while (!deque2.isEmpty()) {
            deque1.push(deque2.pop());
        }
        if (!deque1.isEmpty()) {
            deque1.pop();
        }
    }

    public int peek() {
        // 先将 deque2 中的元素都弹到 deque1
        while (!deque2.isEmpty()) {
            deque1.push(deque2.pop());
        }

        if (!deque1.isEmpty()) {
            return deque1.peek();
        }else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return deque1.isEmpty() && deque2.isEmpty();
    }
}
