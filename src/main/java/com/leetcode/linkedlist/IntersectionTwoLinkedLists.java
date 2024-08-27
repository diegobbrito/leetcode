package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoLinkedLists {
//    https://leetcode.com/problems/intersection-of-two-linked-lists/

    //    Time Complexity O(n * m)
//    Space Complexity O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            var temp = headB;
            while (temp != null) {
                if (headA == temp)
                    return temp;
                temp = temp.next;
            }
            headA = headA.next;
        }
        return null;
    }

    //    Time Complexity O(n + m)
    //    Space Complexity O(n)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    //    Time Complexity O(n + m)
    //    Space Complexity O(1)
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        var a = headA;
        var b = headB;
        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }
}
