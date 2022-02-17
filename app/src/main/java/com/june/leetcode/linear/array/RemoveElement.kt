package com.june.leetcode.linear.array

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * 2022/2/17
 * @author June
 */
class RemoveElement {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1 && nums[0] != `val`) return 1

        var count = 0
        // 从数组头开始移动
        var leftPosition = 0
        // 从数组最后以为开始移动
        var rightPosition = nums.size - 1

        while (leftPosition < rightPosition) {
            println("--------------------")
            if (nums[leftPosition] == `val`) {
                // 如果发现当前元素==目标元素，则尝试将当前元素放在数组右端
                // 但是数组右端的元素可能也==目标元素，此时应该将rightPosition左移
                // 直到rightPosition指向的元素!=目标元素，或者rightPosition<leftPosition
                while (nums[rightPosition] == `val` && rightPosition > leftPosition) {
                    rightPosition--
                }

                if (rightPosition > leftPosition) {
                    // 交换两个元素的位置
                    nums[leftPosition] = nums[leftPosition] + nums[rightPosition]
                    nums[rightPosition] = nums[leftPosition] - nums[rightPosition]
                    nums[leftPosition] = nums[leftPosition] - nums[rightPosition]
                    count++
                }
            }
            leftPosition++
        }
        return count
    }
}

fun main() {
    println("result:${RemoveElement().removeElement(intArrayOf(3, 2, 2, 3), 3)}")
    println()
    println("result:${RemoveElement().removeElement(intArrayOf(2), 3)}")
    println()
    println("result:${RemoveElement().removeElement(intArrayOf(3, 3), 3)}")
}