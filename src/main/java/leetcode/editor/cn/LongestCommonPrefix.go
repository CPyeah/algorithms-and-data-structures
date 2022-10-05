  package leetcode.editor.cn;
  
  /**
   * [14] 最长公共前缀
   */
  public class LongestCommonPrefix{
      public static void main(String[] args) {
           Solution solution = new LongestCommonPrefix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func longestCommonPrefix(strs []string) string {
  res := ""
  for i:=0;i<len(strs[0]);i++ {
    for row,s := range strs {
      // 第一行是基准
      if row != 0 {
        // 和第一行比较
        if i == len(s) || s[i] != strs[0][i] {
          return res
        }
      }
    }
    // 如果全部比较通过，把当前字符加到结果中
    res += string(strs[0][i])
  }
  return res
}
//leetcode submit region end(Prohibit modification and deletion)

  }