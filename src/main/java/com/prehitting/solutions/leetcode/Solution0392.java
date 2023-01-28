package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Answer;
import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Type;
import com.prehitting.enums.Version;

/**
 * @ClassName Solution0392
 * @Description
 * @Author 24809
 * @Date 2023-01-24 23:44
 */

@Question(title = "判断子序列", level = Level.SIMPLE, tags = Type.DynamicProgramming)
public class Solution0392 {

    @Answer(version = Version.First, type = Type.DynamicProgramming)
    public boolean isSubsequence(String pattern, String str) {
        int len1 = pattern.length();
        int len2 = str.length();
        if (len1 == 0) {
            return true;
        }
        if (len2 < len1) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= len1; i++) {
            char c = pattern.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = dp[i][j - 1] || (dp[i - 1][j - 1] && c == str.charAt(j - 1));
            }
        }
        for (int i = 1; i <= len2; i++) {
            if (dp[len1][i]) {
                return true;
            }
        }
        return false;
    }

}
