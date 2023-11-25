package com.june.leetcode.linear.link

import java.util.Stack

/**
 * 445. 两数相加 II
 * https://leetcode.cn/problems/add-two-numbers-ii/?envType=daily-question&envId=2023-11-25
 *
 * 2023/11/25
 * @author June
 */
class AddTwoNumbers2 {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null

        val stack1 = putStack(l1)
        val stack2 = putStack(l2)

        var newHead: ListNode? = null

        var isAdd = 0
        while (stack1.isNotEmpty() || stack2.isNotEmpty()) {
            val num1: Int = if (stack1.isNotEmpty()) {
                stack1.pop()
            } else 0
            val num2 = if (stack2.isNotEmpty()) {
                stack2.pop()
            } else 0

            val tempResult = num1 + num2 + isAdd
            isAdd = if (tempResult >= 10) 1 else 0
            val result = tempResult % 10

            val node = ListNode(result)
            if (null == newHead) {
                newHead = node
            } else {
                node.next = newHead
                newHead = node
            }
        }

        if (isAdd > 0) {
            val node = ListNode(1)
            node.next = newHead
            newHead = node
        }

        return newHead
    }

    private fun putStack(node: ListNode?): Stack<Int> {
        node ?: return Stack<Int>()

        var current = node

        val stack = Stack<Int>()
        while (null != current) {
            stack.push(current.`val`)
            current = current.next
        }
        return stack
    }


    /**
     * 解法1：反转链表
     */
    fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        // 首先想到的是翻转链表，然而题目还有进阶要求，不能反转链表
        // 重点1：反转链表，这个也是一个算法
        var l1RevertHead = revertLinkList(l1)
        var l2RevertHead = revertLinkList(l2)
        // 然后执行两个链表的同时遍历，直到两个链表指针都为空

        var newHead: ListNode? = null

        var isAdd = 0
        while (l1RevertHead != null || l2RevertHead != null) {
            val num1: Int = l1RevertHead?.`val` ?: 0
            val num2 = l2RevertHead?.`val` ?: 0
            val tempResult = num1 + num2 + isAdd
            isAdd = if (tempResult >= 10) 1 else 0
            val result = tempResult % 10

            // 重点2：这里使用头插法来处理新的链表
            val node = ListNode(result)
            if (null == newHead) {
                newHead = node
            } else {
                node.next = newHead
                newHead = node
            }

            l1RevertHead = l1RevertHead?.next
            l2RevertHead = l2RevertHead?.next
        }

        // 重点3：如果最后isAdd还有值，则需要再头插增加一个节点
        if (isAdd > 0) {
            val node = ListNode(1)
            node.next = newHead
            newHead = node
        }

        return newHead
    }


    private fun revertLinkList(head: ListNode?): ListNode? {

        var prev: ListNode? = null
        var current = head
        var next: ListNode?

        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }

        return prev
    }
}