  package leetcode.editor.cn;
  
  /**
   * [50] Pow(x, n)
   */
  public class PowxN{
      public static void main(String[] args) {
           Solution solution = new PowxN().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func myPow(x float64, n int) float64 {
  ans := 1.0
  if n > 0 {
    for i:=0;i<n;i++ {
      ans *= x
    }
  }
  if n < 0 {
    n = -n
    for i:=0;i<n;i++ {
      ans /= x
    }
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }