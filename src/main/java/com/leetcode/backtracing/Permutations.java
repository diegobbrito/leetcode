package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
//    https://leetcode.com/problems/permutations/
//    Time Complexity:
//    The number of permutations of an array of size n is n! (factorial of n).
//    For each permutation, we copy the current list (which takes O(n) time), and the recursion explores all n! permutations.
//    Thus, the overall time complexity is O(n * n!), where n is the length of the input array.
//    Space Complexity:
//    The space complexity is dominated by the recursion call stack and the space needed to store the result.
//    The depth of the recursion is n (since we add one number to curr at each level),
//    and each permutation list has a size of n. The result stores n! permutations, so the space required for the result is O(n * n!).
//    The recursion stack itself uses O(n) space.
//    Therefore, the overall space complexity is O(n * n!).

    // Method to generate all permutations of an integer array 'nums'
    public List<List<Integer>> permute(int[] nums) {
        // 'result' will store all the permutations
        List<List<Integer>> result = new ArrayList<>();
        // Call the recursive helper function to generate permutations
        backtrack(result, new ArrayList<>(), nums);
        return result; // Return the list of permutations
    }

    // Helper method to recursively generate permutations using backtracking
    private void backtrack(List<List<Integer>> list, List<Integer> curr, int[] nums) {
        // Base case: if the current permutation 'curr' has the same size as 'nums', it's complete
        if (curr.size() == nums.length) {
            // Add a copy of the current permutation to the result list
            list.add(new ArrayList<>(curr));
        } else {
            // Iterate through each number in the array 'nums'
            for (int num : nums) {
                // If 'curr' already contains this number, skip it to avoid duplicates
                if (curr.contains(num)) continue;
                // Add the number to the current permutation
                curr.add(num);
                // Recursively build the permutation by adding more numbers
                backtrack(list, curr, nums);
                // Backtrack: remove the last added number to explore other possibilities
                curr.remove(curr.size() - 1);
            }
        }
    }
//    https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/
}
