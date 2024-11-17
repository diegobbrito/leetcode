package com.leetcode.linkedlist;

public class FindDuplicateNumber {
    //Fast And Slow Pointers
    //Time complexity: O(n)
    //Space complexity: O(1)
        public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    //Negative Marking
    //Time complexity: O(n)
    //Space complexity: O(1)

    public int findDuplicate2(int[] nums) {
        for(int num: nums){
            int idx = Math.abs(num) - 1;
            if(nums[idx] < 0) return Math.abs(num);
            nums[idx] *= -1;
        }
        return -1;
    }

}