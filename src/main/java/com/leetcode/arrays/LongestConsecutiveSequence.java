package com.leetcode.arrays;

public class LongestConsecutiveSequence {
    //    https://leetcode.com/problems/longest-consecutive-sequence/description/
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        mergeSort(nums);
        int result = 1;
        int aux = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                result++;
            } else if (nums[i] == nums[i + 1]) {
                continue;
            } else {
                aux = result > aux ? result : aux;
                result = 1;
            }
        }
        return result > aux ? result : aux;
    }

    private static void mergeSort(int[] nums) {
        int length = nums.length;
        if (length < 2) return;

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        for (int i = 0; i < middle; i++) {
            leftArray[i] = nums[i];
        }
        for (int i = middle; i < length; i++) {
            rightArray[i - middle] = nums[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(nums, leftArray, rightArray);

    }

    private static void merge(int[] nums, int[] leftArray, int[] rightArray) {
        int i = 0, left = 0, right = 0;
        int leftSize = leftArray.length, rightSize = rightArray.length;
        while (left < leftSize && right < rightSize) {
            if (leftArray[left] < rightArray[right]) {
                nums[i++] = leftArray[left++];
            } else {
                nums[i++] = rightArray[right++];
            }
        }
        while (left < leftSize) {
            nums[i++] = leftArray[left++];
        }
        while (right < rightSize) {
            nums[i++] = rightArray[right++];
        }
    }
}
