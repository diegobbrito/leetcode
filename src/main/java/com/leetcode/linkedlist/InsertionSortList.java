package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSortList {

    //https://leetcode.com/problems/insertion-sort-list/
    //Time complexity: O(nlogn)
    //Space complexity: O(n)

    public ListNode insertionSortList(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }

        Collections.sort(arr);
        cur = head;

        for (int val : arr) {
            cur.val = val;
            cur = cur.next;
        }
        return head;
    }
}
