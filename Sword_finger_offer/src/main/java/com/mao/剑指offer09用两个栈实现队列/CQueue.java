package com.mao.剑指offer09用两个栈实现队列;

import java.awt.print.Pageable;
import java.util.Stack;

/**
 * Author: Administrator
 * Date: 2021/6/3 22:08
 * Description: 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 定义两个栈，一个用于push元素，一个用于pop元素，当添加元素的时候只需要
 * 在stack1里面push元素，当删除元素的时候，只需要先将stack1里面的元素遍历
 * 到stack2中，然后调用stack2的pop方法即可
 */
public class CQueue {
//    Stack<Integer> stack1;
//    Stack<Integer> stack2;
//    public CQueue() {
//        stack1 = new Stack<Integer>();
//        stack2 = new Stack<Integer>();
//    }
//
//    public void appendTail(int value) {
//        stack1.push(value);
//    }
//
//    public int deleteHead() {
//        // 如果stack2里面有元素直接pop
//        if(!stack2.isEmpty()){
//            return stack2.pop();
//        }else {
//            // 如果stack2里面没有元素，而且stack1里面也没有元素，说明队列为空，直接返回-1
//            if(stack1.isEmpty()){
//                return -1;
//            }else {
//                // stack1里面有元素，stack2里面没有元素，将stack1立面元素push到stack2中
//                while (!stack1.isEmpty()) {
//                    stack2.push(stack1.pop());
//                }
//                // pop弹出stack2中的元素
//                return stack2.pop();
//            }
//        }
//    }

    // 用于顺序存储全部元素
    Stack<Integer> stack1;

    // 用于倒序存储全部元素
    Stack<Integer> stack2;

    public CQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * 添加元素
     * 直接在 stack1 中添加元素
     * @param value
     */
    public void appendTail(int value) {
        stack1.add(value);
    }

    /**
     * 删除元素
     * 首先将 stack1 的元素放入 stack2 中
     * 然后删除 stack2 中的第一个元素
     * @return
     */
    public int deleteHead() {

        // 判断 stack2 中是否有元素
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }else {

            // stack1 和 stack2 都为空，返回 -1
            if (stack1.isEmpty()) {
                return -1;
            }

            // stack2 中没有元素
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }

            return stack2.pop();
        }
    }

}
