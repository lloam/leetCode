package com.mao.面试题08_06汉诺塔问题;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: 但愿人长久
 * Date: 2021/8/26 10:03
 * Description: 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，
 * 盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。
 * 移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子; (2) 盘子只能从柱子顶端滑出移到下一根柱子; (3) 盘子只能叠在比它大的盘子上。
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。  你需要原地修改栈。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/hanota-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 经典的递归题目
     * 首先要将最底下的盘子移到第三个柱子 C
     * 那么就要先将上面 n - 1 个盘子移到第二个柱子 B
     * 那么这就是递归 hanota，将 n - 1 个盘子移到 B 柱子
     * @param A 第一个盘子
     * @param B 第二个盘子
     * @param C 第三个盘子
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {


//        C.addAll(A);
        recursion(A.size(), A, B, C);
    }

    /**
     * 将 size 个盘子从 A 柱子移动到 C 柱子
     * 中间借助 B 柱子先将 A 上的 n - 1 个盘子移动到 B 柱子
     * @param size  需要移动的盘子个数
     * @param A     原柱子
     * @param B     中间柱子
     * @param C     目标柱子
     */
    private void recursion(int size, List<Integer> A, List<Integer> B, List<Integer> C) {

        // 如果盘子个数 size == 1，直接移动
        if (size == 1) {

            C.add(A.remove(A.size() - 1));

            return;
        }

        // 首先将上面 n - 1 个盘子从 A 柱子移动到 B 柱子，中间借助 C 柱子
        recursion(size - 1, A, C, B);

        System.out.println(A.size());
        // 接着将 A 中最后一个盘子移动到 C 盘子
        C.add(A.remove(A.size() - 1));

        // 然后将 B 柱子中的盘子移动到 C 柱子，中间借助 A 柱子
        recursion(size - 1, B, A, C);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> C = new ArrayList<>();
        new Solution().hanota(A, new ArrayList<>(), C);

        System.out.println(C);
    }
}
