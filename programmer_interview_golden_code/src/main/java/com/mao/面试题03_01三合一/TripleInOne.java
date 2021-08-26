package com.mao.面试题03_01三合一;

/**
 * Author: 但愿人长久
 * Date: 2021/8/16 9:58
 * Description: 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
 * stackNum表示栈下标，value表示压入的值。  构造函数会传入一个stackSize参数，代表每个栈的大小。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TripleInOne {

    int[][] array;
    int stackSize;
    int oneIndex;
    int twoIndex;
    int threeIndex;

    /**
     * 构造函数
     * @param stackSize 每个栈的大小
     */
    public TripleInOne(int stackSize) {
        array = new int[3][stackSize];
        this.stackSize = stackSize;
        this.oneIndex = -1;
        this.twoIndex = -1;
        this.threeIndex = -1;
    }

    /**
     * 压入元素
     * @param stackNum  栈下标，也就是第几个栈
     * @param value     入栈元素值
     */
    public void push(int stackNum, int value) {

        switch (stackNum) {
            case 0:
                if (oneIndex < stackSize - 1) {
                    array[stackNum][++oneIndex] = value;
                }
                break;
            case 1:
                if (twoIndex < stackSize - 1) {
                    array[stackNum][++twoIndex] = value;
                }
                break;
            case 2:
                if (threeIndex < stackSize - 1) {
                    array[stackNum][++threeIndex] = value;
                }
                break;
        }
    }

    /**
     * 弹栈操作
     * @param stackNum  栈下标
     * @return
     */
    public int pop(int stackNum) {

        switch (stackNum) {

            // 第一个栈
            case 0:
                if (isEmpty(stackNum)) {
                    return array[stackNum][oneIndex--];
                }
                break;

            // 第二个栈
            case 1:
                if (twoIndex >= 0) {
                    return array[stackNum][twoIndex--];
                }
                break;

            // 第三个栈
            case 2:
                if (threeIndex >= 0) {
                    return array[stackNum][threeIndex--];
                }
                break;
        }

        // 这个时候还没有返回弹出的值，说明栈为空，返回 -1
        return -1;
    }

    /**
     * 获取栈顶元素，和弹栈操作一样，只不过标记数组下标的值不变
     * @param stackNum  栈下标
     * @return
     */
    public int peek(int stackNum) {

        switch (stackNum) {

            // 第一个栈
            case 0:
                if (oneIndex >= 0) {
                    return array[stackNum][oneIndex];
                }
                break;

            // 第二个栈
            case 1:
                if (twoIndex >= 0) {
                    return array[stackNum][twoIndex];
                }
                break;

            // 第三个栈
            case 2:
                if (threeIndex >= 0) {
                    return array[stackNum][threeIndex];
                }
                break;
        }

        // 这个时候还没有返回弹出的值，说明栈为空，返回 -1
        return -1;
    }

    /**
     * 判断第 stackNum 个栈是否为空
     * @param stackNum  栈下标
     * @return
     */
    public boolean isEmpty(int stackNum) {

        boolean isEmpty;

        switch (stackNum) {

            case 0:
                isEmpty = oneIndex < 0;
                break;
            case 1:
                isEmpty = twoIndex < 0;
                break;
            case 2:
                isEmpty = threeIndex < 0;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + stackNum);
        }
        return isEmpty;
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(1);
        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.pop(0));
        System.out.println(tripleInOne.isEmpty(0));
    }
}
