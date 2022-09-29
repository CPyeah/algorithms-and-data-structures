  package leetcode.editor.cn;
  
  /**
   * [7] 整数反转
   */
  public class ReverseInteger{
      public static void main(String[] args) {
           Solution solution = new ReverseInteger().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func reverse(x int) int {
  ans := 0
  for x != 0 {
     if ans > math.MaxInt32/10 || ans < math.MinInt32/10 {
      return 0
     }
     ans *= 10
     yu := x % 10 // 3
     ans = ans + yu
     x /= 10 // 12
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }