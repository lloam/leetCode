package com.mao.剑指offer07重建二叉树;

import com.mao.剑指offer55二叉树的深度.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Administrator
 * Date: 2021/7/4 21:59
 * Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Solution {

//    int[] preorder;
//    Map<Integer,Integer> dic = new HashMap<>();
//    /**
//     * 具体思想看大佬的吧，太多了
//     * 递归遍历
//     * 根据前序遍历找到各个子树的父节点
//     * 根据中序遍历可以知道子树父节点的索引值
//     * 然后就在能根据前序遍历找到父节点
//     * @param preorder
//     * @param inorder
//     * @return
//     */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        this.preorder = preorder;
//        // 将中序遍历存放在 HashMap 中，这样寻找索引的时候时间复杂度就能降为 O(1)
//        for (int i = 0; i < inorder.length; i++) {
//            dic.put(inorder[i],i);
//        }
//        return recur(0,0,inorder.length-1);
//    }
//
//    /**
//     *
//     * @param root  根节点的索引
//     * @param left  左边界
//     * @param right  右边界
//     * @return
//     */
//    private TreeNode recur(int root, int left, int right) {
//        if(left > right) return null;
//        TreeNode node = new TreeNode(preorder[root]);
//        int i = dic.get(preorder[root]);
//        node.left = recur(root + 1,left,i - 1);
//        node.right = recur(i - left + root + 1,i + 1,right);
//        return node;
//    }

    // 将前序遍历变成成员变量，以便于在另一个递归方法中使用
    int[] preorder;

    // 将中序遍历转化成 map 集合，以便每次求索引的时间复杂度为 O(1)
    Map<Integer,Integer> inorderMap = new HashMap<>();


    /**
     * 递归根据前序遍历知道各个子树的根节点
     * 然后根据中序遍历知道根节点在索引
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }

        // 递归返回根节点
        return recur(0,0,inorder.length-1);

    }

    /**
     *
     * @param parent    前序遍历中根节点的索引值
     * @param left      中序遍历中左子树的左边界
     * @param right     中序遍历中右子树的右边界
     * @return
     */
    private TreeNode recur(int parent, int left, int right) {

        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[parent]);

        // 各子树父节点在中序遍历中的索引值
        int i = inorderMap.get(preorder[parent]);

        // 根节点的左子树
        root.left = recur(parent+1, left, i - 1);

        // 根节点的右子树
        root.right = recur(i-left + 1 + parent, i + 1, right);

        return root;
    }
}
