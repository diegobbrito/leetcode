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
		// Recursively call the method until the size of the array is less than 2
		if(length < 2 ) return;

		// Get the middle of the array, create left and right arrays, with middle size and length - middle size
		var middle = length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];

		//Add all the element to the right and left array
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

		//Merge the left and right array in the initial array
		merge(leftArray, rightArray, array);
	}

	private static void merge(int[] leftArray, int[] rightArray, int[] array) {
		//Get the size of the array and create index for the 3 arrays
		int leftSize = leftArray.length;
		int rightSize = rightArray.length;
		int index = 0, leftIndex = 0, rightIndex = 0;

		//Sort the array checking the values between left and right array, and updating all index
		while (leftIndex < leftSize && rightIndex < rightSize){
			if (leftArray[leftIndex] < rightArray[rightIndex])
				array[index++] = leftArray[leftIndex++];
			else
				array[index++] = rightArray[rightIndex++];
		}

		//Add remaining values of the arrays to the initial array
		while(leftIndex < leftSize)
			array[index++] = leftArray[leftIndex++];

		while(rightIndex < rightSize)
			array[index++] = rightArray[rightIndex++];
	}
}
