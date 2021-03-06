package greedy;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class BuyAndSellStock {

	public static class Solution {

		public int maxProfit(int[] prices) {
			int profit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) {
					profit += (prices[i] - prices[i - 1]);
				}
			}
			return profit;
		}
	}

}
