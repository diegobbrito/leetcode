package com.leetcode.sorting;

public class BubbleSort {

//	Complexity time = O(nˆ2)
	public void bubbleSort(int[] array){
		for (int i = 0, length = array.length; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) { // the length - i - 1 is because the last element will be sorted
				if(array[j] > array[j + 1]){
					var temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}
