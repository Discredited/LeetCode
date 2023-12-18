package com.june.leetcode.linear.array

/**
 * 162. 寻找峰值
 *
 * https://leetcode.cn/problems/find-peak-element/description/?envType=daily-question&envId=2023-12-18
 *
 * 2023/12/18
 * @author June
 */
class FindPeakElement {

  /**
   * 遍历数组
   * 查找数组中的最大值
   *
   * 212 ms  36.7 MB
   */
  fun findPeakElement(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var peakPosition = 0
    nums.forEachIndexed { index, i ->
      if (nums[peakPosition] < i) {
        peakPosition = index
      }
    }
    return peakPosition
  }

  /**
   * 二分查找
   *
   *
   * 212 ms   37.1 MB
   */
  fun findPeakElement2(nums: IntArray): Int {
    if (nums.isEmpty() || nums.size == 1) return 0

    var left = 0
    var right = nums.size - 1
    while (left < right) {
      val middle = (left + right) / 2
      if (nums[middle] > nums[middle + 1]) {
        right = middle
      } else {
        left = middle + 1
      }
    }
    return left
  }
}