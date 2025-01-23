package com.leetcode.linkedlist;

public class SortList {

    //    https://leetcode.com/problems/sort-list/
//    Time complexity: O(nlogn), where n is the number of elements in the input list.
//    Space complexity: O(logn), where n is the number of elements in the input list.
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        var mid = getMid(head);
        var left = sortList(head);
        var right = sortList(mid);
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        var slow = head;
        var fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return fast;
    }

    private ListNode merge(ListNode left, ListNode right) {
        var dummy = new ListNode(0);
        var tail = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        }
        if (right != null) {
            tail.next = right;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }

    private ListNode quickSort(ListNode head, ListNode stop) {
        if (head == null || head.next == null || head == stop || head.next == stop) {
            return head;
        }
        ListNode lowHead = head;
        ListNode prev = head;
        ListNode tail = prev.next;
        boolean isSorted = true;
        while (tail != stop) {
            isSorted = isSorted && prev.val <= tail.val;
            if (tail.val < head.val) {
                prev.next = tail.next;
                tail.next = lowHead;
                lowHead = tail;
            } else {
                prev = prev.next;
            }
            tail = prev.next;
        }
        if (isSorted) {
            return head;
        }

        ListNode result = quickSort(lowHead, head);

        head.next = quickSort(head.next, stop);

        return result;
    }
}
