  package leetcode.editor.cn;
  
  /**
   * [172] 阶乘后的零
   */
  public class FactorialTrailingZeroes{
      public static void main(String[] args) {
           Solution solution = new FactorialTrailingZeroes().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func trailingZeroes(n int) int {
  res := 0
  for n > 0 {
    n /= 5
    res += n
  }
  return res
}
//leetcode submit region end(Prohibit modification and deletion)

  }