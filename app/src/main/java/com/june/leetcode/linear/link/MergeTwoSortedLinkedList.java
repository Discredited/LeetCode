package com.june.leetcode.linear.link;

/**
 * 21.合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * 2022/11/25
 *
 * @author June
 */
public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode point1 = list1;
        ListNode point2 = list2;

        if (null == point1 && null == point2) return null;
        if (null == point2) return list1;
        if (null == point1) return list2;

        ListNode newNode = null;
        ListNode curNode = null;

        while ((point1 != null) || (point2 != null)) {
            if (point1 != null && point2 != null) {
                // 比较两个链表中的当前节点
                if (point1.val <= point2.val) {
                    // 取出list1的point1节点，放入newNode中
                    if (null == curNode) {
                        curNode = new ListNode(point1.val);
                    } else {
                        curNode.next = new ListNode(point1.val);
                        curNode = curNode.next;
                    }
                    point1 = point1.next;
                } else {
                    if (null == curNode) {
                        curNode = new ListNode(point2.val);
                    } else {
                        curNode.next = new ListNode(point2.val);
                        curNode = curNode.next;
                    }
                    point2 = point2.next;
                }
            } else if (point1 == null) {
                curNode.next = new ListNode(point2.val);
                curNode = curNode.next;
                point2 = point2.next;
            } else {
                curNode.next = new ListNode(point1.val);
                curNode = curNode.next;
                point1 = point1.next;
            }

            if (null == newNode) {
                newNode = curNode;
            }
        }

        return newNode;
    }

    public static ListNode aaa(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        // 合并后 list1 和 list2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = list1 == null ? list2 : list1;

        return prehead.next;
    }
}
