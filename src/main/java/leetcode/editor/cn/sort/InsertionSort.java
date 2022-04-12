package leetcode.editor.cn.sort;

/**
 * 插入排序， 找到一个元素，向前扫描，前面但往后移动，在合适但地方插入
 */
public class InsertionSort {

	public static class Solution {

		public int[] sort(int[] nums) {
			if (nums.length < 2) {
				return nums;
			}
			// 1   3   2
			//     j   i
			// 1   2   3
			// j       i
			for (int i = 1; i < nums.length; i++) {
				int indexValue = nums[i];
				// 往左扫描
				for (int j = i - 1; j >= 0; j--) {
					// 如果indexValue比较小，j往右移动
					// 同时把 i的值填充进去
					if (indexValue < nums[j]) {
						nums[j + 1] = nums[j];
						nums[j] = indexValue;
					} else {
						// 已经找到比当前小的了， 跳出此轮循环
						break;
					}
				}
			}
			return nums;
		}
	}

}
