package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Answer;
import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Type;
import com.prehitting.enums.Version;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
@Question(title = "两数之和", tags = Type.Hash, level = Level.SIMPLE)
public class Solution0001 {


    @Answer(desc = "双层for循环查找", version = Version.First)
    public int[] twoSum_v1(int[] nums, int target) {
        int len = nums.length;
        if (len < 2)
            return new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }


    @Answer(desc = "使用map缓存", version = Version.Second)
    public static int[] twoSum_v2(int[] nums, int target) {
        int len = nums.length;
        if (len < 2)
            return new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int j = map.getOrDefault(target - nums[i], -1);
            if (j != -1) {
                return new int[]{i, j};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        String s = "abc", t = "";
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            str.append("*").append(c);
        }
        s = str.append("*").toString();
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(t);
        System.out.println(matcher.matches());
    }

}
