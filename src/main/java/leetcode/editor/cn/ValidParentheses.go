  package leetcode.editor.cn;
  
  /**
   * [20] 有效的括号
   */
  public class ValidParentheses{
      public static void main(String[] args) {
           Solution solution = new ValidParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func isValid(s string) bool {
  dict := make(map[byte]byte)
  dict[')'] = '('
  dict[']'] = '['
  dict['}'] = '{'
  stack := make([]byte, 0)
  for i:=0;i<len(s);i++ {
    // if current is left
    if s[i] == '(' || s[i] == '[' || s[i] == '{' {
      // push to stack
      stack = append(stack, s[i])
    } else if len(stack) == 0 {
      return false
    } else {
      // if current is right
      // check stack top if is left
      top := stack[len(stack)-1]
      if top != dict[s[i]] {
        return false
      } else {
        // pop
        stack = stack[:len(stack)-1]
      }
    }
  }
  return len(stack) == 0
}
//leetcode submit region end(Prohibit modification and deletion)

  }