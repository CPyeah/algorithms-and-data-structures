  package leetcode.editor.cn;
  
  /**
   * [32] 最长有效括号
   */
  public class LongestValidParentheses{
      public static void main(String[] args) {
           Solution solution = new LongestValidParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func longestValidParentheses(s string) int {
  stack:=[]int{}
  // string go through stack
  for i:=0;i<len(s);i++ {
    if len(stack) == 0 {
      stack = append(stack, i)
    } else if s[i] == '(' {
      stack = append(stack, i)
    } else {
      topChar := s[stack[len(stack)-1]]
      if '(' == topChar {
        // pop
        stack = stack[:len(stack)-1]
      } else {
        stack = append(stack, i)
      }
    }
  }
  // add head and tail
  stack = append([]int{-1}, stack...)
  stack = append(stack, len(s))
  // get max interval
  max := 0
  for i:=1;i<len(stack);i++ {
    interval := stack[i] - stack[i-1] -1
    if interval > max {
      max = interval
    }
  }
  return max
}
//leetcode submit region end(Prohibit modification and deletion)

  }