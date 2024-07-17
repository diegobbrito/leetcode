package com.leetcode.linkedlist;

public class ReorderList {
    //    https://leetcode.com/problems/reorder-list/
    public void reorderList(ListNode head) {
        //Find middle of list using a slow and fast pointer approach
        var slow = head;
        var fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the second half of the list using a temp variable
        var second = slow.next; // Start to the second part of the list
        slow.next = null; // Remove the pointer from slow to avoid cycle in the list
        ListNode prev = null;
        while (second != null) {
            var temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        //Re-assign the pointers to match the pattern
        var first = head;
        second = prev;
        while (second != null) {
            var tempFirst = first.next;
            var tempSecond = second.next;
            first.next = second;
            second.next = tempFirst;
            first = tempFirst;
            second = tempSecond;
        }
    }
}
