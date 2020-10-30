package com.june.leetcode

import com.june.leetcode.linear.link.AddTwoNumbers
import com.june.leetcode.linear.link.ListNode
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        val test = ReversePolishNotation()
//        test.test()

        val l1 = ListNode(2)
        l1.next = ListNode(4)
        l1.next.next = ListNode(3)

        val l2 = ListNode(5)
        l2.next = ListNode(6)
        l2.next.next = ListNode(4)

        val addTwoNumbers = AddTwoNumbers()
        var result = addTwoNumbers.addTwoNumbers(l1, l2)

        while (null != result.next) {
            println(result.`val`)
            println(" -> ")
            result = result.next
        }
    }
}