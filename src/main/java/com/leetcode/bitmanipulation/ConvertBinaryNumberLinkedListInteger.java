package com.leetcode.bitmanipulation;

public class ConvertBinaryNumberLinkedListInteger {

    // https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public int getDecimalValue(ListNode head) {

        int result = 0;

        while (head != null) {
            result <<= 1;
            result |= head.val;

            head = head.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
}
