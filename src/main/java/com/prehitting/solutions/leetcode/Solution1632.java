package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Question;
import com.prehitting.annotation.UnResolved;
import com.prehitting.enums.Level;

/**
 * @ClassName Solution1632
 * @Description
 * @Author 24809
 * @Date 2023-01-25 23:25
 */
@Question(title = "矩阵转换后的秩", level = Level.HARD)
@UnResolved
public class Solution1632 {

    private int[][] matrix;

    private int m, n;


    public int[][] matrixRankTransform(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        int[][] res = new int[m][n];

        return res;
    }
}
