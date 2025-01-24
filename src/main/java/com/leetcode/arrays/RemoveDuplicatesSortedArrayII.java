package com.leetcode.arrays;

public class RemoveDuplicatesSortedArrayII {
    //    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
//    Time complexity: O(n), where n is the number of elements in the input array.
//    Space complexity: O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        var i = 2; // i is the slow pointer
        for (var j = 2; j < nums.length; j++) { // j is the fast pointer
            if (nums[j] != nums[i - 2]) // if the current element is not equal to the element two steps back
                nums[i++] = nums[j]; // copy the current element to the slow pointer and increment the slow pointer
        }
        return i;
    }

    //    Time complexity: O(n), where n is the number of elements in the input array.
//    Space complexity: O(1)
    public int removeDuplicates2(int[] nums) {
        int left = 0, right = 0, size = nums.length;
        while (right < size) {
            int count = 1;
            while (right + 1 < size && nums[right] == nums[right + 1]) {
                right++;
                count++;
            }
            for (int i = 0; i < Math.min(2, count); i++) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }
}
