package com.june.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 2021年08月25日17:39:24
 * <p>
 * 最优解法：滑动窗口
 */
public class LongestStringWithoutRepeated {

    public static void main(String[] args) {
        System.out.println("abcabcbb的最大长度:" + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb:" + lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew:" + lengthOfLongestSubstring("pwwkew"));
        System.out.println("asjdkasjvl:" + lengthOfLongestSubstring("asjdkasjvl"));
        System.out.println("tmmzuxt:" + lengthOfLongestSubstring("tmmzuxt"));
        System.out.println("abcabcbb:" + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("au:" + lengthOfLongestSubstring("au"));
    }

    /**
     * 我的解法
     * 76 ms	38.9 MB
     *
     * 相较于官方解法，左指针向右移动一格，移除一个字符的优化
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s) return 0;

        if (s.length() <= 1) return s.length();

        int maxLength = 1;
        int currentLength = 0;
        int startPosition = -1; // 其实位置应该为字符串的左边界

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (startPosition < s.length() - 1 && !set.contains(s.charAt(startPosition + 1))) {
                set.add(s.charAt(startPosition + 1));
                startPosition++;
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
            // 重置数据
            startPosition = i;
            currentLength = 0;
            set.clear();
        }
        return maxLength;
    }


    /**
     * 官方标准解法
     * 6 ms	38.4 MB
     */
    public static int stringLength(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
