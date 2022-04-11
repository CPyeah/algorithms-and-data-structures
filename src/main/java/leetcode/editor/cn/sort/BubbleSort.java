package leetcode.editor.cn.sort;


/**
 * 冒泡排序
 * <p>
 * 两次循环，相邻的两个元素比较，小的往前
 * <p>
 * O(n2)
 */
public class BubbleSort {

	public static class Solution {

		public int[] sort(int[] nums) {
			// 注意边界， 不用到最后一个
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = 0; j < nums.length - i - 1; j++) {
					if (nums[j] > nums[j + 1]) {
						SortUtil.swap(nums, j, j + 1);
					}
				}
			}
			return nums;
		}
	}

}
