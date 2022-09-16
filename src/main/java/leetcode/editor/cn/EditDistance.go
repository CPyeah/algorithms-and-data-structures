  package leetcode.editor.cn;
  
  /**
   * [72] 编辑距离
   */
  public class EditDistance{
      public static void main(String[] args) {
           Solution solution = new EditDistance().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func minDistance(word1 string, word2 string) int {

  // preparation
  word1 = " " + word1
  word2 = " " + word2
  len1 := len(word1)
  len2 := len(word2)

  // make dp
  dp := make([][]int, len1)
  for i :=range dp {
    dp[i] = make([]int, len2)
  }

  // init dp
  // first line
  for i:=0;i<len2;i++ {
    dp[0][i] = i
  }
  // first column
  for i:=0;i<len1;i++ {
    dp[i][0] = i
  }

  // rest of dp
  for i:=1;i<len1;i++ {
    for j:=1;j<len2;j++ {
      if word1[i] == word2[j] {
        dp[i][j] = dp[i-1][j-1]
      } else {
        dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
      }
    }
  }

  return dp[len1-1][len2-1]
}

func min(a int, b int, c int) int {
  m := a
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