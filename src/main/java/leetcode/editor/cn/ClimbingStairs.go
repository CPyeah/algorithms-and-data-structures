  package leetcode.editor.cn;
  
  /**
   * [70] 爬楼梯
   */
  public class ClimbingStairs{
      public static void main(String[] args) {
           Solution solution = new ClimbingStairs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func climbStairs(n int) int {
  if n == 1{
    return 1
  }
  dp := make([]int, n)
  dp[0] = 1
  dp[1] = 2
  for i:=2;i<n;i++ {
    dp[i] = dp[i-2] + dp[i-1]
  }
  return dp[n-1]
}
//leetcode submit region end(Prohibit modification and deletion)

  }