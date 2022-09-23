  package leetcode.editor.cn;
  
  /**
   * [221] 最大正方形
   */
  public class MaximalSquare{
      public static void main(String[] args) {
           Solution solution = new MaximalSquare().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maximalSquare(matrix [][]byte) int {
  dp := make([][]int, len(matrix))
  ans := 0
  for i:=0;i<len(matrix);i++ {
    dp[i] = make([]int, len(matrix[0]))
    for j:=0;j<len(matrix[0]);j++ {
      if i == 0 || j == 0 {
        if matrix[i][j] == '1' {
          dp[i][j] = 1
        }
      } else {
          if matrix[i][j] == '1' {
            dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
          }
      }
      if dp[i][j] > ans {
        ans = dp[i][j]
      }
    }
  }

  return ans * ans
}
func min(a int, b int, c int) int {
  m:=a
  if b < m {
    m = b
  }
  if c < m {
    m = c
  }
  return m
}
//leetcode submit region end(Prohibit modification and deletion)

  }