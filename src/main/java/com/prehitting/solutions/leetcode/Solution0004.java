package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Answer;
import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Version;

/**
 * @ClassName Solution0004
 * @Description 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * @Author 24809
 * @Date 2023-01-20 23:40
 */
@Question(title = "寻找两个正序数组的中位数", tags = {}, level = Level.HARD)
public class Solution0004 {

    @Answer(desc = "将两个数组暴力归并后取中间值", version = Version.First)
    public double findMedianSortedArrays_v1(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        int[] newArr = new int[len];
        int p1 = 0, p2 = 0, index = 0;
        while (p1 < len1 && p2 < len2 && index < len) {
            if (nums1[p1] < nums2[p2]) {
                newArr[index++] = nums1[p1++];
            } else {
                newArr[index++] = nums2[p2++];
            }
        }
        while (p1 < len1) {
            newArr[index++] = nums1[p1++];
        }
        while (p2 < len2) {
            newArr[index++] = nums2[p2++];
        }
        if ((len & 1) == 1) {
            return newArr[len / 2];
        } else {
            return (double) (newArr[len / 2 - 1] + newArr[len / 2]) / 2;
        }
    }

    @Answer(desc = "TODO", version = Version.Second)
    public double findMedianSortedArrays_v2(int[] nums1, int[] nums2) {

        return 0.0;
    }
}
