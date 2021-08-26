package com.mao.剑指offer26树的子结构;


import com.mao.剑指offer55二叉树的深度.TreeNode;

/**
 * Author: Administrator
 * Date: 2021/6/10 21:58
 * Description: 输入两棵二叉树A和B，判断B是不是A的子结构。
 * (约定空树不是任意一个树的子结构)  B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Solution {
//    public boolean isSubStructure(TreeNode A, TreeNode B){
//        return (A != null && B != null) && (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
//    }
//
//    /**
//     * 递归遍历 a 中是否包含 b 树的结构
//     * @param a
//     * @param b
//     * @return
//     */
//    private boolean recur(TreeNode a, TreeNode b) {
//        // 如果 b 树遍历完成，说明 a 树含有 b 树结构
//        if(b == null) return true;
//        // 如果 a 树先遍历完，说明 a 树的节点数比 b 树少，那 a 树肯定不含有 b 结构
//        if(a == null) return false;
//        // 执行到这里，说明 a 树和 b 树都还有节点，而且 a 树的父节点都与 b 树的父节点相等
//        // 递归遍历
//        return (a.val == b.val) && recur(a.left,b.left) && recur(a.right,b.right);
//    }


    /**
     * 这个方法用于判断 A 中是否含有 B 结构树
     * 则 A 的左子树或者右子树必须有一个是含有 B 结构树
     * @param A 父结构
     * @param B 子结构
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 判断是否包含树主要在这个方法
     * 要么 b 树遍历完，a 树还没有遍历完，则返回 true
     * 要么 b 树遍历完，a 树同时遍历完，则返回 true
     * 要么 a 树遍历完，b 树还没有遍历完，则返回 false
     * @param a
     * @param b
     * @return
     */
    private boolean recur(TreeNode a, TreeNode b) {

        // b 树先为 null
        if (b == null) return true;

        // a 树先为 null，b 树不为 null
        if (a == null) return false;

        // 递归遍历，到这里说明 a， b 节点值相等，查看 a b 的左右子树是否相等
        return a.val == b.val && recur(a.left, b.left) && recur(a.right, b.right);
    }
}
