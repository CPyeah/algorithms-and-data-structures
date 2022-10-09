  package leetcode.editor.cn;
  
  /**
   * [44] 通配符匹配
   */
  public class WildcardMatching{
      public static void main(String[] args) {
           Solution solution = new WildcardMatching().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func isMatch(s string, p string) bool {
  s = " " + s
  p = " " + p
  row := len(s)
  col := len(p)
  dp := make([][]bool, row)
  for i:=0;i<row;i++ {
    dp[i] = make([]bool, col)
  }
  dp[0][0] = true
  // fist row
  for j:=1;j<col;j++ {
    if p[j] == '*' {
      dp[0][j] = dp[0][j-1]
    }
  }

  // rest
  for i:=1;i<row;i++ {
    for j:=1;j<col;j++ {
      // 如果最后一个字符能匹配上，且左上方为true，当前位置就是true
      if (s[i] == p[j] || p[j] == '?' || p[j] == '*') && dp[i-1][j-1] {
        dp[i][j] = true
      }
      // 如果p的最后一个位置是 ‘*’， 左边和上边任意一个是true，当前位置就是true
      if p[j] == '*' && (dp[i-1][j] || dp[i][j-1]) {
        dp[i][j] = true
      }
    }
  }
  return dp[row-1][col-1]
}
//leetcode submit region end(Prohibit modification and deletion)

  }