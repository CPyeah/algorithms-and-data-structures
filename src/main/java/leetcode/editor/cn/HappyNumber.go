  package leetcode.editor.cn;
  
  /**
   * [202] 快乐数
   */
  public class HappyNumber{
      public static void main(String[] args) {
           Solution solution = new HappyNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func isHappy(n int) bool {
  visited := make(map[int]bool)
  for !visited[n] {
    visited[n] = true
    n = getHappy(n)
    if n == 1 {
      return true
    }
  }
  return false
}

func getHappy(n int) int {
  res := 0
  s := strconv.Itoa(n)
  for i:=0;i<len(s);i++ {
    b := int(s[i]-'0')
    res += b*b
  }
  return res
}
//leetcode submit region end(Prohibit modification and deletion)

  }