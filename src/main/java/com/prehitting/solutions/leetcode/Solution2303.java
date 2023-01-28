package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Answer;
import com.prehitting.annotation.Assist;
import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Type;
import com.prehitting.enums.Version;

/**
 * @ClassName Solution2303
 * @Description 给你一个下标从 0 开始的二维整数数组 brackets ，其中 brackets[i] = [upperi, percenti] ，表示第 i 个税级的上限是 upperi ，征收的税率为 percenti 。税级按上限 从低到高排序（在满足 0 < i < brackets.length 的前提下，upperi-1 < upperi）。
 * 税款计算方式如下：
 * 不超过 upper0 的收入按税率 percent0 缴纳
 * 接着 upper1 - upper0 的部分按税率 percent1 缴纳
 * 然后 upper2 - upper1 的部分按税率 percent2 缴纳
 * 以此类推
 * 给你一个整数 income 表示你的总收入。返回你需要缴纳的税款总额。与标准答案误差不超 10-5 的结果将被视作正确答案。
 * @Author 24809
 * @Date 2023-01-23 23:32
 */
@Question(title = "计算应缴税款总额", level = Level.SIMPLE)
public class Solution2303 {

    @Answer(version = Version.Only, desc = "递归", type = Type.Recursion)
    public double calculateTax(int[][] brackets, int income) {
        return get(brackets, income, 0);
    }

    @Assist(version = Version.Only)
    private double get(int[][] brackets, double income, int index) {
        if (index >= brackets.length) {
            return 0.0;
        }
        double upper = brackets[index][0];
        double lastUpper = index == 0 ? 0 : brackets[index - 1][0];

        double percent = brackets[index][1];
        if (brackets[index][0] >= income) {
            return (income - lastUpper) * percent / 100;
        }
        return (upper - lastUpper) * percent / 100 + get(brackets, income, index + 1);
    }

    public static void main(String[] args) {
        Solution2303 solution2303 = new Solution2303();
        System.out.println(solution2303.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
    }
}
