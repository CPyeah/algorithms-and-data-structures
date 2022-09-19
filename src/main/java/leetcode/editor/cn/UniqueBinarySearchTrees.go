  package leetcode.editor.cn;
  
  /**
   * [96] 不同的二叉搜索树
   */
  public class UniqueBinarySearchTrees{
      public static void main(String[] args) {
           Solution solution = new UniqueBinarySearchTrees().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func numTrees(n int) int {
  dp := make([]int, n+1)
  dp[0] = 1
  for i:=1;i<=n;i++ {
    subNodeCount := i-1
    sum := 0
    for j:=0;j<=subNodeCount;j++ {
      sum += dp[j] * dp[subNodeCount-j]
    }
    dp[i] = sum
  }
  return dp[n]
}
//leetcode submit region end(Prohibit modification and deletion)

  }