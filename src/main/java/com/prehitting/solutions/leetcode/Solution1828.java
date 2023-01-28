package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Answer;
import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Type;
import com.prehitting.enums.Version;

/**
 * @ClassName Solution1828
 * @Description 给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。
 * 多个点可能会有 相同 的坐标。  同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，
 * 表示一个圆心在 (xj, yj) 且半径为 rj 的圆。  对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。
 * 如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。  请你返回一个数组 answer ，
 * 其中 answer[j]是第 j 个查询的答案。
 * @Author 24809
 * @Date 2023-01-24 00:06
 */
@Question(title = "统计一个圆中点的数目", level = Level.MEDIUM)
public class Solution1828 {

    /**
     * @param points  点阵
     * @param queries [?][3] 以[index][0],[index][1]为圆心，[index][2]为半径的圆
     * @return 圆中有几个点
     */
    @Answer(version = Version.First, type = Type.Mock, desc = "首先暴力算法")
    public int[] countPoints(int[][] points, int[][] queries) {
        final int len = queries.length;
        final int[] res = new int[len];
        for (int index = 0; index < len; index++) {
            int x = queries[index][0], y = queries[index][1], r = queries[index][2];
            int cnt = 0;
            for (int i = 0; i < points.length; i++) {
                if (getSquareDistance(x, y, points[i]) <= doubleInt(r)) {
                    cnt++;
                }
            }
            res[index] = cnt;
        }
        return res;
    }


    private int getSquareDistance(int x, int y, int[] point) {
        return doubleInt(point[0] - x) + doubleInt(point[1] - y);
    }

    private int doubleInt(int x) {
        return x * x;
    }
}
