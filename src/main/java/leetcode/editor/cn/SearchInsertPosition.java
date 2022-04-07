package leetcode.editor.cn;

/**
 * [35] 搜索插入位置
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		Solution solution = new SearchInsertPosition().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int searchInsert(int[] nums, int target) {
			int left = 0, right = nums.length - 1;
			while (true) {
				if (nums[left] >= target) {
					return left;
				}
				if (nums[right] == target) {
					return right;
				}
				if (nums[right] < target) {
					return right + 1;
				}
				if (right - left <= 1) {
					return right;
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