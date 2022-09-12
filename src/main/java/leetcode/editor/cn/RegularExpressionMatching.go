  package leetcode.editor.cn;
  
  /**
   * [10] 正则表达式匹配
   */
  public class RegularExpressionMatching{
      public static void main(String[] args) {
           Solution solution = new RegularExpressionMatching().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func isMatch(s string, p string) bool {
    s = " " + s
    p = " " + p

    dp := make([][]bool, len(s))
    for i,_ := range dp {
        dp[i] = make([]bool, len(p))
    }

    dp[0][0] = true

    // first row
    for i:= 1;i<len(p);i++ {
       if p[i] == '*' {
           dp[0][i] = dp[0][i-2]
       } else {
           dp[0][i] = false
       }
    }

    // first column
    for i:=1;i<len(s);i++ {
        dp[i][0] = false

    }

    // middle
    for i:=1;i<len(s);i++ {
        for j:=1;j<len(p);j++ {
            if (match(s, i, p, j) && dp[i-1][j-1]) {
                dp[i][j] = true
            } else if p[j] == '*' && dp[i][j-2]{
                dp[i][j] = true
            } else if p[j] == '*' && match(s, i, p, j-1){
                dp[i][j] = dp[i-1][j]
            } else {
                dp[i][j] = false
            }
        }
    }

    return dp[len(s)-1][len(p)-1]

}

func match(s string, i int, p string, j int) bool {
    if p[j] == "."[0] || p[j] == s[i] {
        return true
    } else {
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }