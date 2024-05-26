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

		if(end <= start) return;

		int pivot = partition(array, start, end);

		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	private static int partition(int[] array, int start, int end){
		int pivot = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if(array[j] < pivot){
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		i++;
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;
		return i;
	}
}
