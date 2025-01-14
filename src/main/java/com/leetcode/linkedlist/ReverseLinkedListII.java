package com.leetcode.linkedlist;

public class ReverseLinkedListII {

    // https://leetcode.com/problems/reverse-linked-list-ii/
    // Time complexity: O(n), where n is the number of nodes in the linked list.
    // We traverse the list exactly once.
    // Space complexity: O(1), as we are only using a few pointers (leftPrev, cur, prev).
    public ListNode reverseBetween(ListNode head, int left, int right) {
        var dummy = new ListNode(0, head);
        var leftPrev = dummy;
        var cur = head;
        for (int i = 1; i < left; i++) {
            leftPrev = leftPrev.next;
            cur = cur.next;
        }
        ListNode prev = null;
        for (int i = left; i <= right; i++) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        leftPrev.next.next = cur;
        leftPrev.next = prev;

        return dummy.next;
    }
}
