package com.leetcode.linkedlist;

public class SortList {

    //    https://leetcode.com/problems/sort-list/
//    Time complexity: O(nlogn), where n is the number of elements in the input list.
//    Space complexity: O(logn), where n is the number of elements in the input list.
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        var left = head;
        var right = getMid(head);
        var temp = right.next;
        right.next = null;
        right = temp;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        var slow = head;
        var fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
