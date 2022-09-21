  package leetcode.editor.cn;
  
  /**
   * [139] 单词拆分
   */
  public class WordBreak{
      public static void main(String[] args) {
           Solution solution = new WordBreak().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func wordBreak(s string, wordDict []string) bool {
  dict := make(map[string]bool)
  for _,w := range wordDict {
    dict[w] = true
  }

  dp := make([]int, 0)
  dp = append(dp, 0)
  for i:=0;i<len(s);i++ {
    for _, d := range dp {
      sub := s[d:i+1]
      if dict[sub] {
        dp = append(dp, i+1)
        break
      }
    }
  }
  return dp[len(dp) -1] == len(s)
}
//leetcode submit region end(Prohibit modification and deletion)

  }