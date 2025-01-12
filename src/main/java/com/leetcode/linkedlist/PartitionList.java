package com.leetcode.linkedlist;

public class PartitionList {
//    https://leetcode.com/problems/partition-list/

    //    Time complexity: O(n)
    //    Space complexity: O(1)
    public ListNode partition(ListNode head, int x) {
        var leftHead = new ListNode(0);
        var rightHead = new ListNode(0);
        var left = leftHead;
        var right = rightHead;
        var cur = head;

        while (cur != null) {
            if (cur.val < x) {
                left.next = cur;
                left = left.next;
            } else {
                right.next = cur;
                right = right.next;
            }
            cur = cur.next;
        }
        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;
    }
}
