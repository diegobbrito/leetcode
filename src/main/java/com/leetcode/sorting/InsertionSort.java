package com.leetcode.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		var array = new int[]{8,5,3,9,2};
		insertionSort(array);

		for (int j : array) {
			System.out.println(j);
		}
	}

	private static void insertionSort(int[] array) {
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
}
