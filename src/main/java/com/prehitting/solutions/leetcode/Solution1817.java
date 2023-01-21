package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Answer;
import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Type;
import com.prehitting.enums.Version;

import java.util.*;

/**
 * 给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，其中每个 logs[i] = [IDi, timei]
 * 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。
 * 多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。
 * 指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。
 * 即使一分钟内执行多个操作，也只能按一分钟计数。
 * 请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，对于每个 j（1 <= j <=
 * k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。
 * 返回上面描述的答案数组 answer 。
 */
@Question(title = "查找用户活跃分钟数", tags = {Type.Hash}, level = Level.MEDIUM)
public class Solution1817 {

    @Answer(version = Version.Only)
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int uid = log[0], time = log[1];
            Set<Integer> set;
            if (!map.containsKey(uid)) {
                map.put(uid, new HashSet<>());
            }
            set = map.get(uid);
            set.add(time);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int cnt = entry.getValue().size();
            if (cnt > 0) {
                res[cnt - 1]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = findingUsersActiveMinutes(new int[][]{
                {0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}
        }, 5);
        System.out.println(Arrays.toString(res));
    }

}
