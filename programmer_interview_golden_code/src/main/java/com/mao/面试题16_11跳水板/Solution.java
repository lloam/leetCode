package com.mao.面试题16_11跳水板;

/**
 * Author: 但愿人长久
 * Date: 2021/8/29 17:02
 * Description: 你正在使用一堆木板建造跳水板。有两种类型的木板，
 * 其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 就是用循环遍历
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {

        int i = 0;

        int[] res;

        if (k == 0) {
            res = new int[0];
            return res;
        }

        if (shorter == longer) {
            res = new int[]{shorter * k};
            return res;
        }

        res = new int[k + 1];

        while (i <= k) {
            res[i] = shorter * (k - i) + longer * (i);
            i++;
        }

        return res;
    }
}
