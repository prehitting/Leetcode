package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Answer;
import com.prehitting.annotation.Assist;
import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Type;
import com.prehitting.enums.Version;

import java.util.Arrays;

@Question(title = "判断二分图", tags = {Type.GRAPH, Type.DYEING}, level = Level.MEDIUM)
public class Solution0785 {

    @Answer(version = Version.First, desc = "染色法判断二分图", type = Type.DYEING)
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] != -1) {
                continue;
            }
            if (update(graph, colors, i, 0) && update(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }

    @Assist(version = Version.First)
    public boolean update(int[][] graph, int[] colors, int start, int initColor) {
        colors[start] = initColor;
        return !update(graph, colors, start);
    }

    @Assist(version = Version.First)
    public boolean update(int[][] graph, int[] colors, int start) {
        for (int end : graph[start]) {
            int endColor = colors[start] ^ 1;
            if (colors[end] == -1) {
                colors[end] = endColor;
                return update(graph, colors, end);
            }
            if (colors[end] != endColor) {
                return false;
            }
        }
        return true;
    }


}
