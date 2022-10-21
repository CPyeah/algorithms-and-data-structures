  package leetcode.editor.cn;
  
  /**
   * [166] 分数到小数
   */
  public class FractionToRecurringDecimal{
      public static void main(String[] args) {
           Solution solution = new FractionToRecurringDecimal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func fractionToDecimal(numerator int, denominator int) string {
  if numerator == 0 {
    return "0"
  }
  res := ""
  // sign
  if (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0) {
    res += "-"
  }
  // abs and parse to int64
  n := abs(numerator) // 被除数
  d := abs(denominator) // 除数
  // integer part
  s := strconv.Itoa(n/d)
  res += s
  remainder := n % d
  if remainder == 0 {
    return res
  }

  // decimal part
  decimalPos := make(map[int]int)
  res += "."
  count := len(res)
  for remainder != 0 {
    // 如果 被除数 出现过，组装括号，break
    if decimalPos[remainder] > 0 {
      // inset ( into position[s]
      // inset ) into tail
      left := res[:decimalPos[remainder]]
      right := res[decimalPos[remainder]:]
      res = left + "(" + right + ")"
      break
    }
    // 记录被除数所对应小数的位数
    decimalPos[remainder] = count
    count++
    remainder *= 10
    s = strconv.Itoa(remainder/d)
    res += s
    remainder %= d
  }
  return res
}

func abs(n int) int {
  if n < 0 {
    return -n
  }
  return n
}
//leetcode submit region end(Prohibit modification and deletion)

  }