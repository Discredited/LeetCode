package com.june.leetcode.linear;

import java.util.LinkedList;

/**
 * 32.最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 2021年3月29日19:22:36
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println("最长有效括号子串是:" + longestValidParentheses("(()"));
        System.out.println("最长有效括号子串是:" + longestValidParentheses(")()())"));
        System.out.println("最长有效括号子串是:" + longestValidParentheses(""));
        System.out.println("最长有效括号子串是:" + longestValidParentheses("((())))"));
        System.out.println("最长有效括号子串是:" + longestValidParentheses("()((()"));
    }

    public static int longestValidParentheses(String s) {
        if (null == s || s.length() == 0) return 0;

        LinkedList<Character> queue = new LinkedList<>();
        char current;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == '(') {
                queue.push(s.charAt(i));
            } else {
                if (!queue.isEmpty() && null != queue.pop()) {
                    count = count + 2;
                }
            }
        }

        return count;
    }
}
