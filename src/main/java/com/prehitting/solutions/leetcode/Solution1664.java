package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;

/**
 * @ClassName Solution1664
 * @Description
 * @Author 24809
 * @Date 2023-01-28 21:28
 */
@Question(title = "生成平衡数组的方案", level = Level.MEDIUM)
public class Solution1664 {

    public int waysToMakeFair(int[] nums) {
        int res = 0;
        int len = nums.length;
        // len ranges from 1 to 1e5
        // nums[i] ranges from 1 to 1e4
        if (len == 1) {
            return 1;
        }
        // 首先构造前缀和数组
        int[] suffSum = new int[len + 5];
        suffSum[len] = nums[len - 1];
        suffSum[len - 1] = nums[len - 2];
        for (int index = len - 3; index >= 0; index--) {
            suffSum[index + 1] = suffSum[index + 3] + nums[index];
        }

        // 寻找符合要求的坐标
        for (int index = 0; index < len; index++) {
            // 要删除index位置的元素，那么当前位置后面奇/偶元素和为
            // index+1是在[index,len)同性元素和，index+3是(index,len)同性元素和，index+2是[index,len)非同性元素和
            int[] after = new int[]{suffSum[index + 1] - nums[index], suffSum[index + 2]};
            int[] before = new int[]{0, 0};
            if ((index & 1) == 0) {
                // index为偶数
                before[0] = suffSum[1] - suffSum[index + 1];
                before[1] = suffSum[2] - suffSum[index + 2];
            } else {
                before[0] = suffSum[2] - suffSum[index + 1];
                before[1] = suffSum[1] - suffSum[index + 2];
            }
            if (before[0] + after[1] == before[1] + after[0]) {
                res++;
            }
        }
        return res;
    }

}
