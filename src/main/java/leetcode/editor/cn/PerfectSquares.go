  package leetcode.editor.cn;
  
  /**
   * [279] 完全平方数
   */
  public class PerfectSquares{
      public static void main(String[] args) {
           Solution solution = new PerfectSquares().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func numSquares(n int) int {
  dp := make([]int, n+1)
  dp[0] = 0
  for i:=1;i<=n;i++ {
    dp[i] = i
    for k:=2;;k++ {
      k2 := k * k // 完全平方数
      if k2 > i {
        break
      }
      rest := i -k2 // 当前数字 - 完全平方数 = 剩下的数值
      v := dp[rest] + 1 // 剩下的数值 可以用几个平方数表示 + 1
      if v < dp[i] {
        dp[i] = v
      }
    }
  }
  return dp[n]
}
//leetcode submit region end(Prohibit modification and deletion)

  }