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
		if(length <= 1 ) return;

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
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		int i = 0;
		int l = 0;
		int r = 0;

		while (l < leftSize && r < rightSize){
			if ( leftArray[l] < rightArray[r]){
				array[i] = leftArray[l];
				i++;
				l++;
			}else{
				array[i] = rightArray[r];
				i++;
				r++;
			}

		}

		while(l < leftSize){
			array[i] = leftArray[l];
			l++;
			i++;
		}

		while(r < rightSize){
			array[i] = rightArray[r];
			r++;
			i++;
		}
	}
}
