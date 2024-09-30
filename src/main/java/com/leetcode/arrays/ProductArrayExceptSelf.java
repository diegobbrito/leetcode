package com.leetcode.arrays;

public class ProductArrayExceptSelf {
    //    https://leetcode.com/problems/product-of-array-except-self/

//Total time complexity: O(n).
//First loop (prefix pass): O(n) where n is the length of the array.
//Second loop (postfix pass): O(n) as well.

    //Space Complexity:
//The result array takes O(n) space.
//The variables prefix and postfix use O(1) extra space (constant).
//The total space complexity is O(n) (for the result array).
// However, the problem typically requires O(1) extra space, excluding the output array, so this solution satisfies that.
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        // Result array to hold the final products, initialized to correct size
        int[] result = new int[length];

        // Variables to hold the prefix and postfix products
        int prefix = 1;
        int postfix = 1;

        // First pass: populate the result array with prefix products
        // Time complexity: O(n) where n is the number of elements in the input array
        for (int i = 0; i < length; i++) {
            result[i] = prefix;  // Assign the prefix product to result[i]
            prefix *= nums[i];    // Update the prefix product by multiplying with nums[i]
        }

        // Second pass: update the result array with postfix products
        // Time complexity: O(n) as well
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= postfix;  // Multiply the current result[i] by the postfix product
            postfix *= nums[i];    // Update the postfix product for the next iteration
        }

        // Return the final result array, which contains products except self
        return result;
    }

}
