package com.leetcode.twopointers;

import java.util.*;


public class ThreeSum {
//    https://leetcode.com/problems/3sum/

    //Time Complexity:O(n2)
//  Sorting the array takes O(nlogn), where n is the length of the array.
//  After sorting, we iterate through the array, and for each element, we use the two-pointer technique. This takes𝑂(𝑛2)
// because for each i, the two-pointer technique checks a subarray of size n−i,
// which results in a quadratic time complexity.
// Space Complexity:Sorting in-place uses O(1) extra space.
    public List<List<Integer>> threeSum(int[] nums) {
        // Step 1: Sort the array to make it easier to avoid duplicates and use two-pointer technique
        Arrays.sort(nums);
        // Initialize the result list to store the triplets that sum to zero
        List<List<Integer>> result = new ArrayList<>();
        // Iterate through the array, but only up to the third last element to leave room for three elements
        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid processing duplicates by skipping over repeated values for the first element
            if (i == 0 || nums[i] != nums[i - 1]) {
                // Initialize two pointers: left (next element) and right (last element)
                int left = i + 1;
                int right = nums.length - 1;
                // Use two-pointer technique to find the two other elements that sum with nums[i] to zero
                while (left < right) {
                    // Calculate the sum of the current triplet
                    int sum = nums[i] + nums[left] + nums[right];
                    // If the sum is greater than 0, we need to decrease it by moving the right pointer leftward
                    if (sum > 0) {
                        right--;
                        // If the sum is less than 0, we need to increase it by moving the left pointer rightward
                    } else if (sum < 0) {
                        left++;
                        // If the sum is exactly zero, we found a valid triplet
                    } else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // Move the left pointer to the next distinct value to avoid duplicates
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Move the right pointer to the previous distinct value to avoid duplicates
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // After processing the current valid triplet, move both pointers
                        left++;
                        right--;
                    }
                }
            }
        }
        // Return the list of all valid triplets
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        // Sort the array to make it easier to work with
        Arrays.sort(nums);

        // List to store the result triplets
        List<List<Integer>> result = new ArrayList<>();

        // Traverse the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Initialize two pointers
            int left = i + 1;
            int right = nums.length - 1;

            // Find valid triplets
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If the sum is zero, we found a triplet
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move left pointer to the next different element
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Move right pointer to the next different element
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                // If the sum is too small, move the left pointer to increase the sum
                else if (sum < 0) {
                    left++;
                }
                // If the sum is too large, move the right pointer to decrease the sum
                else {
                    right--;
                }
            }
        }

        // Return the result list
        return result;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Iterate through each element in the array as the first element of the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Use a HashSet to check for the second and third element of the triplet
            Set<Integer> seen = new HashSet<>();
            int target = -nums[i];  // We want nums[j] + nums[k] = -nums[i]

            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];  // nums[k] should be equal to complement

                if (seen.contains(complement)) {
                    // If complement is found, we have a valid triplet
                    result.add(Arrays.asList(nums[i], nums[j], complement));

                    // Skip duplicates for the second element of the triplet
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }

                // Add the current number to the set for future checks
                seen.add(nums[j]);
            }
        }

        return result;
    }


}
