package com.june.leetcode.tree;

import java.util.Stack;

/**
 * 求根到叶子节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class TreeNumbersSum {

    public static void main(String[] args) {
        TreeNode trees = TreeHelper.getTrees();
        TreeNumbersSum treeNumbersSum = new TreeNumbersSum();
        treeNumbersSum.sumNumbers(trees);
    }

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.print("  " + root.val + "  ");
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
            System.out.println();
            System.out.println("  ----------  ");
        }

        return 0;
    }
}
