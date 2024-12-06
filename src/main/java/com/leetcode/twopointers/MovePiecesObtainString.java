package com.leetcode.twopointers;

public class MovePiecesObtainString {
//    https://leetcode.com/problems/move-pieces-to-obtain-a-string/

    //    Time Complexity: O(n)
//    Memory Complexity: O(n)
    public boolean canChange(String start, String target) {
        // Convert the strings to character arrays for easier access
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        int n = s.length; // Length of the strings
        int i = 0, j = 0; // Pointers for iterating through `s` and `t`

        // Iterate through both strings until either pointer reaches the end
        while (i <= n && j <= n) {

            // Move `i` to the next non-'_' character in `s`
            while (i < n && s[i] == '_') i++;

            // Move `j` to the next non-'_' character in `t`
            while (j < n && t[j] == '_') j++;

            // If either pointer reaches the end, ensure both pointers are at the end
            if (i == n || j == n) return i == n && j == n;

            // If the current characters in `s` and `t` do not match, return false
            if (s[i] != t[j]) return false;

            // Check if the movement rules for 'L' and 'R' are violated
            if (s[i] == 'L' && i < j) return false; // 'L' cannot move right
            else if (s[i] == 'R' && i > j) return false; // 'R' cannot move left

            // Move both pointers to the next position
            i++;
            j++;
        }
        // If the loop completes without returning false, the transformation is valid
        return true;
    }
}
