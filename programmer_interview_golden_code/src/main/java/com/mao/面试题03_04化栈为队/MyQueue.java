package com.mao.面试题03_04化栈为队;

import java.util.Stack;

/**
 * Author: 但愿人长久
 * Date: 2021/8/16 12:07
 * Description: 实现一个MyQueue类，该类用两个栈来实现一个队列。
 */
public class MyQueue {

    // 用于存储元素
    Stack<Integer> stack1;

    // 用于弹出元素
    Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        // 只需要在 stack1 中添加即可
        stack1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        // 在 stack2 中弹出栈顶元素
        // 先判断 stack2 是否为空
        if (!stack2.isEmpty()) {

            // stack2 不为空，直接弹出栈顶元素
            return stack2.pop();
        }else {

            // stack2 为空，将 stack1 中的元素遍历添加到 stack2 中再弹出
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }

            // 弹出 stack2 中栈顶元素
            return stack2.pop();
        }
    }

    /** Get the front element. */
    public int peek() {

        // 获取栈顶元素
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }else {

            // stack2 为空
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }

            return stack2.peek();
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        // 两个队列都为空才是空
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
