package leetcode.editor.cn;

/**
 * [154] 寻找旋转排序数组中的最小值 II
 */
public class FindMinimumInRotatedSortedArrayIi {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int findMin(int[] nums) {
			int left = 0, right = nums.length - 1, mid;
			while (true) {
				if (right - left <= 1) {
					return Math.min(nums[right], nums[left]);
				}
				mid = (left + right) / 2;

				// 等于右边的情况 特殊处理
				if (nums[mid] == nums[right]) {
					right--;
				} else if (nums[mid] > nums[right]) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}