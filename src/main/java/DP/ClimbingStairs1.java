package DP;

/**
 * 有一楼梯共m级，若每次只能跨上一级或二级，要走上第m级，共有多少走法？
 * <p>
 * 动态规划解法
 */
public class ClimbingStairs1 {

	public static class Solution1 {

		// f[n] = f[n-2] + f[n-1]
		public int climbingStairs(int step) {
			int[] dp = new int[step + 1];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			if (step < 0) {
				return -1;
			}
			for (int i = 3; i < step + 1; i++) {
				dp[i] = dp[i - 2] + dp[i - 1];
			}
			return dp[step];
		}
	}

}
