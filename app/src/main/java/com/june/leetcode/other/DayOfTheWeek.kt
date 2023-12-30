package com.june.leetcode.other

/**
 * 1185. 一周中的第几天
 *
 * https://leetcode.cn/problems/day-of-the-week/description/?envType=daily-question&envId=2023-12-30
 *
 * 2023/12/30
 * @author June
 */
class DayOfTheWeek {

  private val weekArray = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday","Friday", "Saturday", "Sunday")
  private val monthArray = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30)

  // 给出的日期一定是在 1971 到 2100 年之间的有效日期。
  // 1971年的第一天是星期5
  // 每四年有一年闰年，为366天
  fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
    val yearDay = (year - 1971) * 365 + ((year - 1969) / 4)
    println("年天数：$yearDay")
    var monthDay = 0
    for (current in 0 until month) {
      monthDay += monthArray[current]
    }
    println("月天数：$monthDay")
    var isAddDay = 0
    if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
      isAddDay = 1
    }
    println("是闰年：$isAddDay")
    val totalDay = yearDay + monthDay + day + isAddDay

    return weekArray[(totalDay - 1) % 6]
  }

  companion object{
    @JvmStatic
    fun main(args: Array<String>) {
      println(DayOfTheWeek().dayOfTheWeek(31,8,2019))
      println(DayOfTheWeek().dayOfTheWeek(1,1,1971))
    }
  }
}