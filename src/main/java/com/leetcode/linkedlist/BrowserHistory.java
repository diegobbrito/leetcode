package com.leetcode.linkedlist;

class BrowserHistory {
	// https://leetcode.com/problems/design-browser-history/

	Node currentPage;

	public BrowserHistory(String homepage) {
		this.currentPage = new Node(homepage);
	}

	public void visit(String url) {
		var page = new Node(url);
		currentPage.next = page;
		page.prev = currentPage;

		currentPage = page;
	}

	public String back(int steps) {
		while (currentPage.prev != null && steps-- > 0)
			currentPage = currentPage.prev;
		return currentPage.page;
	}

	public String forward(int steps) {
		while (currentPage.next != null && steps-- > 0)
			currentPage = currentPage.next;
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

