  package leetcode.editor.cn;
  
  /**
   * [49] 字母异位词分组
   */
  public class GroupAnagrams{
      public static void main(String[] args) {
           Solution solution = new GroupAnagrams().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func groupAnagrams(strs []string) [][]string {
  m := make(map[string][]string)
  for _,s := range strs {
    sorted := SortString(s)
    if m[sorted] == nil {
      m[sorted] = make([]string,0)
    }
    m[sorted] = append(m[sorted], s)
  }
  ans := make([][]string, 0)
  for _,v := range m {
    ans = append(ans, v)
  }
  return ans
}

func SortString(s string) string {
    // 转成byte切片
    r := []rune(s)
    // 排序切片
    sort.Slice(r, func(i int, j int) bool {return r[i]<r[j]})
    // 切片转成字符串，返回
    return string(r)
}
//leetcode submit region end(Prohibit modification and deletion)

  }