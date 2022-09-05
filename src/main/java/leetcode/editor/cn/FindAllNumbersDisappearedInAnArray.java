package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [448] 找到所有数组中消失的数字
 */
public class FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		// [4,3,2,7,8,2,3,1]
		// [-4,-3,-2,-7,8,2,-3,-1][
		public List<Integer> findDisappearedNumbers(int[] nums) {
			for (int i = 0; i < nums.length; i++) {
				int nextIndex = Math.abs(nums[i]) - 1;
				if (nums[nextIndex] > 0) {
					nums[nextIndex] = -nums[nextIndex];
				}
			}
			List<Integer> ans = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > 0) {
					ans.add(i+1);
				}
			}
			return ans;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}