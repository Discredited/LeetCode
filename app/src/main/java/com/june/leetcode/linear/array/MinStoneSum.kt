package com.june.leetcode.linear.array

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.PriorityQueue
import kotlin.math.ceil


/**
 * 1962. 移除石子使总数最小
 * https://leetcode.cn/problems/remove-stones-to-minimize-the-total/?envType=daily-question&envId=2023-12-23
 *
 * 2023年12月23日
 * June
 */
class MinStoneSum {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        if (piles.isEmpty()) return 0

        var maxNumPosition = 0

        // 找出piles中最大的k个数字
        for (times in 0 until k) {
            piles.forEachIndexed { index, i ->
                if (piles[maxNumPosition] < i) {
                    maxNumPosition = index
                }
            }
            piles[maxNumPosition] = ceil(piles[maxNumPosition] / 2.0).toInt()
        }

        return piles.sum()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun minStoneSum2(piles: IntArray, k: Int): Int {
        val pq = PriorityQueue { a: Int, b: Int -> b - a }

        piles.forEach { pq.offer(it) }

        for (i in 0 until k) {
            var pile = pq.poll() ?: 0
            pile -= pile / 2
            pq.offer(pile)
        }
        return pq.sum()
    }
}