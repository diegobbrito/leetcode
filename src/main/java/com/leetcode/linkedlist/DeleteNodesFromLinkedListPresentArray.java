package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentArray {

//    https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/

//    Time Complexity O(n + m)
//    Space Complexity O(n)
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(head != null){
            if(!set.contains(head.val)){
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
