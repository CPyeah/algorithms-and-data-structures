  package leetcode.editor.cn;
  
  /**
   * [5] 最长回文子串
   */
  public class LongestPalindromicSubstring{
      public static void main(String[] args) {
           Solution solution = new LongestPalindromicSubstring().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func longestPalindrome(s string) string {
  maxLen := 0
  var ans string
  var extend func(s string, i int, j int)
  extend = func(s string, i int, j int) {
    if i >= 0 && j < len(s) && s[i] == s[j] {
      l := j - i + 1
      if l > maxLen {
        maxLen = l
        ans = s[i:j+1]
      }
      extend(s, i-1, j+1)
    }
  }
  for i:=0;i<len(s);i++ {
    extend(s, i, i)
    extend(s, i, i+1)
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }