package leetcode.editor.cn.sort;

// 计数排序
public class CountingSort {

	public static class Solution {

		// [ 5, 3, 3, 2, 6, 7, 8, 9, 0, 4 ]   , 10
		public int[] sort(int[] nums, int maxValue) {

			// 定义计数数组
			int[] countingArray = new int[maxValue];

			// 把 nums 存放到计数数组中
			// [ 1, 0, 1, 2, 1, 1, 1, 1, 1, 1 ]
			for (int value : nums) {
				int count = countingArray[value];
				countingArray[value] = count + 1;
			}

			int numsIndex = 0;
			// 再把计数数组中的数据 反哺到nums中
			for (int i = 0; i < countingArray.length; i++) {
				int count = countingArray[i];
				for (int j = 0; j < count; j++) {
					nums[numsIndex] = i;
					numsIndex++;
				}
			}

			return nums;
		}
	}

}
