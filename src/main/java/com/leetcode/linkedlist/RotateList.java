package com.leetcode.linkedlist;

public class RotateList {
//    https://leetcode.com/problems/rotate-list/

    //    Time complexity: O(n)
    //    Space complexity: O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int length = 1;
        var tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        k = k % length;
        if (length < 2 || k == 0) return head;
        var cur = head;
        for (int i = 1; i < length - k; i++) {
            cur = cur.next;
        }
        var newHead = cur.next;
        cur.next = null;
        tail.next = head;
        return newHead;
    }
}
