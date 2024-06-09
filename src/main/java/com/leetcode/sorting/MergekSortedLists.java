package com.leetcode.sorting;

public class MergekSortedLists {

//	https://leetcode.com/problems/merge-k-sorted-lists/

	class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			if(lists.length == 0) return null;

			int size = lists.length;
			int interval = 1;
			while (interval < size){
				for(int i = 0; i < size - interval; i += 2 * interval){
					lists[i] =  merge(lists[i], lists [i + interval]);
				}
				interval *=2;
			}
			return lists[0];
		}

		private ListNode merge(ListNode l1, ListNode l2){
			var dummy = new ListNode(0);
			var curr = dummy;
			while(l1 != null && l2 != null){
				if (l1.val < l2.val) {
					curr.next = l1;
					l1 = l1.next;
				} else {
					curr.next = l2;
					l2 = l2.next;
				}
				curr = curr.next;
			}
			if (l1 != null) {
				curr.next = l1;
			} else {
				curr.next = l2;
			}
			return dummy.next;
		}
	}
}


// * Definition for singly-linked list.
class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
}

