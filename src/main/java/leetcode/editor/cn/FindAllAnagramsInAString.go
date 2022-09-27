  package leetcode.editor.cn;
  
  /**
   * [438] 找到字符串中所有字母异位词
   */
  public class FindAllAnagramsInAString{
      public static void main(String[] args) {
           Solution solution = new FindAllAnagramsInAString().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func findAnagrams(s string, p string) []int {
  if len(p) > len(s) {
    return []int{}
  }
  heap := make(map[byte]int)
  for i:=0;i<len(p);i++ {
    heap[p[i]]--
    heap[s[i]]++
  }
  ans := make([]int, 0)

  for l,r:=0,len(p)-1;r<len(s); {
    if isAllZero(heap) {
      ans = append(ans, l)
    }
    heap[s[l]] --
    if r+1 < len(s) {
      heap[s[r+1]]++
    }
    l++
    r++
  }

  return ans
}
func isAllZero(heap map[byte]int) bool {
  for _,v := range heap {
    if v != 0 {
      return false
    }
  }
  return true
}
//leetcode submit region end(Prohibit modification and deletion)

  }