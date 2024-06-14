package com.leetcode.sorting;

public class MergeSort {

	public static void main(String[] args) {
		var array = new int[]{8,5,3,9,2};
		mergeSort(array);

		for (int j : array) {
			System.out.println(j);
		}
	}

	private static void mergeSort(int[] array) {
		int length = array.length;
		if(length < 2 ) return;

		var middle = length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];

		int i = 0;
		int j = 0;
		for (; i < length; i++){
			if( i < middle)
				leftArray[i] = array[i];
			else {
				rightArray[j] = array[i];
				j++;
			}
		}

		mergeSort(leftArray);
		mergeSort(rightArray);

		merge(leftArray, rightArray, array);
	}

	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		int index = 0, leftIndex = 0, rightIndex = 0;

		while (leftIndex < leftSize && rightIndex < rightSize){
			if (leftArray[leftIndex] < rightArray[rightIndex])
				array[index++] = leftArray[leftIndex++];
			else
				array[index++] = rightArray[rightIndex++];
		}

		while(leftIndex < leftSize)
			array[index++] = leftArray[leftIndex++];

		while(rightIndex < rightSize)
			array[index++] = rightArray[rightIndex++];
	}
}
