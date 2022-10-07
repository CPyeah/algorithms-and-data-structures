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
  // 特殊的边界情况
  if dividend == 0 {
    return dividend
  }
  if divisor == 1 {
    return dividend
  }
  if divisor == -1 {
    dividend = -dividend
    dividend = limit(dividend)
    return dividend
  }

  // 正负号处理
  negative := false
  if dividend < 0 {
    negative = !negative
    dividend = -dividend
  }
  if divisor < 0 {
    negative = !negative
    divisor = -divisor
  }

  res := 0
  for dividend >= divisor {
    time := 1
    dv := divisor
    for dv*2 <= dividend {
      time *= 2
      dv *= 2
    }
    dividend -= dv
    res += time
  }

//     for dividend >= divisor {
//       // 暴力解法：每次减一个dv，记录次数
//       dividend -= divisor
//       ans ++
//     }

  if negative {
    res = -res
  }

  // int 边界处理
  return limit(res)
}

func limit(ans int) int {
  if ans < math.MinInt32 {
    return math.MinInt32
  }
  if ans > math.MaxInt32 {
    return math.MaxInt32
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }