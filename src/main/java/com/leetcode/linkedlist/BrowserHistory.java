package com.leetcode.linkedlist;

class BrowserHistory {
	// https://leetcode.com/problems/design-browser-history/

	Node currentPage;

	public BrowserHistory(String homepage) {
		this.currentPage = new Node(homepage);
	}

	public void visit(String url) {
		var page = new Node(url);
		page.prev = currentPage;
		currentPage.next = page;
		this.currentPage = this.currentPage.next;
	}

	public String back(int steps) {
		var cur = this.currentPage;
		for (int i = steps; i > 0; i--) {
			if(cur.prev == null)
				break;
			cur = cur.prev;
		}
		this.currentPage = cur;

		return currentPage.page;
	}

	public String forward(int steps) {

		var cur = this.currentPage;
		for (int i = 0; i < steps; i++) {
			if(cur.next == null)
				break;
			cur = cur.next;
		}
		this.currentPage = cur;
		return currentPage.page;
	}
}

class Node {
	String page;
	Node next;
	Node prev;
	Node(String page){
		this.page = page;
		this.next = null;
		this.prev = null;
	}
}

