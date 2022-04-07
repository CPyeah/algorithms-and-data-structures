package leetcode.editor.cn;

/**
 * [704] 二分查找
 */
public class BinarySearch {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int search(int[] nums, int target) {
			int left = 0, right = nums.length - 1;
			while (true) {
				if (nums[left] == target) {
					return left;
				}
				if (nums[right] == target) {
					return right;
				}
				if (right - left <= 1) {
					return -1;
				}
				int mid = (left + right) / 2;
				if (nums[mid] == target) {
					return mid;
				}
				if (nums[mid] < target) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}