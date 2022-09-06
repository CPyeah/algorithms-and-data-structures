package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [494] 目标和
 */
public class TargetSum {

	public static void main(String[] args) {
		Solution solution = new TargetSum().new Solution();
		solution.findTargetSumWays(new int[]{1}, 2);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int findTargetSumWays(int[] nums, int target) {
			Map<Integer, Integer> dp =new HashMap<>();
			dp.put(nums[0], dp.getOrDefault(nums[0], 0)+1);
			dp.put(-nums[0], dp.getOrDefault(-nums[0], 0)+1);
			for (int i = 1; i < nums.length; i++) {
				Map<Integer, Integer> newDP =new HashMap<>();
				int n = nums[i];
				dp.forEach((k, v) -> {
					int leftKey = k - n;
					newDP.put(leftKey, newDP.getOrDefault(leftKey, 0) + v);
					int rightKey = k + n;
					newDP.put(rightKey, newDP.getOrDefault(rightKey, 0) + v);
				});
				dp = newDP;
			}
			return dp.getOrDefault(target, 0);
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}