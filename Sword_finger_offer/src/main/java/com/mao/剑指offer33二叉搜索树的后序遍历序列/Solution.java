package com.mao.剑指offer33二叉搜索树的后序遍历序列;

import java.util.Stack;

/**
 * Author: Administrator
 * Date: 2021/6/7 22:31
 * Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {
//    /**
//     * 首先后序遍历为 左右根 的遍历方式，也就是说最后一个一定为树的根节点
//     * @param postorder
//     * @return
//     */
//    public boolean verifyPostorder(int[] postorder){
//        return recur(postorder,0,postorder.length-1);
//    }
//
//    /**
//     * 递归判断左右该树是否是后序遍历
//     * 后序遍历左子树所有节点值都比根节点值小
//     * 所有右子树节点值都比根节点值大
//     * @param postorder
//     * @param i
//     * @param j
//     * @return
//     */
//    private boolean recur(int[] postorder, int i, int j) {
//        // 如果树为空也算二叉搜索树
//        if(i >= j){
//            return true;
//        }
//        /**
//         * i为左子树第一个节点
//         */
//        int p = i;
//        /**
//         * 从第一个数开始遍历，找出第一个比根节点大的值
//         * 这样前面的是左子树，后面的右子树
//         */
//        while (postorder[p] < postorder[j]) p++;
//        // 当程序退出 while 循环的时候，p值就是第一个右子树的节点
//        /**
//         * p/m 为右子树的第一个节点
//         */
//        int m = p;
//        while (postorder[p] > postorder[j]) p++;
//        // 此时 p 就是根节点的下标
//        /**
//         * 递归
//         * 继续遍历左右子树，只有左右子树都是二叉线索树，那才是二叉搜索树
//         */
//        return p == j && recur(postorder,i,m - 1) && recur(postorder,m,j-1);
//    }

    /****************************辅助单调栈******************************/
    /**
     * 辅助单调栈
     * 将后续遍历倒转过来，也就是 根 右 左
     * 那么就是                 中 大 小
     * 我们可以采用单调栈，只要遍历的数比前一个大，那他一定就是一个右节点，
     * 第一个数一定是根节点，那么就能遍历出右边的一条链，当遇到第一个比前一个数小的数时，
     * 此时就是要将这个左节点的兄弟与父节点都出栈，因为这个节点是三个节点中最小的，
     * 所以就能将与这个节点相关的所有节点判断完毕，假设在此期间左节点进栈的时候大于了此时
     * 的root父节点，那么就不是二叉搜索树
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder){
        Stack<Integer> stack = new Stack();
        // 先将所有节点都定义为 int 类型最大值的左节点
        int root = Integer.MAX_VALUE;
        // 倒序遍历
        for (int i = postorder.length - 1; i >= 0; i--){
            // 此时不会有一个 左节点 存在于栈中（相对来说）
            if(postorder[i] > root) return false;
            // 如果遇到一个比栈顶元素小的元素，那么就是某个的左节点，需要将与这个左节点相关的节点都移除栈,也就是说栈一定要递增,找出这个节点的父节点
            while (!stack.isEmpty() && stack.peek() > postorder[i]){
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }


}
