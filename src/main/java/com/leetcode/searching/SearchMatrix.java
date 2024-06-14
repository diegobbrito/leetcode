package com.leetcode.searching;

public class SearchMatrix {

	public static void main(String[] args) {
		int[][] test = new int[][]{{1}, {3}};
		boolean b = searchMatrix(test, 3);
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int size = matrix.length;
		int i = 0;
		for (; i < size; i++) {
			if(hasTarget(matrix[i], target))
				break;
		}
		if(i >= size)
			return false;
		return binarySearch(matrix[i], target);
	}

	public static boolean binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right){
			int middle = left + (right - left) / 2;
			if (target > nums[middle])
				left = middle + 1;
			else if(target < nums[middle])
				right = middle - 1;
			else return true;
		}
		return false;
	}

	private static boolean hasTarget(int[] array, int target){
		return (target >= array[0] && target <= array[array.length -1]);
	}
}
