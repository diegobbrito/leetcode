package com.leetcode.arrays;

public class MaximumNumberBalloons {

    //  Time Complexity O(n)
//  Space Complexity O(1)
    public static int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case 'b' -> b++;
                case 'a' -> a++;
                case 'l' -> l++;
                case 'o' -> o++;
                case 'n' -> n++;
            }
        }

        int result = Math.min(b, a);
        result = Math.min(result, l / 2);
        result = Math.min(result, o / 2);
        return Math.min(result, n);
    }

    //  Time Complexity O(n)
    //  Space Complexity O(1)
//    This implementation is slightly more efficient in terms of execution time for each operation
//    compared to the first method, as it uses a single loop with direct index access instead of a switch-case structure.
//    However, the overall time complexity remains 𝑂(𝑛) for both
    public int maxNumberOfBalloons2(String str) {
        int[] arr = new int[26];
        for (char c : str.toCharArray()) arr[c - 'a']++;

        int max = Math.min(arr['b' - 'a'], arr['a' - 'a']);
        max = Math.min(max, arr['l' - 'a'] / 2);
        max = Math.min(max, arr['o' - 'a'] / 2);
        return Math.min(max, arr['n' - 'a']);
    }
}
