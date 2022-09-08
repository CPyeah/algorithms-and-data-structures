  package leetcode.editor.cn;
  
  /**
   * [301] 删除无效的括号
   ()())()
   */

      //leetcode submit region begin(Prohibit modification and deletion)
func removeInvalidParentheses(s string) []string {
  ans = make([]string, 0)
  if isValid(s) {
    ans = append(ans, s)
    return ans
  }
  dfs(s, -1)
  // remove all '@' and get the max length
  maxLen := 0
  m := make(map[string]bool)
  for i:=0;i<len(ans);i++ {
    ans[i] = remove(ans[i])
    m[ans[i]] = true
    if len(ans[i]) > maxLen {
      maxLen = len(ans[i])
    }
  }
  // get the true ans
  trueAns := make([]string, 0)
  for k,_ := range m {
    if len(k) == maxLen {
      trueAns = append(trueAns, k)
    }
  }

  return trueAns
}

func remove(s string) string{
  b := make([]byte, 0)
  for i := range s {
    if s[i] != '@' {
      b = append(b, s[i])
    }
  }
  return string(b)
}

var ans []string

func dfs(s string, i int) {
  i++
  if i >= len(s) {
    return
  }
  dfs(s, i)
  if s[i] != '(' && s[i] != ')' {
    return
  }
  buf := []rune(s)
  buf[i] = '@'
  s = string(buf)
  if isValid(s) {
    ans = append(ans, s)
  }
  dfs(s, i)
}

func isValid(s string) bool {
  stack := make([]byte,0)
  for i:=0;i<len(s);i++ {
    b:=s[i]
    if b == '(' {
      stack = append(stack, b)
    } else if b == ')' {
      if len(stack) == 0 || '(' != stack[len(stack)-1]{
        return false
      } else if '(' == stack[len(stack)-1]{
        stack = stack[:len(stack)-1]
      }
    }
  }
  return len(stack) == 0
}
//leetcode submit region end(Prohibit modification and deletion)

  }