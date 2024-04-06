package com.leetcode.linkedlist;

public class MergeTwoSortedLists {

//	https://leetcode.com/problems/merge-two-sorted-lists/
	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode cur = new ListNode();
		var response = cur;
		while (list1 != null && list2 != null){
			if (list1.val < list2.val){
				response.next = list1;
				list1 = list1.next;
			} else {
				response.next = list2;
				list2 = list2.next;
			}
			response = response.next;
		}
		response.next = list1 != null ? list1 : list2;
		return cur.next;
	}

//	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
//		if(l1 == null) return l2;
//		if(l2 == null) return l1;
//		if(l1.val < l2.val){
//			l1.next = mergeTwoLists(l1.next, l2);
//			return l1;
//		} else{
//			l2.next = mergeTwoLists(l1, l2.next);
//			return l2;
//		}
//	}

	public static void main(String[] args) {
		var list1 = new ListNode(1);
		list1.next = new ListNode(2, new ListNode(4));
		var list2 = new ListNode(1);
		list2.next = new ListNode(3, new ListNode(4));

		var test = mergeTwoLists(list1, list2);
		System.out.println(test.val);
	}
}
