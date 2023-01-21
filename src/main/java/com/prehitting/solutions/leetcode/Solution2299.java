package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Answer;
import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Type;
import com.prehitting.enums.Version;

/**
 * Leetcode 2299 简单
 * 如果一个密码满足以下所有条件，我们称它是一个 强 密码：
 * <p>
 * 它有至少 8 个字符。
 * 至少包含 一个小写英文 字母。
 * 至少包含 一个大写英文 字母。
 * 至少包含 一个数字 。
 * 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
 * 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
 * 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
 */
@Question(title = "是否为强密码", tags = Type.Mock, level = Level.SIMPLE)
class Solution2299 {

    @Answer(version = Version.Only)
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        boolean[] v = new boolean[127];
        "!@#$%^&*()-+".chars().forEach(i -> v[i] = true);
        int ans = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= '0' && c <= '9') ans |= 1 << 2;
            if (c >= 'a' && c <= 'z') ans |= 1 << 0;
            if (c >= 'A' && c <= 'Z') ans |= 1 << 1;
            if (v[c]) ans |= 1 << 3;
            if (i > 0 && password.charAt(i - 1) == c) return false;
        }
        return ans == ((1 << 4) - 1);
    }

}