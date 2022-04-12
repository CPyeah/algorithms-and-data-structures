package leetcode.editor.cn.sort;

/**
 * 选择排序， 每次循环找出最小值，往前面换
 */
public class SelectionSort {

	public static class Solution {

		public int[] sort(int[] nums) {
			int minIndex;
			for (int i = 0; i < nums.length - 1; i++) {
				minIndex = i;
				for (int j = i; j < nums.length; j++) {
					if (nums[j] < nums[minIndex]) {
						minIndex = j;
					}
				}
				SortUtil.swap(nums, i, minIndex);
			}
			return nums;
		}
	}

}
