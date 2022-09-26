  package leetcode.editor.cn;
  
  /**
   * [322] 零钱兑换
   */
  public class CoinChange{
      public static void main(String[] args) {
           Solution solution = new CoinChange().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func coinChange(coins []int, amount int) int {
  dp := make([]int, amount + 1)
  dp[0] = 0
  for i:=1;i<=amount;i++ {
    dp[i] = -1
    for _,c := range coins {
      rest := i - c
      if rest >= 0 && dp[rest] != -1{
        if dp[i] == -1 {
          dp[i] = dp[rest] + 1
        } else {
          dp[i] = min(dp[i], dp[rest] + 1)
        }
      }
    }
  }
  return dp[amount]
}
func min(a int, b int) int {
  if a<b{
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }