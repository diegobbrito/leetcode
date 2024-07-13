package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    //    https://leetcode.com/problems/linked-list-cycle/
    //    Time complexity O(n)
    //    Memory complexity O(n)
    //    Using a hashset check if the node had been added to the set, while no null is found
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }

    //    Time complexity O(N)
    //    Memory complexity O(1)
    //    Using two pointers, check is fast pointer is not null then iterate slow by one and fast by two each step
    //    Being N the distance between slow and fast, each iteration will decrease by one de distance.
    public boolean hasCycle2(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
