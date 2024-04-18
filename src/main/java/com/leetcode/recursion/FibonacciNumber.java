package com.leetcode.recursion;

public class FibonacciNumber {
//	https://leetcode.com/problems/fibonacci-number/
	public int fib(int n) {
		if(n <= 1) return n;

		return fib(n - 1) + fib(n - 2);
	}
}
