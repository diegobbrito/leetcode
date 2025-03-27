package com.leetcode.linkedlist;

public class InsertNodeAtPosition {

    //https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
    //Time complexity: O(n)
    //Space complexity: O(1)

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        SinglyLinkedListNode head = llist;
        for (int i = 0; i < position - 1; i++) {
            llist = llist.next;
        }
        newNode.next = llist.next;
        llist.next = newNode;

        return head;
    }

}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int data) {
        this.data = data;
    }
}

