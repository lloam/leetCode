package com.mao.面试题03_02栈的最小值;

import java.util.Stack;

/**
 * Author: 但愿人长久
 * Date: 2021/8/16 11:48
 * Description: 请设计一个栈，除了常规栈支持的pop与push函数以外，
 * 还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    // 用于正常存储元素的栈
    Stack<Integer> stack1;

    // 用于存储更小的元素的栈
    Stack<Integer> stack2;

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * 添加元素，直接在 stack1 中添加
     * 要判断 stack2 中的栈顶元素是否比这个添加的元素小
     * @param x 要添加的元素值
     */
    public void push(int x) {
        // 添加元素
        stack1.add(x);

        // 判断辅助栈栈顶元素是否是更小的数
        if (stack2.isEmpty()) {
            stack2.add(x);
        }else {
            if (stack2.peek() >= x) stack2.add(x);
        }
    }

    /**
     * 弹出元素，直接弹出 stack1 中的栈顶元素
     * 判断 stack2 中栈顶元素是否是这个元素
     */
    public void pop() {
        if (stack1.pop().equals(stack2.peek())) stack2.pop();
    }

    /**
     * 获取栈顶元素，直接获取 stack1 中的元素
     * @return
     */
    public int top() {
        return stack1.peek();
    }

    /**
     * 获取最小值，直接获取 stack2 中的栈顶元素
     * @return
     */
    public int getMin() {
        return stack2.peek();
    }
}
