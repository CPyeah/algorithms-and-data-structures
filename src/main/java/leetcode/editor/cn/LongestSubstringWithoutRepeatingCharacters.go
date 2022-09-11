  package leetcode.editor.cn;
  
  /**
   * [3] 无重复字符的最长子串
   */
  public class LongestSubstringWithoutRepeatingCharacters{
      public static void main(String[] args) {
           Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func lengthOfLongestSubstring(s string) int {
  if len(s) == 0 {
    return 0
  }
  l := 0
  r := 0
  ans := 1
  charSet := make(map[byte]bool)
  for r < len(s) {

    //if right in the set
    for charSet[s[r]] {
      // remove left
      charSet[s[l]] = false
      l ++
    }
    // add right to set
    charSet[s[r]] = true
    res := r - l + 1
    if res > ans {
      ans = res
    }
    r ++
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }