  package leetcode.editor.cn;
  
  /**
   * [121] 买卖股票的最佳时机
   */
  public class BestTimeToBuyAndSellStock{
      public static void main(String[] args) {
           Solution solution = new BestTimeToBuyAndSellStock().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maxProfit(prices []int) int {
  minPrice := prices[0]
  maxPro := 0
  for i:=1;i<len(prices);i++ {
    currentPrice := prices[i]
    if currentPrice < minPrice {
      minPrice = currentPrice
    } else {
      profit := currentPrice - minPrice
      maxPro = max(maxPro, profit)
    }
  }
  return maxPro
}

func max(a int, b int) int {
  if a > b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }