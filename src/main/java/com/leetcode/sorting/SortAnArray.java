package com.leetcode.sorting;

public class SortAnArray {
	//	https://leetcode.com/problems/sort-an-array/description/
	//First solution
	public int[] sortArray(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1; j++) {
				if(nums[j] > nums[j + 1]){
					int temp = nums[j];
					nums[j] = nums [j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		return nums;
	}
	public static void main(String[] args) {
		var array = new int[]{0,1,1,2,1,0,1};
		bucketSort(array);

		for (int j : array) {
			System.out.print(j + " ");
		}
	}

//	Insertion Sort Algorithm
	public static void insertionSort(int[] array){
		for (int i = 1; i < array.length; i++) {
			var current = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > current){
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = current;
		}
	}

//	Selection Sort Algorithm
	public static void selectionSort(int[] array){
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if(array[j] < array[minIndex])
					minIndex = j;
			}
			var temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

//	Merge Sort Algorithm
	 static void mergeSort(int[] array){
		int length = array.length;
		if(length < 2) return;

		int middle = length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];

		 for (int i = 0; i < middle; i++) {
			 leftArray[i] = array[i];
		 }
		 for (int i = middle; i < length; i++) {
			 rightArray[i - middle] = array[i];
		 }

		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(array, leftArray, rightArray);
	 }

	private static void merge(int[] array, int[] leftArray, int[] rightArray) {
		int index = 0;
		int left = 0;
		int right = 0;
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;

		while (left < leftSize && right < rightSize){
			if(leftArray[left] < rightArray[right]){
				array[index++] = leftArray[left++];
			} else {
				array[index++] = rightArray[right++];
			}
		}
		while (left < leftSize ){
				array[index++] = leftArray[left++];
		}
		while (right < rightSize){
				array[index++] = rightArray[right++];
		}

	}

//	Quick Sort Algorithm
	static void quickSort(int[] array, int start, int end){
		if (end <= start) return;
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	private static int partition(int[] array, int start, int end) {
		int i = start;
		int pivot = array[end];
		for (int j = start; j <= end; j++) {
			if(array[j] < pivot){
				var temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i++;
			}
		}
		var temp = array[end];
		array[end] = array[i];
		array[i] = temp;
		return i;
	}

//	Bucket Sort Algorithm
	static void bucketSort(int[] array){
		int[] bucket = new int[3];
		for (int i = 0; i < array.length; i++) {
			bucket[array[i]] += 1;
		}

		int index = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				array[index++] = i;
			}
		}
	}

//	Bubble Sort Algorithm
	static void bubbleSort(int[] array){
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if(array[j + 1] < array[j]){
					var temp = array[j];
					array[j] = array[j+1];
					array[j + 1] = temp;
				}
			}
		}
	}
}
