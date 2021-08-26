package com.mao.面试题08_10颜色填充;

/**
 * Author: 但愿人长久
 * Date: 2021/8/26 10:44
 * Description: 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。
 * 需要填充的新颜色为 newColor 。  「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。  来
 * 源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/color-fill-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 深度遍历
     * @param image     待填充的图像
     * @param sr        元素初始颜色横坐标
     * @param sc        元素出事颜色纵坐标
     * @param newColor  新颜色
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // 如果颜色值不变，直接返回原图像
        if (image[sr][sc] == newColor) return image;

        // 递归深度填充
        dfs(image, sr, sc, newColor, image[sr][sc]);

        return image;
    }

    /**
     *
     * @param image     待填充图像
     * @param sr        待填充颜色格子行坐标
     * @param sc        待填充颜色各种列坐标
     * @param newColor  新颜色
     * @param oldColor  旧颜色，也就初始颜色
     */
    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {

        // 先排除越界和相应格子不是旧颜色的情况
        if (sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length - 1 || image[sr][sc] != oldColor) return;

        // 接着将该格子的颜色变为新颜色
        image[sr][sc] = newColor;

        // 递归深度填充该格子的周边格子
        dfs(image, sr - 1, sc, newColor, oldColor);
        dfs(image, sr + 1, sc, newColor, oldColor);
        dfs(image, sr, sc - 1, newColor, oldColor);
        dfs(image, sr, sc + 1, newColor, oldColor);
    }
}
