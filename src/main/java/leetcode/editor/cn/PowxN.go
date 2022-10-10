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
  negative := false
  if n < 0 {
    n = -n
    negative = true
  }

  ans := pow(x, n)

  if negative {
    ans = 1 / ans
  }
  return ans
}

func pow(x float64, n int) float64 {
  if n == 0 {
    return 1
  }
  if n == 1 {
    return x
  }
  if x == 0 {
    return 0
  }
  half := n / 2
  if n % 2 == 0 {
    return pow(x*x, half)
  } else {
    return pow(x*x, half) * x
  }
}
//leetcode submit region end(Prohibit modification and deletion)

  }