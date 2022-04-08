package leetcode.editor.cn;

/**
 * [33] 搜索旋转排序数组
 */
public class SearchInRotatedSortedArray {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		//输入：nums = [4,5,6,7,0,1,2], target = 0
		//输出：4
		public int search(int[] nums, int target) {
			int left = 0, right = nums.length - 1, mid;
			while (true) {
				// 先判断下 target 在不在两边
				if (nums[left] == target) {
					return left;
				} else if (nums[right] == target) {
					return right;
				}
				// 两个指针相邻或重合
				if (right - left <= 1) {
					return -1;
				}

				mid = (left + right) / 2;
				if (nums[mid] == target) {
					return mid;
				}

				// 最小点 在右边  左边单调递增
				if (nums[mid] > nums[right]) {
					// 判断target在不在左边
					if (nums[left] < target && nums[mid] > target) {
						right = mid;
					} else {
						left = mid;
					}
				} else {
					// 最小点 在左边  右边单调递增
					// 判断target 在不在右边
					if (nums[mid] < target && nums[right] > target) {
						left = mid;
					} else {
						right = mid;
					}
				}

			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}