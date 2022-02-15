package com.june.leetcode.linear.array

/**
 * 1380. 矩阵中的幸运数
 * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * 2022年02月15日16:06:31
 */
class LuckyNumbers {
    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val rows = matrix.size

        println("rows:${rows}")
        val targetList = mutableListOf<Int>();

        for (row in 0 until rows) {
            // 首先在行内寻找该行最小的元素
            val minNumber = matrix[row].minOf { it }
            println("第${row}行最小元素:${minNumber}")
            // 改行最小元素所在的列
            val minNumberColumns = matrix[row].indexOf(minNumber)
            println("最小元素:${minNumber}所在的${minNumberColumns}")
            // 当前最小元素是否为矩阵中该列元素中值最大的
            var count = 0
            for (array in matrix) {
                val currentNumber = array[minNumberColumns]
                print("  currentNumber:${currentNumber}  minNumber${minNumber}")
                if (currentNumber > minNumber) {
                    println("  跳出循环")
                    break
                }
                count++
            }
            print("  count:${count}  columns:${rows}")
            if (count == rows) {
                targetList.add(minNumber)
            }
            println()
        }

        return targetList
    }
}

fun main(args: Array<String>) {
    val list = LuckyNumbers().luckyNumbers(
                arrayOf(
                    intArrayOf(3, 7, 8),
                    intArrayOf(9, 11, 13),
                    intArrayOf(15, 16, 17)
                )
//        arrayOf(
//            intArrayOf(1, 10, 4, 2),
//            intArrayOf(9, 3, 8, 7),
//            intArrayOf(15, 16, 17, 12)
//        )
    )
    println(list)
}