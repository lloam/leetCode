package com.mao.剑指offer30包含min函数的栈;

import java.util.Stack;

/**
 * Author: Administrator
 * Date: 2021/7/3 15:25
 * Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
class MinStack {

    // 将元素存于两个栈中
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * stack1 用于存储全部元素
     * stack2 用于存储最小的元素
     * @param x
     */
    public void push(int x) {
        stack1.add(x);
        if(stack2.empty() || stack2.peek() >= x){
            stack2.add(x);
        }
    }

    /**
     * 如果stack1 的栈顶等于 stack2 的栈顶，则 stack2 也要出栈
     */
    public void pop() {
        if (stack1.pop().equals(stack2.peek())){
            stack2.pop();
        }
    }

    /**
     * 直接返回 stack1 的栈顶元素
     * @return
     */
    public int top() {
        return stack1.peek();
    }

    /**
     * 直接返回 stack2 的栈顶元素
     * @return
     */
    public int min() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */