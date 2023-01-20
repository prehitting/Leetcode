package com.prehitting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Solution0001 {

    /**
     * version 1.0
     */

    public int[] twoSum_v1(int[] nums, int target) {
        int len = nums.length;
        if (len < 2)
            return new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[2];
    }

    /**
     * version 2.0
     */
    public static int[] twoSum_v2(int[] nums, int target) {
        int len = nums.length;
        if (len < 2)
            return new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int j = map.getOrDefault(target - nums[i], -1);
            if (j != -1) {
                return new int[] { i, j };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

}
