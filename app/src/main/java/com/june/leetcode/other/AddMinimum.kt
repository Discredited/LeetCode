package com.june.leetcode.other

/**
 * 2645. 构造有效字符串的最少插入数
 *
 * https://leetcode.cn/problems/minimum-additions-to-make-valid-string/description/?envType=daily-question&envId=2024-01-11
 *
 * 2024/1/13
 * @author June
 */
class AddMinimum {

  // 第一次结题
  // 164ms  34.22MB
  fun addMinimum(word: String): Int {
    if (word.isEmpty()) return 3

    var preChar = word[0]  // 上一个字符
    var miniCount = 0

    word.forEachIndexed { index, c ->
      if (index == 0) {
        when (preChar) {
          'a' -> miniCount += 0
          'b' -> miniCount += 1
          'c' -> miniCount += 2
        }
      } else {
        when (c) {
          'a' -> {
            when (preChar) {
              'a' -> miniCount += 2
              'b' -> miniCount += 1
              'c' -> miniCount += 0
            }
          }

          'b' -> {
            when (preChar) {
              'a' -> miniCount += 0
              'b' -> miniCount += 2
              'c' -> miniCount += 1
            }
          }

          'c' -> {
            when (preChar) {
              'a' -> miniCount += 1
              'b' -> miniCount += 0
              'c' -> miniCount += 2
            }
          }
        }
        preChar = c
      }
    }

    when (preChar) {
      'a' -> miniCount += 2
      'b' -> miniCount += 1
    }

    return miniCount
  }
}