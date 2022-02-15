package com.june.leetcode.linear.link

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 2022年02月15日19:38:32
 */
class CycledLinkList {

    fun hasCycle(head: ListNode?): Boolean {
        // 链表为空，则表示没有环
        head?.next ?: return false

        // 快慢指针
        var slow: ListNode? = head.next
        var fast: ListNode? = head.next?.next

        while (fast != null && slow != null) {
            slow = slow.next
            fast = fast.next?.next

            if (slow != null && fast == slow) return true
        }

        return false
    }
}