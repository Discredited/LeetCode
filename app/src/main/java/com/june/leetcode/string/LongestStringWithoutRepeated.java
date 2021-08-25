package com.june.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 2021年08月25日17:39:24
 */
public class LongestStringWithoutRepeated {

    public static void main(String[] args) {
//        System.out.println("abcabcbb的最大长度:" + lengthOfLongestSubstring("abcabcbb"));
//        System.out.println("bbbbb:" + lengthOfLongestSubstring("bbbbb"));
//        System.out.println("pwwkew:" + lengthOfLongestSubstring("pwwkew"));
//        System.out.println("asjdkasjvl:" + lengthOfLongestSubstring("asjdkasjvl"));
//        System.out.println("tmmzuxt:" + lengthOfLongestSubstring("tmmzuxt"));
        System.out.println("abcabcbb:" + lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (null == s) return 0;

        if (s.length() <= 1) return s.length();

        int maxLength = 1;
        int startPosition = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                int length = i - startPosition;
                if (length >= maxLength) maxLength = length;
                System.out.println("====    " + c + "    containsKey    length:" + length + "    maxLength:" + maxLength);

                //查找到相同字符后需要更新起始位置
                startPosition = map.get(c) + 1;
                System.out.println("====    " + c + "    更新startPosition:" + startPosition);

                map.put(c, i);
            } else {
                if (i == s.length() - 1) {
                    int length = i - startPosition + 1;
                    if (length >= maxLength) maxLength = length;
                    System.out.println("====    " + c + "    not containsKey    最后一位    length:" + length + "    maxLength:" + maxLength);
                } else {
                    map.put(c, i);
                    System.out.println("====     " + c + "    not containsKey    不是最后    map:" + map.size());
                }
            }
        }
        return maxLength;
    }


    public static int stringLength(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet();
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
