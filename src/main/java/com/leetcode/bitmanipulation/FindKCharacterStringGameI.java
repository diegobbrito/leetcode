package com.leetcode.bitmanipulation;

public class FindKCharacterStringGameI {

//    https://leetcode.com/problems/find-the-k-th-character-in-string-game-i

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public char kthCharacter(int k) {

        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            int size = sb.length();
            for (int i = 0; i < size; i++) {
                sb.append((char) ('a' + ((sb.charAt(i) - 'a') + 1) % 26));
            }
        }
        return sb.charAt(k - 1);

    }

}
