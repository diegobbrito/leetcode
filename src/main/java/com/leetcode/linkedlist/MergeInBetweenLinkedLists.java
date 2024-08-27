package com.leetcode.linkedlist;

public class MergeInBetweenLinkedLists {

    //    https://leetcode.com/problems/merge-in-between-linked-lists/
//    Time Complexity O(n + m)
//    Space Complexity O(1)
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        var head = list1;


        while (count < a - 1) { // Move to the element before index "a"
            list1 = list1.next;
            count++;
        }
        var temp = list1;
        while (count <= b) {
            list1 = list1.next;
            count++;
        }
        temp.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = list1;

        return head;
    }
}
