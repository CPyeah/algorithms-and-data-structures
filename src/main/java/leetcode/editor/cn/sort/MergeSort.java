package leetcode.editor.cn.sort;


import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

	public static class Solution {

		public int[] sort(int[] nums) {
			return mergeSort(nums);
		}

		// 递归方法
		private int[] mergeSort(int[] nums) {
			// 递归出口
			if (nums.length < 2) {
				return nums;
			}
			// 分成两个数组
			int m = nums.length / 2;
			int[] left = Arrays.copyOfRange(nums, 0, m);
			int[] right = Arrays.copyOfRange(nums, m, nums.length);
			// 对这两个数组做排序
			left = mergeSort(left);
			right = mergeSort(right);
			// 合并这两个排序好的数组
			return mergeSort(left, right);
		}

		// 对两个排序好的数组做合并
		private int[] mergeSort(int[] left, int[] right) {
			int length = left.length + right.length;
			int[] merged = new int[length];
			int leftIndex = 0, rightIndex = 0;
			for (int i = 0; i < length; i++) {
				if (leftIndex < left.length && rightIndex < right.length) {
					int leftValue = left[leftIndex];
					int rightValue = right[rightIndex];
					if (leftValue < rightValue) {
						merged[i] = leftValue;
						leftIndex++;
					} else {
						merged[i] = rightValue;
						rightIndex++;
					}
				} else if (leftIndex >= left.length) {
					merged[i] = right[rightIndex];
					rightIndex++;
				} else {
					merged[i] = left[leftIndex];
					leftIndex++;
				}
			}
			return merged;
		}
	}

}
