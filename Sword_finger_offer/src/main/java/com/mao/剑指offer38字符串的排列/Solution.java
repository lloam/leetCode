package com.mao.剑指offer38字符串的排列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: Administrator
 * Date: 2021/7/6 16:45
 * Description: 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Solution {

    char[] c;
    List<String> res = new ArrayList<>();
    /**
     * 思路就是回溯，具体细节看 k 神
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        // 此时 res 集合就是答案，将其转化为字符串数组
        return res.toArray(new String[res.size()]);
    }

    /**
     * 回溯遍历
     * @param x
     */
    private void dfs(int x) {
        // 递归终止条件
        if(x == c.length) {
            res.add(new String(c));
        }
        // 存放字符数组 c，防止重复出现字符数组，俗称剪枝
        Set<Character> set = new HashSet<>();
        // 遍历
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i,x);           // 将第 i 个字符与第 x 个字符交换
            dfs(x + 1);       // 遍历下一个字符
            swap(i,x);           // 遍历完之后需要恢复原样
        }
    }

    /**
     * 交换两个位置的字符
     * @param i
     * @param x
     */
    private void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }
}
