package com.june.leetcode.string;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 2021年09月24日10:48:54
 */
public class LongestPalindromeString {

    public static void main(String[] args) {
        System.out.println("babad 最长回文：" + longestPalindrome("babad"));
        System.out.println("cbbd 最长回文：" + longestPalindrome("cbbd"));
        System.out.println("a 最长回文：" + longestPalindrome("a"));
        System.out.println("ac 最长回文：" + longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
