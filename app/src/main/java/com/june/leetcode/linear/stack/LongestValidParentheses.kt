package com.june.leetcode.linear.stack

import java.util.Stack
import kotlin.math.max

/**
 * 32. 最长有效括号
 *
 * https://leetcode.cn/problems/longest-valid-parentheses/
 *
 * 2024/1/1
 * @author June
 */
class LongestValidParentheses {

  fun longestValidParentheses(s: String): Int {
    if (s.isEmpty()) return 0

    var effectiveLength = 0

    val stack = Stack<Int>().apply { push(-1) }
    s.forEachIndexed { index, c ->
      if (c == '(') {
        stack.push(index)
      } else {
        stack.pop()
        if (stack.isEmpty()) {
          stack.push(index)
        } else {
          effectiveLength = max(effectiveLength, index - stack.peek())
        }
      }
    }

    return effectiveLength
  }
}