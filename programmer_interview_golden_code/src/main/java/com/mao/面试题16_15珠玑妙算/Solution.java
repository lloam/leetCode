package com.mao.面试题16_15珠玑妙算;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: 但愿人长久
 * Date: 2021/8/29 17:49
 * Description: 珠玑妙算游戏（the game of master mind）的玩法如下。
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
 * 例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。
 * 打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
 * 注意，“猜中”不能算入“伪猜中”。  给定一种颜色组合solution和一个猜测guess，
 * 编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/master-mind-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

//    /**
//     *
//     * @param solution  颜色组合
//     * @param guess     猜测颜色
//     * @return
//     */
//    public int[] masterMind(String solution, String guess) {
//
//        int[] res = new int[2];
//
//        char[] guessChar = guess.toCharArray();
//        char[] solutionChar = solution.toCharArray();
//
//        // 计算猜中个数
//        for (int i = 0; i < guessChar.length; i++) {
//            if (guess.charAt(i) == solution.charAt(i)) {
//                res[0]++;
//                guessChar[i] = ' ';
//                solutionChar[i] = ' ';
//            }
//        }
//
//        // 计算为猜中个数
//        for (int i = 0; i < guessChar.length; i++) {
//            if (guessChar[i] != ' ') {
//                for (int j = 0; j < solution.length(); j++) {
//                    if (guessChar[i] == solutionChar[j]) {
//                        guessChar[i] = ' ';
//                        solutionChar[j] = ' ';
//                        res[1]++;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return res;
//    }

    /**
     * 使用 hashMap 存储字符
     * @param solution
     * @param guess
     * @return
     */
    public int[] masterMind(String solution, String guess) {

        Map<Character,Integer> map = new HashMap<>();

        int[] res = new int[2];

        for (char c : solution.toCharArray()) {
            map.put(c,map.getOrDefault(c, 0) + 1);
        }

        // 计算符合的个数（猜中和伪猜中个数）
        for (char c : guess.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                res[1]++;
                map.put(c,map.get(c) - 1);
            }
        }

        // 计算猜中个数
        for (int i = 0; i < guess.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                res[0]++;
            }
        }

        // 计算伪猜中个数
        res[1] = res[1] - res[0];

        return res;
    }
}
