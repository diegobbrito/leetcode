package com.leetcode.sorting;

public class KthLargestElementArray {

	public static void main(String[] args) {
		findKthLargest(new int[] {3,2,1,5,6,4}, 2);
	}
	public static int findKthLargest(int[] nums, int k) {
		quickSort(nums, 0, nums.length - 1);

		return nums[nums.length - k];
	}

	private static void quickSort(int[] array, int start, int end){
		if(end <= start) return;

		int pivot = partition(array, start, end);

		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	private static int partition(int[] array, int start, int end){
		int pivot = array[end];
		int i = start - 1;

		for(int j = start; j < end; j++){
			if(array[j] < pivot){
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		i++;
		int temp = array[end];
		array[end] = array[i];
		array[i] = temp;
		return i;
	}
}
