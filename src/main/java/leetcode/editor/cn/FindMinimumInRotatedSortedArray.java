package leetcode.editor.cn;

/**
 * [153] 寻找旋转排序数组中的最小值
 */
public class FindMinimumInRotatedSortedArray {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		// 3,4,5,1,2
		// 1
		public int findMin(int[] nums) {
			int left = 0, right = nums.length - 1, mid;
			while (true) {
				if (right - left <= 1) {
					return Math.min(nums[right], nums[left]);
				}
				mid = (left + right) / 2;
				if (nums[mid] > nums[right]) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}