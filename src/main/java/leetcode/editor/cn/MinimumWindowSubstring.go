  package leetcode.editor.cn;
  
  /**
   * [76] 最小覆盖子串
   */
  public class MinimumWindowSubstring{
      public static void main(String[] args) {
           Solution solution = new MinimumWindowSubstring().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func minWindow(s string, t string) string {
  dict = make(map[byte]int)
  // 初始化字典
  initDict(t)

  l := 0
  r := 0
  add(s[0])
  minSize := len(s) + 1
  res := ""

  for r < len(s) {
    if contains() {
      if r - l < minSize {
        res = s[l:r+1]
        minSize = r - l
      }
      remove(s[l])
      l++
    } else {
      r ++
      if r < len(s) {
        add(s[r])
      }
    }
  }

  return res
}

var dict map[byte]int

func initDict(t string) {
  for i := range t {
    dict[t[i]] ++
  }
}

func add(b byte) {
  _, ok := dict[b]
  if ok {
    dict[b] --
  }
}

func remove(b byte) {
    _, ok := dict[b]
    if ok {
      dict[b] ++
    }
}

func contains() bool {
  for _,v := range dict {
    if v > 0 {
      return false
    }
  }
  return true
}
//leetcode submit region end(Prohibit modification and deletion)

  }