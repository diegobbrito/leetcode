package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesSortedListII {

    //    https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
//    Map Solution
//    Time Complexity O(n)
//    Space Complexity O(n)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        var dummy = new ListNode(0);
        var result = dummy;
        Map<Integer, Integer> map = new HashMap<>();
        var cur = head;
        while (cur != null) {
            if (map.containsKey(cur.val))
                map.put(cur.val, 2);
            else
                map.put(cur.val, 1);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (map.get(cur.val) == 1) {
                dummy.next = cur;
                dummy = dummy.next;
            }
            cur = cur.next;
        }
        dummy.next = null;

        return result.next;
    }

    //    Two Pointers Solution
//    Time Complexity O(n)
//    Space Complexity O(1)
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        var dummy = new ListNode(0);
        var result = dummy;
        var cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val)
                while (cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
            else {
                dummy.next = cur;
                dummy = dummy.next;
            }
            cur = cur.next;
        }
        dummy.next = null;
        return result.next;
    }
}
