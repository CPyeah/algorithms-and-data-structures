  package leetcode.editor.cn;
  
  /**
   * [301] 删除无效的括号
   ()())()
   */

      //leetcode submit region begin(Prohibit modification and deletion)
func removeInvalidParentheses(s string) []string {
  queue := make([]string, 0)
  queue = append(queue, s)
  ans := make(map[string]bool)
  visited := make(map[string]bool)
  matchedLen := 0
  for len(queue) > 0 {
    t := queue[0]
    queue = queue[1:]
    if visited[t] == true {
      continue
    } else {
      visited[t] = true
    }
    if (len(t) < matchedLen) {
      continue
    }
    if isValid(t) {
      ans[t] = true
      matchedLen = len(t)
    } else {
      for i:=0;i<len(t);i++ {
        if t[i] == '(' || t[i] == ')' {
          sub := t[:i] + t[i+1:]
          queue = append(queue, sub)
        }
      }
    }
  }
  result := make([]string, 0)
  for k,_ := range ans {
    result = append(result, k)
  }
  return result
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