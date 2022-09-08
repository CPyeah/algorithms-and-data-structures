  package leetcode.editor.cn;
  
  /**
   * [647] 回文子串
   */
  public class PalindromicSubstrings{
      public static void main(String[] args) {
           Solution solution = new PalindromicSubstrings().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func countSubstrings(s string) int {
  ans = 0
  for i:=0;i<len(s);i++ {
    checkTheSlides(s, i, i)
    checkTheSlides(s, i, i+1)
  }
  return ans
}
var ans int

func checkTheSlides(s string, i int, j int) {
  if i < 0 || j > len(s) - 1 {
    return
  }
  if s[i] == s[j] {
    ans ++
    checkTheSlides(s, i-1, j+1)
  }
}
//leetcode submit region end(Prohibit modification and deletion)

  }