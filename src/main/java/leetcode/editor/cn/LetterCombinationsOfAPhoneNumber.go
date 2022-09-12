  package leetcode.editor.cn;
  
  /**
   * [17] 电话号码的字母组合
   */
  public class LetterCombinationsOfAPhoneNumber{
      public static void main(String[] args) {
           Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func letterCombinations(digits string) []string {
  ans := make([]string, 0)
  if len(digits) == 0 {
    return ans
  }
  dict := make(map[byte]string)
  dict['2'] = "abc"
  dict['3'] = "def"
  dict['4'] = "ghi"
  dict['5'] = "jkl"
  dict['6'] = "mno"
  dict['7'] = "pqrs"
  dict['8'] = "tuv"
  dict['9'] = "wxyz"
  var dfs func(s string, res string)
  dfs = func(s string, res string) {
    if len(s) == 0 {
      ans = append(ans, res)
      return
    }
    chars := dict[s[0]]
    s = s[1:]
    for i:=0;i<len(chars);i++ {
      dfs(s, res + string(chars[i]))
    }
  }
  dfs(digits, "")
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }