package com.leetcode.arrays;

public class MinimumSwaps2 {

    //https://www.hackerrank.com/challenges/minimum-swaps-2/problem
    //Time complexity: O(n^2), Space complexity: O(1)
    public int minimumSwaps(int[] arr) {

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == i + 1) {
                    swap(arr, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Time complexity: O(n), Space complexity: O(1)
    public int minimumSwaps2(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) continue;
            swap(arr, i, arr[i] - 1);//arr[i] - 1 is the correct position of arr[i]
            result++;//swap once
            i--;//check the current position again
        }

        return result;
    }

}
