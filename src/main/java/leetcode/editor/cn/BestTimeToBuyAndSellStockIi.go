  package leetcode.editor.cn;
  
  /**
   * [122] 买卖股票的最佳时机 II
   */
  public class BestTimeToBuyAndSellStockIi{
      public static void main(String[] args) {
           Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maxProfit(prices []int) int {
  length := len(prices)
  if length == 0 || length == 1 {
    return 0
  }
  profit := 0;
  for i:=0;i<length-1;i++ {
    p := prices[i+1] - prices[i]
    if p > 0 {
      profit += p
    }
  }
  return profit

}
//leetcode submit region end(Prohibit modification and deletion)

  }