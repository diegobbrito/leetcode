package com.leetcode.searching;

public class FindFirstLastPositionElementSortedArray {
    //    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//    Time Complexity O(n)
//    Memory Complexity O(1)
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        if (size < 1) return new int[]{-1, -1};
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int min = mid, max = mid;
                while (min >= 0 && nums[min] == target)
                    min--;
                while (max < size && nums[max] == target)
                    max++;
                min++;
                max--;
                return new int[]{min, max};
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return new int[]{-1, -1};
    }

    //    Time Complexity O(logn)
    //    Memory Complexity O(1)
    class Solution {
        private static int binarySearch(int[] nums, int target, boolean leftBias) {
            int left = 0, right = nums.length - 1;
            int i = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target)
                    left = mid + 1;
                else if (nums[mid] > target)
                    right = mid - 1;
                else {
                    i = mid;
                    if (leftBias)
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }
            return i;
        }

        public int[] searchRange(int[] nums, int target) {
            int left = binarySearch(nums, target, true);
            int right = binarySearch(nums, target, false);
            return new int[]{left, right};
        }
    }
}
