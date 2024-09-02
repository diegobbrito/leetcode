package com.leetcode.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    //    https://leetcode.com/problems/single-number/
//    Time Complexity O(n)
//    Space Complexity O(1)
    public int singleNumber(int[] nums) {
        int responseXor = 0;  // Initialize a variable to store the XOR result

        // Iterate through each number in the array
        for (int num : nums) {
            // XOR the current number with the accumulated result
            // XORing a number with itself cancels it out (resulting in 0)
            // XORing with 0 keeps the number unchanged
            // Since every number except one appears twice, all pairs will cancel out,
            // leaving only the single number
            responseXor ^= num;
        }

        // Return the single number that appears only once in the array
        return responseXor;
    }


    //    Time Complexity O(n)
    //    Space Complexity O(n)
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
}
