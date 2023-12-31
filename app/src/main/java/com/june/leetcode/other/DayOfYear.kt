package com.june.leetcode.other

/**
 * 1154. 一年中的第几天
 * https://leetcode.cn/problems/day-of-the-year/?envType=daily-question&envId=2023-12-31
 *
 * 2023/12/31
 * @author June
 */
class DayOfYear {

  fun dayOfYear(date: String): Int {
    val splits = date.split("-")

    // 数组定义
    val monthArray = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30)

    // 年月日的拆解
    val year = splits[0].toInt()
    val month = splits[1].toInt()
    val day = splits[2].toInt()

    var totalDay = 0

    for (index  in 0 until month){
      totalDay += monthArray[index]
    }

    totalDay += day

    // 是否为闰年，且目标日期大于3月份
    if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
      totalDay++
    }

    return totalDay
  }
}