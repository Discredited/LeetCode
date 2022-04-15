package com.june.leetcode.linear.stack

import java.util.*

/**
 * 有效括号
 * 2022年04月15日18:09:51
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 2022/4/15
 * @author June
 */
class ValidParentheses {

    fun isValid(s: String): Boolean {
        // 空字符串或者字符串长度不为偶数
        if (s.isEmpty() || s.length % 2 != 0) return false

        val stack: Stack<Char> = Stack()

        for (c in s) {
            if (stack.isEmpty()) {
                stack.push(c)
            } else {
                val top = stack.peek()
                when (c) {
                    ')' -> {
                        if (top == '('){
                            stack.pop()
                        }else{
                            stack.push(c)
                        }
                    }
                    ']' -> {
                        if (top == '['){
                            stack.pop()
                        }else{
                            stack.push(c)
                        }
                    }
                    '}' -> {
                        if (top == '{'){
                            stack.pop()
                        }else{
                            stack.push(c)
                        }
                    }
                    else -> stack.push(c)
                }
            }
        }

        return stack.isEmpty()
    }
}