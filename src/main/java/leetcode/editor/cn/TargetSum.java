package leetcode.editor.cn;

/**
 * [494] 目标和
 */
public class TargetSum {

	public static void main(String[] args) {
		Solution solution = new TargetSum().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int findTargetSumWays(int[] nums, int target) {
			int[][] dp = new int[nums.length][2002];
			dp[0][1001 + nums[0]] += 1;
			dp[0][1001 - nums[0]] += 1;
			// dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
			for (int i = 1; i < dp.length; i++) {
				for (int j = 0; j < dp[0].length; j++) {
					dp[i][j] = getFromDP(dp, i-1, j-nums[i]) + getFromDP(dp, i-1, j+nums[i]);
				}
			}
			return dp[dp.length-1][1001+target];
		}

		private int getFromDP(int[][] dp, int i, int j) {
			if(j<0 || j>dp[0].length-1) {
				return 0;
			}
			return dp[i][j];
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}