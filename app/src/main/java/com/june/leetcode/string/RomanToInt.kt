package com.june.leetcode.string

import java.util.LinkedList

/**
 * 罗马数字转整数
 *
 * https://leetcode.cn/problems/roman-to-integer/
 *
 * 2023/12/15
 * @author June
 */
class RomanToInt {

  private val charMap = mutableMapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
  )

  fun romanToInt(s: String): Int {
    var result = 0
    val length = s.length
    s.forEachIndexed { index, c ->
      val current = charMap[c] ?: 0
      if (index < (length - 1) && current < (charMap[s[index + 1]] ?: 0)) {
        result -= current
      } else {
        result += current
      }
    }

    return result
  }

  /**
   * 解法1：自作聪明使用了队列来存字符，然后对每种数字的情况做了判断
   * 写了一大堆代码
   *
   * 212ms  36.48MB
   */
  fun romanToInt2(s: String): Int {
    if (s.isEmpty()) return 0

    val list = LinkedList<Char>()
    s.forEach { list.addLast(it) }

    var result = 0

    while (list.isNotEmpty()) {
      when (list.pop()) {
        'I' -> {
          val next = list.peek()
          result += when (next) {
            'V' -> {
              list.pop()
              4
            }

            'X' -> {
              list.pop()
              9
            }

            else -> {
              1
            }
          }
        }

        'V' -> result += 5
        'X' -> {
          val next = list.peek()
          result += when (next) {
            'L' -> {
              list.pop()
              40
            }

            'C' -> {
              list.pop()
              90
            }

            else -> {
              10
            }
          }
        }

        'L' -> result += 50
        'C' -> {
          val next = list.peek()
          result += when (next) {
            'D' -> {
              list.pop()
              400
            }

            'M' -> {
              list.pop()
              900
            }

            else -> {
              100
            }
          }
        }

        'D' -> result += 500
        'M' -> result += 1000
      }
    }
    return result
  }
}