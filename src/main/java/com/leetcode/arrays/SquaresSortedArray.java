package com.leetcode.arrays;

public class SquaresSortedArray {
	public int[] sortedSquares(int[] nums) {
		int size = nums.length;
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = nums[i] * nums[i];
		}

		mergeSort(result);

		return result;
	}

	public static void mergeSort(int[] arr){
		if(arr.length < 2) return;
		int middle = arr.length / 2;
		int[] leftArr = new int[middle];
		int[] rightArr = new int[arr.length - middle];
		for (int i = 0; i < middle; i++) {
			leftArr[i] = arr[i];
		}
		for (int i = middle; i < arr.length; i++) {
			rightArr[i - middle] = arr[i];
		}

		mergeSort(leftArr);
		mergeSort(rightArr);
		merge(arr, leftArr, rightArr);
	}
	public static void merge(int[] arr, int[] leftArr, int[] rightArr){
		int left = 0, right = 0, index = 0;
		int leftSize = leftArr.length, rightSize = rightArr.length;

		while (left < leftSize && right < rightSize){
			if(leftArr[left] < rightArr[right])
				arr[index++] = leftArr[left++];
			else
				arr[index++] = rightArr[right++];
		}
		while (left < leftSize )
			arr[index++] = leftArr[left++];

		while (right < rightSize)
			arr[index++] = rightArr[right++];
	}
}
