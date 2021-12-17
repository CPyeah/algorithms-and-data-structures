package DP;

/**
 * 硬币。
 * <p>
 * 给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * <p>
 * (结果可能会很大，你需要将结果模上1000000007)
 */
public class CoinWayToChange {

	/**
	 * 1 -> f(n) 1 5 -> f(n) + f(n-5) + f(n-2*5) ... + f(n-x*5)   [n-x*5 > 0] 1 5 10 -> ...
	 * <p>
	 * f(k, n)  使用前k个硬币 表示n分 f(k-1, n) 使用前k-1个硬币，表示n分，第k种硬币用了0个
	 * <p>
	 * f(k, n) = f(k-1, n) + f(k-1, n-C[k]) + f(k-1, n-2*C[k]) + ... + f(k-1, n-i*C[k]) f(k, n) =
	 * SUM(f(k-1, n-i*C[k]))  (i从0开始， 到n-i*C[k]小于0)
	 */
	public static class Solution1 {

		static final int MOD = 1000000007;
		int[] coins = {0, 1, 5, 10, 25};

		// f(n) = f(n-25) + 1
		public int way2Change(int n) {
			return func(4, n) % MOD;
		}

		/**
		 * 使用前k种硬币，表示n分，有多少种表示方式
		 * <p>
		 * SUM(f(k-1, n-i*C[k]))  (i从0开始， 到n-i*C[k]小于0)
		 *
		 * @param k 硬币种数
		 * @param n 目标分
		 * @return 表示方式的种数
		 */
		int func(int k, int n) {
			if (k == 1) {
				return 1;
			}
			int result = 0;
			for (int i = 0; n - i * coins[k] >= 0; i++) {
				result += func(k - 1, n - i * coins[k]);
			}
			return result;
		}

	}

	/**
	 * y = f(n) 组成n分的情况总和
	 * <p>
	 * f(97) = f(97-25) + f(97-10) + f(97-5) + f(97-1)
	 */
	public static class Solution2 {

		static final int MOD = 1000000007;
		int[] coins = {25, 10, 5, 1};

		public int way2Change(int n) {
			int[] result = new int[n + 1];
			result[0] = 1;
			for (int c : coins) {
				for (int i = c; i <= n; i++) {
					result[i] = (result[i] + result[i - c]) % MOD;
				}
			}
			return result[n];
		}

	}

}
