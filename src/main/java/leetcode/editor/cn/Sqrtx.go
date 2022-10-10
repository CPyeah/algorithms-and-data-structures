  package leetcode.editor.cn;
  
  /**
   * [69] x 的平方根 
   */
  public class Sqrtx{
      public static void main(String[] args) {
           Solution solution = new Sqrtx().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func mySqrt(x int) int {
  if x == 1 {
    return 1
  }
  left, right := 0, x
  for {
    mid := (left + right) / 2
    m2 := mid * mid
    if m2 == x {
      return mid
    }
    if m2 > x {
      right = mid
    } else {
      if (mid+1) * (mid+1) > x {
        return mid
      } else {
        left = mid
      }
    }
  }
  return 1
}
//leetcode submit region end(Prohibit modification and deletion)

  }