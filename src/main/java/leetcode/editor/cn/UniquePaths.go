  package leetcode.editor.cn;
  
  /**
   * [62] 不同路径
   */
  public class UniquePaths{
      public static void main(String[] args) {
           Solution solution = new UniquePaths().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func uniquePaths(m int, n int) int {
  dp := make([][]int, m)
  for i := range dp {
    dp[i] = make([]int, n)
  }
  for i:=0;i<m;i++ {
    for j:=0;j<n;j++ {
      if i == 0 || j == 0 {
        dp[i][j] = 1
      } else {
        dp[i][j] = dp[i-1][j] + dp[i][j-1]
      }
    }
  }
  return dp[m-1][n-1]
}
//leetcode submit region end(Prohibit modification and deletion)

  }