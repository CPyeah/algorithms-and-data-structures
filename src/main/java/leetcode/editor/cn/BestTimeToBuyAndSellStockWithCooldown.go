  package leetcode.editor.cn;
  
  /**
   * [309] 最佳买卖股票时机含冷冻期
   */
  public class BestTimeToBuyAndSellStockWithCooldown{
      public static void main(String[] args) {
           Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maxProfit(prices []int) int {
  cool := make([]int, len(prices))
  buy := make([]int, len(prices))
  sell := make([]int, len(prices))
  cool[0] = 0
  buy[0] = -prices[0]
  sell[0] = 0
  ans := 0
  for i:=1;i<len(prices);i++ {
    cool[i] = max(max(cool[i-1], buy[i-1]), sell[i-1])
    buy[i] = max(buy[i-1], cool[i-1]-prices[i])
    sell[i] = max(sell[i-1], buy[i-1] + prices[i])
    ans = max(ans, sell[i])
  }
  return ans
}

func max(a int, b int) int {
  if a > b{
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }