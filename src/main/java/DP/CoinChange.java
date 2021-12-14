package DP;


/**
 * https://leetcode-cn.com/problems/coin-change/
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {

	// 递归
	public static class Solution1 {

		public int coinChange(int[] coins, int amount) {
			int result = coinChange0(coins, amount);
			if (result == Integer.MAX_VALUE) {
				return -1;
			}
			return result;
		}

		// f(x) = min{ f(x-c[0])+1, f(x-c[1])+1 , f(x-c[2])+1 ... f(x-c[i])+1  }
		public int coinChange0(int[] coins, int amount) {
			if (amount < 0) {
				return Integer.MAX_VALUE;
			}
			if (amount == 0) {
				return 0;
			}
			int result = Integer.MAX_VALUE;
			for (int coin : coins) {
				int r = coinChange0(coins, amount - coin);
				if (r != Integer.MAX_VALUE && ++r < result) {
					result = r;
				}
			}
			return result;
		}

	}

	// 动态规划
	public static class Solution2 {

		public int coinChange(int[] coins, int amount) {
			int result = coinChange0(coins, amount);
			if (result == Integer.MAX_VALUE) {
				return -1;
			}
			return result;
		}

		public int coinChange0(int[] coins, int amount) {
			int[] dp = new int[amount + 1];
			dp[0] = 0;
			// f[1] f[2] f[3] .... f[27]
			for (int i = 1; i <= amount; i++) {
				dp[i] = getMinResult(coins, i, dp);
			}
			return dp[amount];
		}

		private int getMinResult(int[] coins, int i, int[] dp) {
			if (i < 0) {
				return Integer.MAX_VALUE;
			}
			int result = Integer.MAX_VALUE;
			// min{ F[i-coins[1]]+1, F[i-coins[2]]+1, .... F[i-coins[length]]+1 }
			for (int coin : coins) {
				int t = i - coin;
				// 注意边界
				if (t >= 0 && dp[t] != Integer.MAX_VALUE && dp[t] < result) {
					result = dp[t] + 1;
				}
			}
			return result;

		}
	}


}
