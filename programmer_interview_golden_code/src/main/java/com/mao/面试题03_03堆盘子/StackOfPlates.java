package com.mao.面试题03_03堆盘子;

import java.util.*;

/**
 * Author: lloam
 * Date: 2021/9/4 21:44
 * Description: 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，
 * 我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，
 * 并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同
 * （也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，
 * 执行pop操作。  当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/stack-of-plates-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StackOfPlates {

    List<Stack<Integer>> stacks;
    int cap;

    public StackOfPlates(int cap) {
        this.stacks = new ArrayList<>();
        this.cap = cap;
    }

    public void push(int val) {
        if (cap <= 0) return;

        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == cap) {
            // 如果栈集合为空或者栈集合的最后一个栈的容量满了，就新建一个栈
            Stack<Integer> stack = new Stack<>();
            stack.add(val);
            stacks.add(stack);
            return;
        }

        // 否则就在最后一个栈中添加元素
        stacks.get(stacks.size() - 1).add(val);
        return;
    }

    /**
     * 弹栈
     * @return
     */
    public int pop() {
        // 直接返回最后一个
        return popAt(stacks.size()-1);
    }

    /**
     * 弹出指定序号的栈顶元素
     * @param index
     * @return
     */
    public int popAt(int index) {
        // 不符合情况
        if (index < 0 || index >= stacks.size()) return -1;

        // 获取对应下标的栈
        Stack<Integer> stack = stacks.get(index);

        // 因为我们在后面每次栈为空时就删除了栈，所以不用考虑栈为空的情况
        Integer res = stack.pop();

        // 如果栈为空，删除栈
        if (stack.isEmpty()) stacks.remove(index);

        return res;
    }
}
