package leetcode.editor.cn.sort;

/**
 * 希尔排序：
 * <p>
 * 1 按照间隔分组（初始间隔一般是数组长度的一般）
 * <p>
 * 2 排序每个组（插入排序法）
 * <p>
 * 3 间隔减小，重新分组（新的间隔一般为原间隔的一般，最后为1）
 * <p>
 * 4 再排序每个组
 */
public class ShellSort {

	public static class Solution {

		public int[] sort(int[] nums) {
			int interval = nums.length / 2;
			while (interval > 0) {
				insertSortByInterval(nums, interval);
				interval = interval / 2;
			}
			return nums;
		}

		private void insertSortByInterval(int[] nums, int interval) {
			for (int i = 0; i < interval; i++) {
				for (int j = i + interval; j < nums.length; j += interval) {
					insertSortByInterval(nums, j, interval);
				}
			}
		}

		//  0  x  x  2  x  x  3  x  x  1  x  x
		//                    i        s
		private void insertSortByInterval(int[] nums, int startIndex, int interval) {
			int value = nums[startIndex];
			int i = startIndex - interval;
			while (i >= 0 && nums[i] > value) {
				nums[i + interval] = nums[i];
				nums[i] = value;
				i -= interval;
			}
		}
	}

}
