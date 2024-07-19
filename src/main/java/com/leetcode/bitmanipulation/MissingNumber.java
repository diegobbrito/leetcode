package com.leetcode.bitmanipulation;

public class MissingNumber {
    //    https://leetcode.com/problems/missing-number/
    public static void main(String[] args) {
        System.out.println(missingNumber3(new int[]{0, 2, 3, 4}));
    }

    // Time complexity O(n)
    // Space complexity O(1)
    public static int missingNumber(int[] nums) {
        int count = nums.length;
        int response = 0;
        for (int i = 0; i < nums.length; i++) {
            count += i;
            response += nums[i];
        }
        return count - response;
    }

    public static int missingNumber1(int[] nums) {
        int response = nums.length;
        for (int i = 0; i < nums.length; i++)
            response += (i - nums[i]);
        return response;
    }

    public static int missingNumber2(int[] nums) {
        int sum = 0, total = nums.length * (nums.length + 1) / 2; // Add Gauss formula to get total value
        for (int num : nums)
            sum += num;
        return total - sum;
    }

    //    5 ^ 0 = 0
    //    5 ^ 5 = 0
    //    4 ^ 5 = 5 ^ 4
    //    We will xor each number present in the nums to itself.
    //    Then will xor it with every number present in the range [0,n].
    public static int missingNumber3(int[] nums) {
        int responseXor = 0;
        for (int num : nums) responseXor ^= num;
        for (int i = 0; i <= nums.length; i++) {
            responseXor ^= i;
        }
        return responseXor;
    }


}
