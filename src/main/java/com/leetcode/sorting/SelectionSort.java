package com.leetcode.sorting;

public class SelectionSort {
	public static void main(String[] args) {
		var array = new int[]{8,5,3,9,2};
		selectionSort(array);

		for (int j : array) {
			System.out.println(j);
		}
	}

	private static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++){
			int minIndex = i;
			for (int j = i + 1; j < array.length ; j++) {
				if(array[j] < array[minIndex])
					minIndex = j;
			}
			var temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}
}
