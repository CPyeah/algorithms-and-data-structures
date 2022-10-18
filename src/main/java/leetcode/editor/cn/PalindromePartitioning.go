  package leetcode.editor.cn;
  
  /**
   * [131] 分割回文串
   */
  public class PalindromePartitioning{
      public static void main(String[] args) {
           Solution solution = new PalindromePartitioning().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func partition(s string) [][]string {
  ans = make([][]string, 0)
  for i:=1;i<=len(s);i++ {
    left := s[:i]
    right := s[i:]
    result := make([]string, 0)
    split(left, right, &result)
  }
  return ans
}

var ans [][]string

func split(left string, right string, result *[]string) {
  if !isPalindrome(left) {
    return
  }
  *result = append(*result, left)
  if len(right) == 0 {
    ans = append(ans, *result)
  }
    for i:=1;i<=len(right);i++ {
      l := right[:i]
      r := right[i:]
      newRes := make([]string, len(*result))
      copy(newRes, *result)
      split(l, r, &newRes)
    }
}

func isPalindrome(s string) bool {
  if len(s) == 1 {
    return true
  }
  i, j := 0, len(s)-1
  for i < j {
    if s[i] != s[j] {
      return false
    }
    i ++
    j --
  }
  return true
}
//leetcode submit region end(Prohibit modification and deletion)

  }