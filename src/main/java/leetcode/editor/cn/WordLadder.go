  package leetcode.editor.cn;
  
  /**
   * [127] 单词接龙
   */
  public class WordLadder{
      public static void main(String[] args) {
           Solution solution = new WordLadder().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func ladderLength(beginWord string, endWord string, wordList []string) int {
  wordList = append(wordList, beginWord)
  queue := []string{beginWord}
  visited := make(map[string]bool)
  dict := getPatternDict(wordList)
  res := 0
  for len(queue) > 0 {
    res ++
    size := len(queue)
    for i:=0;i<size;i++ {
      // pop()
      w := queue[0]
      queue = queue[1:]
      if visited[w] {
        continue
      }
      visited[w] = true
      if w == endWord {
        return res
      }
      likeWords := getLikeWords(dict, w)
      queue = append(queue, likeWords...)
    }
  }
  return 0
}

func getLikeWords(dict map[string][]string, word string) []string {
  words := make([]string, 0)
  for i:=0;i<len(word);i++ {
    pattern := word[:i] + "*" + word[i+1:]
    words = append(words, dict[pattern]...)
  }
  return words
}

func getPatternDict(wordList []string) map[string][]string{
  dict := make(map[string][]string)
  l := len(wordList[0])
  for i:=0;i<len(wordList);i++ {
    word := wordList[i]
    for j:=0;j<l;j++ {
      pattern := word[:j] + "*" + word[j+1:]
      if dict[pattern] == nil {
        dict[pattern] = make([]string, 0)
        for k:=0;k<len(wordList);k++ {
          if isMatch(pattern, wordList[k]) {
            dict[pattern] = append(dict[pattern], wordList[k])
          }
        }
      }
    }
  }
  return dict
}

func isMatch(pattern string, word string) bool {
  for i:=0;i<len(pattern);i++ {
    if pattern[i] == '*' {
      continue
    }
    if pattern[i] != word[i] {
      return false
    }
  }
  return true
}

func isLike(word1 string, word2 string) bool {
  if len(word1) != len(word2) {
    return false
  }
  differFlag := false
  for i:=0;i<len(word1);i++ {
    if word1[i] != word2[i] {
      if !differFlag {
        differFlag = !differFlag
      } else {
        return false
      }
    }
  }
  return true
}
//leetcode submit region end(Prohibit modification and deletion)

  }