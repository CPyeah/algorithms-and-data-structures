  package leetcode.editor.cn;
  
  /**
   * [125] 验证回文串
   */
  public class ValidPalindrome{
      public static void main(String[] args) {
           Solution solution = new ValidPalindrome().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func isPalindrome(s string) bool {
  l := 0
  r := len(s)-1
  for l <= r {
    for !isChar(s[l]) {
      l ++
      if l > len(s) - 1 {
        return true
      }
    }
    for !isChar(s[r]) {
      r --
    }
    if l > len(s) -1 || r < 0 {
      return false
    }
    if r < l {
      return true
    }
    if isSame(rune(s[l]), rune(s[r])) {
      l ++
      r --
    } else {
      return false
    }
  }
  return true
}

func isChar(c byte) bool {
  if c >= 'a' && c <= 'z' {
    return true
  }
  if c >= 'A' && c <= 'Z' {
    return true
  }
  if c >= '0' && c <= '9' {
    return true
  }
  return false
}

func isSame(a rune, b rune)bool {
  if a == b{
    return true
  }
  if isNumber(a) || isNumber(b) {
    return false
  }
  if a - b == 32 || b - a == 32{
    return true
  }
  return false
}

func isNumber(n rune)bool {
  return n >= '0' && n <= '9'
}
//leetcode submit region end(Prohibit modification and deletion)

  }