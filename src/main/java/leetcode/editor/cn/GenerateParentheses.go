  package leetcode.editor.cn;
  
  /**
   * [22] 括号生成
   */
  public class GenerateParentheses{
      public static void main(String[] args) {
           Solution solution = new GenerateParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func generateParenthesis(n int) []string {
  ans := []string{}

  var dfs func(res string, left int, right int)
  dfs = func(res string, left int, right int) {
    if left == 0 && right == 0 {
      ans = append(ans, res)
      return
    }
    // use left
    if left > 0 {
      dfs(res+"(", left-1, right)
    }
    // use right
    if right > left {
      dfs(res+")", left, right-1)
    }
  }

  dfs("", n, n)
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }