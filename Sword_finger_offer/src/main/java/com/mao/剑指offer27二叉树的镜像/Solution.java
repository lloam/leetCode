package com.mao.剑指offer27二叉树的镜像;

import com.mao.剑指offer55二叉树的深度.TreeNode;

import java.util.Stack;

/**
 * Author: Administrator
 * Date: 2021/6/19 23:09
 * Description: 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Solution {

    /*******************递归*******************/
//    /**
//     * 关键在于使用递归，首先交换根节点的左右节点
//     * 然后递归交换根节点左右节点的子节点
//     * @param root
//     * @return
//     */
//    public TreeNode mirrorTree(TreeNode root) {
//        if(root == null) return null;
//        // 首先要将根节点的左节点保存起来
//        TreeNode temp = root.left;
//        //  递归交换右节点的左右节点，交换完之后按理说返回的应该是根节点右节点，但因为是镜像，所以要将这个右节点赋值给左节点
//        root.left = mirrorTree(root.right);
//        // 同理，递归交换左节点的左右子节点，赋值给根节点的右节点，但此时需要用temp，因为左节点已经发生改变
//        root.right = mirrorTree(temp);
//        return root;
//    }
//    /*******************辅助栈********************/
//    /**
//     * 运用辅助栈循环交换左右节点，和递归一个道理
//     * @param root
//     * @return
//     */
//    public TreeNode mirrorTree(TreeNode root) {
//        if(root == null) return null;
//        Stack<TreeNode> stack = new Stack<>();
//        // 先将根节点添加到辅助栈中
//        stack.add(root);
//        // 只要栈不为空，就继续遍历
//        while (!stack.isEmpty()){
//            // 先将辅助栈中的第一个元素取出来
//            TreeNode temp = stack.pop();
//            // 然后将取出来的节点的左右子节点添加到辅助栈中，依次交换
//            if(temp.left != null) stack.add(temp.left);
//            if(temp.right != null) stack.add(temp.right);
//            // 依旧是交换节点的左右子节点，首先要将节点的左节点先保存一下
//            TreeNode left = temp.left;
//            temp.left = temp.right;
//            temp.right = left;
//        }
//        // 循环交换结束，返回root
//        return root;
//    }

//    /**
//     * 使用递归遍历
//     * 思想是深度遍历
//     * mirrorTree() 方法返回的节点是镜像
//     * 也就是根节点的左右子节点调换了
//     * 那么其左右字节也需要返回各自的镜像，同样调用这个方法就行了
//     * @param root  根节点
//     * @return
//     */
//    public TreeNode mirrorTree(TreeNode root) {
//
//        if (root == null) return null;
//
//        // 将左子节点存储起来，因为先返回左节点镜像，所以左节点会发生改变
//        TreeNode temp = root.left;
//
//        // 返回右子节点的镜像
//        TreeNode left = mirrorTree(root.right);
//
//        // 返回左子节点的镜像
//        TreeNode right = mirrorTree(temp);
//
//        // 设置左右子节点
//        root.left = left;
//        root.right = right;
//
//        return root;
//    }


    /**
     * 辅助栈
     * 思想与递归一样
     * @param root  根节点
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;

        // 用于存储每一层的节点
        Stack<TreeNode> stack = new Stack<>();

        // 先将根节点入栈
        stack.add(root);

        // 循环
        while (!stack.isEmpty()) {

            // 这一个循环是将某一层的节点遍历，左右节点交换
            for (int i = stack.size(); i > 0; i--) {

                // 获取栈顶节点
                TreeNode node = stack.pop();

                // 将左右子节点入栈
                if (node.left != null) stack.add(node.left);
                if (node.right != null) stack.add(node.right);

                // 交换左右节点
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }

        return root;
    }
}
