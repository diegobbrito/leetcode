package com.leetcode.arrays;

public class ReplaceElementsGreatestElementRightSide {
    //    https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
    //    Time Complexity O(n2)
    //    Memory complexity O(1)
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int greatest = arr[i + 1];
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (greatest < arr[j]) greatest = arr[j];
            }
            arr[i] = greatest;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    //    Time Complexity O(n)
    //    Memory complexity O(1)
    public int[] replaceElements2(int[] arr) {
        int greatest = -1; //Last element will always be -1
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];  //Keep the value in a temp variable
            arr[i] = greatest; // Add the greatest value to the array at the index
            if (greatest < temp) greatest = temp; // Update the greatest value variable
        }
        return arr;
    }
}
