package leetcode.editor.cn;

/**
 * [416] 分割等和子集
 */
public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		Solution solution = new PartitionEqualSubsetSum().new Solution();
		solution.canPartition(new int[]{100});
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public boolean canPartition(int[] nums) {
			// get target
			int target = 0;
			for (int n : nums) {
				target += n;
			}
			if (target % 2 != 0) {
				return false;
			}
			target = target / 2;

			boolean [][]dp = new boolean[nums.length][target+1];
			dp[0][0] = true;
			if(nums[0] < dp[0].length) {
				dp[0][nums[0]] = true;
			}
			for (int i = 1; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					if (j - nums[i] > -1) {
						dp[i][j] = dp[i - 1][j] || dp[i-1][j - nums[i]];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}

			return dp[dp.length-1][dp[0].length-1];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}