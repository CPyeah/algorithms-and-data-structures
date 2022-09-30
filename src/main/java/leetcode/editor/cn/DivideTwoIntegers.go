  package leetcode.editor.cn;
  
  /**
   * [29] 两数相除
   */
  public class DivideTwoIntegers{
      public static void main(String[] args) {
           Solution solution = new DivideTwoIntegers().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func divide(dividend int, divisor int) int {
  if dividend == 0 {
    return 0
  }
  ans := 0
  if divisor == 1 {
    ans = dividend
  } else if divisor == -1 {
    ans = -dividend
  } else {
   negative := false
   if dividend < 0 {
     negative = !negative
     dividend = -dividend
   }
   if divisor < 0 {
     negative = !negative
     divisor = -divisor
   }

   sum := 0
   for sum < dividend {
     sum += divisor
     ans ++
   }
   if sum > dividend {
     ans --
   }
   if negative {
     ans = -ans
   }
  }

  if ans > math.MaxInt32 || ans < math.MinInt32 {
    return math.MaxInt32
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }