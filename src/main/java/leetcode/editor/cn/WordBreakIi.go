  package leetcode.editor.cn;
  
  /**
   * [140] 单词拆分 II
   */
  public class WordBreakIi{
      public static void main(String[] args) {
           Solution solution = new WordBreakIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func wordBreak(s string, wordDict []string) []string {
  dictMap := make(map[string]bool)
  maxLen := 0
  for _,w := range wordDict {
    dictMap[w] = true
    if len(w) > maxLen {
      maxLen = len(w)
    }
  }

  result := make([][]string, 0)

  var helper func(reminder string, words []string)
  helper = func(reminder string, words []string) {
    if len(reminder) == 0 {
      result = append(result, words)
      return
    }
    for i:=1;i<=min(maxLen, len(reminder));i++ {
      w := reminder[:i]
      if dictMap[w] {
        newWords := make([]string, len(words))
        copy(newWords, words)
        newWords = append(newWords, w)
        helper(reminder[i:], newWords)
      }
    }
  }

  helper(s, []string{})

  ans := make([]string, len(result))
  for i:=0;i<len(result);i++ {
    wordList := result[i]
    ans[i] = strings.Join(wordList, " ")
  }
  return ans
}

func min(a int, b int) int {
  if a < b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }