  package leetcode.editor.cn;
  
  /**
   * [91] 解码方法
   */
  public class DecodeWays{
      public static void main(String[] args) {
           Solution solution = new DecodeWays().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func numDecodings(s string) int {
  if (s[0] == '0') {
    return 0
  }
  if (len(s) == 1) {
    return 1
  }
  dp := make([]int, len(s))
  dp[0] = 1
  for i:=1;i<len(s);i++ {
    if decode1(s[i]) {
      dp[i] += dp[i-1]
    }
    if decode2(s[i-1], s[i]) {
      if i == 1 {
        dp[i] ++
      } else {
        dp[i] += dp[i-2]
      }
    }
  }
  return dp[len(s)-1]

}
func decode1(b byte)bool {
  if b == '0' {
    return false
  }
  return true
}

func decode2(b1 byte, b2 byte)bool {
  if b1 == '0' {
    return false
  }
  if b1 > '2' {
    return false
  }
  if b1 == '2' && b2 > '6' {
    return false
  }
  return true
}
//leetcode submit region end(Prohibit modification and deletion)

  }