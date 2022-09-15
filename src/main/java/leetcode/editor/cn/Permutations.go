  package leetcode.editor.cn;
  
  /**
   * [46] 全排列
   */
  public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func permute(nums []int) [][]int {
  ans = make([][]int, 0)
  dfs(make([]int, 0), nums)
  return ans
}

var ans [][]int

func dfs(current []int, rest []int) {
  if len(rest) == 0 {
    ans = append(ans, current)
    return
  }
  for i:=0;i<len(rest);i++ {
    dfs(append(current, rest[i]), removeIndex(rest, i))
  }
}

func removeIndex(rest []int, index int)[]int {
  r := make([]int, len(rest)-1)
  for i:=0;i<len(rest);i++ {
    if i < index {
      r[i] = rest[i]
    }
    if i > index {
      r[i-1] = rest[i]
    }
  }
  return r
}
//leetcode submit region end(Prohibit modification and deletion)

  }