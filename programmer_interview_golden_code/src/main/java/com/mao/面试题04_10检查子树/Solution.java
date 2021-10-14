package com.mao.面试题04_10检查子树;

import com.mao.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lloam
 * Date: 2021/10/14 23:35
 * Description: 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。  如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。  注意：此题相对书上原题略有改动。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/check-subtree-lcci 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     //     * 方法一：递归实现
     //     * @param t1
     //     * @param t2
     //     * @return
     //     */
//    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
//        // 如果 t2 是空树，返回 true
//        if (t2 == null) return true;
//        // t2 不是空树，t1 是空树返回 false
//        if (t1 == null) return false;
//        // 判断 t1、t2 是否是同一棵树，或者 t1 的左右节点是否包含 t2
//        return isSameTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
//    }
//
//    /**
//     * 判断两颗树是否是同一颗
//     * @param treeNode1
//     * @param treeNode2
//     * @return
//     */
//    private boolean isSameTree(TreeNode treeNode1, TreeNode treeNode2) {
//        // 如果地址一样就直接返回 true
//        if (treeNode1 == treeNode2) return true;
//
//        // 如果有一颗树为空，则说明不是同一颗树，返回 false
//        if (treeNode1 == null || treeNode2 == null) return false;
//
//        // 排除以上两种情况，如果节点值相等，就递归判断左右子树是否同一颗
//        return treeNode1.val == treeNode2.val && isSameTree(treeNode1.left, treeNode2.left) && isSameTree(treeNode1.right, treeNode2.right);
//    }

    /**
     *
     * 方法二：先进行先序遍历得到两颗树的先序遍历，在转化为字符串，判断是否包含
     * @param t1
     * @param t2
     * @return
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        List<Integer> t1List = new ArrayList<>();
        List<Integer> t2List = new ArrayList<>();
        preOrder(t1, t1List);
        preOrder(t2, t2List);
        // 将集合转化为字符串
        String t1PreStr = t1List.toString();
        String t2PreStr = t2List.toString();
        // 之所以从 1 开始截取，是因为集合转化为字符串之后会有 [1,2,3]，[
        return t1PreStr.contains(t2PreStr.substring(1, t2PreStr.length()-1));
    }

    /**
     * 得到树的先序遍历
     * @param treeNode
     * @param list
     * @return
     */
    private void preOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            list.add(null);
            return;
        }
        list.add(treeNode.val);
        preOrder(treeNode.left, list);
        preOrder(treeNode.right, list);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        String s1 = list.toString();
        String s2 = list2.toString();
        System.out.println(s1.contains(s2.substring(1,s2.length()-1)));
    }
}
