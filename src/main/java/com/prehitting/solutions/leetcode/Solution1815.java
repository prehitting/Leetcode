package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Answer;
import com.prehitting.annotation.Question;
import com.prehitting.annotation.UnResolved;
import com.prehitting.enums.Level;
import com.prehitting.enums.Version;

/**
 * @ClassName Solution1815
 * @Description 有一个甜甜圈商店，每批次都烤 batchSize 个甜甜圈。这个店铺有个规则，就是在烤一批新的甜甜圈时，
 * 之前 所有 甜甜圈都必须已经全部销售完毕。给你一个整数 batchSize 和一个整数数组 groups ，数组中的每个整数都代表一批前来购买甜甜圈的顾客，
 * 其中 groups[i] 表示这一批顾客的人数。每一位顾客都恰好只要一个甜甜圈。
 * 当有一批顾客来到商店时，他们所有人都必须在下一批顾客来之前购买完甜甜圈。如果一批顾客中第一位顾客得到的甜甜圈不是上一组剩下的，那么这一组人都会很开心。
 * 你可以随意安排每批顾客到来的顺序。请你返回在此前提下，最多 有多少组人会感到开心。
 * @Author 24809
 * @Date 2023-01-22 21:48
 */
@Question(title = "得到新鲜甜甜圈的最多组数", level = Level.HARD)
@UnResolved
public class Solution1815 {

    private int batchSize;

    @Answer(version = Version.First)
    public int maxHappyGroups(int batchSize, int[] groups) {
        int len = groups.length;
        int[] cnt = new int[batchSize + 1];
        for (int group : groups) {
            cnt[group % batchSize]++;
        }
        int res = cnt[0];

        return res;
    }

    private int neutralize(int[] cnt, int size) {
        return 0;
    }

}
