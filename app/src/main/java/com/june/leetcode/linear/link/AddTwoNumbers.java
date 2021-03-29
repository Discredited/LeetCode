package com.june.leetcode.linear.link;

/**
 * 2.两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        ListNode l1 = new ListNode(9);
//
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
//        l2.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next = new ListNode(9);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        while (null != result) {
            System.out.println(result.val);
            System.out.println(" -> ");
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode current = null;
        int isAdd = 0;
        while (l1 != null || l2 != null) {
            int value1 = 0;
            if (null != l1) {
                value1 = l1.val;
            }

            int value2 = 0;
            if (null != l2) {
                value2 = l2.val;
            }

            int sum = value1 + value2 + isAdd;
            if (sum >= 10) {
                isAdd = 1;
            } else {
                isAdd = 0;
            }
            ListNode node = new ListNode(sum % 10);
            if (null == head) {
                head = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }

            if (null != l1) l1 = l1.next;
            if (null != l2) l2 = l2.next;
        }

        if (isAdd == 1) {
            current.next = new ListNode(1);
        }

        return head;
    }
}
