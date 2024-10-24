package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
//    https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    //  Time Complexity: O(4^n), because for each digit, the algorithm explores all possible combinations of letters.
//  Memory Complexity O(n * 4^n)
    List<String> result; // List to store all possible letter combinations

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>(); // Initialize result list
        if (digits.isEmpty()) {
            return result; // Return empty list if input is null or empty
        }
        backtrack("", digits, 0); // Start backtracking with an empty string, input digits, and index 0
        return result; // Return the final list of combinations
    }

    private void backtrack(String curr, String digits, int index) {
        // Base case: If the length of the current combination equals the length of the digits, it's a valid combination
        if (curr.length() == digits.length()) {
            result.add(curr); // Add the current combination to the result list
        } else {
            var digit = digits.charAt(index); // Get the current digit at the index
            // Use a switch statement to map digits to corresponding letters and backtrack with the new combination
            switch (digit) {
                case '2' -> {
                    backtrack(curr + "a", digits, index + 1); // For digit '2', append 'a', 'b', 'c' and backtrack
                    backtrack(curr + "b", digits, index + 1);
                    backtrack(curr + "c", digits, index + 1);
                }
                case '3' -> {
                    backtrack(curr + "d", digits, index + 1); // For digit '3', append 'd', 'e', 'f' and backtrack
                    backtrack(curr + "e", digits, index + 1);
                    backtrack(curr + "f", digits, index + 1);
                }
                case '4' -> {
                    backtrack(curr + "g", digits, index + 1); // For digit '4', append 'g', 'h', 'i' and backtrack
                    backtrack(curr + "h", digits, index + 1);
                    backtrack(curr + "i", digits, index + 1);
                }
                case '5' -> {
                    backtrack(curr + "j", digits, index + 1); // For digit '5', append 'j', 'k', 'l' and backtrack
                    backtrack(curr + "k", digits, index + 1);
                    backtrack(curr + "l", digits, index + 1);
                }
                case '6' -> {
                    backtrack(curr + "m", digits, index + 1); // For digit '6', append 'm', 'n', 'o' and backtrack
                    backtrack(curr + "n", digits, index + 1);
                    backtrack(curr + "o", digits, index + 1);
                }
                case '7' -> {
                    backtrack(curr + "p", digits, index + 1); // For digit '7', append 'p', 'q', 'r', 's' and backtrack
                    backtrack(curr + "q", digits, index + 1);
                    backtrack(curr + "r", digits, index + 1);
                    backtrack(curr + "s", digits, index + 1);
                }
                case '8' -> {
                    backtrack(curr + "t", digits, index + 1); // For digit '8', append 't', 'u', 'v' and backtrack
                    backtrack(curr + "u", digits, index + 1);
                    backtrack(curr + "v", digits, index + 1);
                }
                case '9' -> {
                    backtrack(curr + "w", digits, index + 1); // For digit '9', append 'w', 'x', 'y', 'z' and backtrack
                    backtrack(curr + "x", digits, index + 1);
                    backtrack(curr + "y", digits, index + 1);
                    backtrack(curr + "z", digits, index + 1);
                }
            }
        }
    }
}

class Solution2 {
    List<String> result; // List to store all letter combinations
    Map<Character, String> phoneMap; // HashMap to store digit-letter mapping

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>(); // Initialize the result list
        phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        if (digits == null || digits.isEmpty()) {
            return result; // Return an empty list if the input is null or empty
        }
        backtrack("", digits, 0); // Start backtracking
        return result; // Return the final list of combinations
    }

    private void backtrack(String curr, String digits, int index) {
        // Base case: If the current combination length equals the digits length, it's a valid combination
        if (curr.length() == digits.length()) {
            result.add(curr); // Add the combination to the result list
        } else {
            char digit = digits.charAt(index); // Get the digit at the current index
            String letters = phoneMap.get(digit); // Retrieve the corresponding letters from the HashMap
            for (char letter : letters.toCharArray()) { // Iterate through each letter for this digit
                backtrack(curr + letter, digits, index + 1); // Backtrack with the next combination
            }
        }
    }
}
