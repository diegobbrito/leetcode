package com.leetcode.linkedlist;

public class AddTwoNumbers {

    /*
    Time Complexity: O(max(m, n))
    Where m is the number of nodes in l1 and n is the number of nodes in l2.
    The loop iterates through both lists simultaneously, processing each node once.
    The loop runs until the longer list is fully traversed and any remaining carry is processed.

    Space Complexity: O(max(m, n))
    The space complexity is primarily due to the result list, which will have at most max(m, n) + 1 nodes
    (the +1 is for a possible carry at the end).
    No significant additional space is used beyond the new nodes created for the output list,
    as the pointers and variables used are constant space.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize a new ListNode to store the result. This node acts as a dummy head.
        var dummy = new ListNode(0);

        // Curr pointer is used to traverse and build the result list.
        var curr = dummy;

        // Variable to keep track of carry (sum of digits greater than 10).
        int carry = 0;

        // Loop until both lists are fully traversed and there is no carry left.
        while (l1 != null || l2 != null || carry != 0) {
            // If l is not null, get its value, otherwise use 0.
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            // Calculate the sum of the current digits and the carry.
            int sum = v1 + v2 + carry;

            // Update carry for the next iteration (sum divided by 10).
            carry = sum / 10;

            // The new digit to add to the result is the remainder of the sum divided by 10.
            sum = sum % 10;

            // Create a new node with the computed sum and link it to the result list.
            dummy.next = new ListNode(sum);

            // Move the dummy pointer to the next node.
            dummy = dummy.next;

            // Move to the next node in l, if available.
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        // Return the result list, starting from the next node (skipping the initial dummy node).
        return dummy.next;
    }

}
