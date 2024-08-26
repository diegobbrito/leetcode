package com.leetcode.twopointers;

public class MergeSortedArray {

//    https://leetcode.com/problems/merge-sorted-array/

    //    Time Complexity O(m + n)
//    Space Complexity O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int i = nums1.length - 1;
        while (m >= 0 && n >= 0)
            if (nums1[m] > nums2[n])
                nums1[i--] = nums1[m--];
            else
                nums1[i--] = nums2[n--];
        while (n >= 0)
            nums1[i--] = nums2[n--];

    }

    //    Time Complexity O(m + n logm+n)
    //    Space Complexity O(m+n)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        quickSort(nums1, 0, (m + n - 1));
    }

    public void quickSort(int[] array, int start, int end) {
        if (end <= start) return;

        int pivot = array[end];

        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        var temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        pivot = i;

        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
}
