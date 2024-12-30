package com.leetcode.twopointers;

public class RotateArray {
    //    https://leetcode.com/problems/rotate-array/?
//    Brute Force
//    Time complexity: O(n * k)
//    Space complexity: O(1)
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) return;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    //    Using Extra Array
//    Time complexity: O(n)
//    Space complexity: O(n)
    public void rotate2(int[] nums, int k) {
        if (nums.length < 2) return;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i]; //(i+k) % nums.length is the new index
        }
        //copy the elements of arr to nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }

    //    Using Reverse
//    Time complexity: O(n)
//    Space complexity: O(1)
    public void rotate3(int[] nums, int k) {
        int n = nums.length - 1; //last index
        k = k % nums.length; //if k > n
        reverse(nums, 0, n); //reverse the whole array
        reverse(nums, 0, k - 1); //reverse the first k elements
        reverse(nums, k, n); //reverse the rest of the elements
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
