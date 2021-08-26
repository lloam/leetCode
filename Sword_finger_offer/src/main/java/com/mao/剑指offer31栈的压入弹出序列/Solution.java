package com.mao.剑指offer31栈的压入弹出序列;

import java.util.Stack;

/**
 * Author: Administrator
 * Date: 2021/7/6 15:39
 * Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     * 可以用一个辅助栈，模拟进栈操作
//     * 但每次进栈都用 while 循环看栈顶元素是否是弹栈元素，若是则弹出
//     * @param pushed
//     * @param popped
//     * @return
//     */
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack = new Stack<>();
//        // 记录需要弹栈的序号
//        int i = 0;
//        for (int push : pushed) {
//            stack.add(push);
//            while (!stack.isEmpty() && stack.peek().equals(popped[i])) {
//                stack.pop();
//                i++;
//            }
//        }
//        // 到这里 stack 为空则说明是弹出序列
////        if(stack.isEmpty()) return true;
////        else return false;
//        return stack.isEmpty();
//    }


    /**
     * 使用一个辅助栈模拟进栈操作
     * 每次进栈都判断当前栈顶元素是否是弹栈元素
     * @param pushed    压栈序列
     * @param popped    弹栈序列
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        // 辅助栈，模拟进栈操作
        Stack<Integer> stack = new Stack<>();

        // 弹栈序列的下标
        int i = 0;

        // 循环进栈
        for (int push : pushed) {

            // 入栈
            stack.add(push);

            // 循环判断当前栈顶元素是否是需要弹栈的元素
            while (!stack.isEmpty() && stack.peek().equals(popped[i])) {

                // 是，弹出栈顶元素
                stack.pop();

                // 下标进 1
                i++;

            }

        }

        // 如果辅助栈为空说明全部弹栈成功
        return stack.isEmpty();
    }
}
