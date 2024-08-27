package com.leetcode.twopointers;

import java.util.Stack;

public class ReverseString {
    //    https://leetcode.com/problems/reverse-string/
    //    Time Complexity O(n)
    //    Space Complexity O(1)
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    //    Time Complexity O(n)
    //    Space Complexity O(n)
    public void reverseString2(char[] s) {
        var stack = new Stack<Character>();
        for (char c : s) {
            stack.push(c);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            s[i] = stack.pop();
            i++;
        }
    }

    //    Time Complexity O(n)
    //    Space Complexity O(n)
    public void reverseString3(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    public void reverse(char[] s, int left, int right) {
        if (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            reverse(s, ++left, --right);
        }
    }
}
