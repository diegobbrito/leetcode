package com.leetcode.linkedlist;

public class PalindromeLinkedList {
//    https://leetcode.com/problems/palindrome-linked-list/

    //    Time Complexity O(n)
//    Memory Complexity O(1)
    public boolean isPalindrome(ListNode head) {
//      Find the middle, slow pointer
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        Reverse the second part of linkedlist, starting with a null value
        ListNode prev = null;
        while (slow != null) {
            var temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        //  Check if is a palindrome
        var left = head;
        var right = prev;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
