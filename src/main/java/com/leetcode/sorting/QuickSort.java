package com.leetcode.sorting;

public class QuickSort {

	// Runtime Complexity = Best/Average Case O(n log(n))
	// Worst Case O(nˆ2) if its already sorted

	public static void main(String[] args) {
		var array = new int[]{8,5,3,9,2};
		quickSort(array, 0, array.length - 1);

		for (int j : array) {
			System.out.println(j);
		}
	}

	private static void quickSort(int[] array, int start, int end) {
		//Call recursively until the end is less or equal to the start
		if(end <= start) return;

		// Get the pivot index, will at the right index
		int pivot = partition(array, start, end);

		//Sort the array to the start until pivot -1
		quickSort(array, start, pivot - 1);
		//Sort the array to the pivot + 1 until the end
		quickSort(array, pivot + 1, end);
	}

	private static int partition(int[] array, int start, int end){
		//Select a pivot element, this case, the last one
		int pivot = array[end];
		// Get the i and j with the start index
		int i = start;
		//Iterate between start and end element, swapping all the element that and less than the pivot value
		for (int j = start; j < end; j++) {
			if(array[j] < pivot){
				swap(array, i, j);
				i++;
			}
		}
		// Swap the element at i index with the element at the end (the pivot index)
		// All element at the left will be smaller and all element to the right will be bigger than the pivot
		swap(array, i, end);
		return i;
	}
	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
