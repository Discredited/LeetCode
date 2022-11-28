package com.june.leetcode.linear.link;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String printNode() {
        if (null == next) return "[" + val + "]";

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (next != null) {
            builder.append(val);
            builder.append(",");
            next = next.next;
        }
        builder.append("]");
        return builder.toString();
    }
}