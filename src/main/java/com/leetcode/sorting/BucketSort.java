package com.leetcode.sorting;

public class BucketSort {
	public static void main(String[] args) {
		var array = new int[]{2,0,0,1,2,1,2};
		bucketSort(array, 3);

		for (int j : array) {
			System.out.println(j);
		}
	}

	private static void bucketSort(int[] array, int range) {
		int[] bucket = new int[range];
		for (int i = 0; i < array.length; i++) {
			bucket[array[i]] += 1;
		}

		int index = 0;
		for (int i = 0; i < bucket.length; i++) {
			var temp = bucket[i];
			for (int j = 0; j < temp; j++) {
				array[index++] = i;
			}
		}
	}
}
