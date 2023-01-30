package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Type;
import com.prehitting.solutions.leetcode.helper.TreeNode;

/**
 * <pre>
 *     {@code
 * @Description LeetCode Treenode为内部类，get&set方法不可用，故请使用以下版本提交
 * class Solution {
 *     private int res = 0;
 *
 *     public int sumNumbers(TreeNode root) {
 *         if (root == null) {
 *             return 0;
 *         }
 *         if (root.left == null && root.right == null) {
 *             return root.val;
 *         }
 *         res += get(root, 0);
 *         return res;
 *     }
 *
 *     public int get(TreeNode cur, int num) {
 *         if (cur == null) {
 *             return 0;
 *         }
 *         if (cur.left == null && cur.right == null) {
 *             return num * 10 + cur.val;
 *         }
 *         return get(cur.left, num * 10 + cur.val) + get(cur.right, num * 10 + cur.val);
 *     }
 *
 * }}
 * </pre>
 */
@Question(title = "求根节点到叶节点数字之和", level = Level.MEDIUM, tags = Type.Recursion, desc = "")
public class Solution0129 {

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return root.getVal();
        }
        res += get(root, 0);
        return res;
    }

    public int get(TreeNode cur, int num) {
        if (cur == null) {
            return 0;
        }
        if (cur.getLeft() == null && cur.getRight() == null) {
            return num * 10 + cur.getVal();
        }
        return get(cur.getLeft(), num * 10 + cur.getVal()) + get(cur.getRight(), num * 10 + cur.getVal());
    }

    public static void main(String[] args) {
        Solution0129 solution0129 = new Solution0129();
        TreeNode root = new TreeNode(
                4
                , new TreeNode(9, new TreeNode(5), new TreeNode(1))
                , new TreeNode(0)
        );
        System.out.println(solution0129.sumNumbers(root));
    }
}
