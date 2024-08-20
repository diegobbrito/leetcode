package com.leetcode.linkedlist;

public class RemoveDuplicatesSortedList {
    //    https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    //    Time Complexity O(n)
    //    Memory complexity O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        var dummy = new ListNode(0, head);
        var curr = head;
        var prev = dummy;


        while (curr.next != null) {
            if (curr.val == curr.next.val)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    //    Time Complexity O(n)
    //    Memory complexity O(1)
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        var curr = head;

        while (curr.next != null) {
            if (curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }
}
