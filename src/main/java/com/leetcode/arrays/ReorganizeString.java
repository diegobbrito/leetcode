package com.leetcode.arrays;

public class ReorganizeString {

    //    https://leetcode.com/problems/reorganize-string/
    // Time: O(n), Space: O(n)
    public String reorganizeString(String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        //Find the letter with the most frequency
        int max = 0;
        int letter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                letter = i;
            }
        }

        //If the most frequent letter is more than half the length of the string, it is impossible to reorganize
        if (max > (s.length() + 1) / 2) return "";

        //Fill the result array with the most frequent letter
        char[] result = new char[s.length()];
        int index = 0;
        while (arr[letter] > 0) {
            result[index] = (char) (letter + 'a');
            index += 2;
            arr[letter]--;
        }

        //Fill the result array with the rest of the letters
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index += 2;
                arr[i]--;
            }
        }

        return new String(result);
    }
}
