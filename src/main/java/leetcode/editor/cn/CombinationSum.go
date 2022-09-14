  package leetcode.editor.cn;
  
  /**
   * [39] 组合总和
   */
  public class CombinationSum{
      public static void main(String[] args) {
           Solution solution = new CombinationSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func combinationSum(candidates []int, target int) [][]int {
  ans := make([][]int, 0)

  var dfs func(current []int, sum int, index int)
  dfs = func(current []int, sum int, index int) {
    if sum == target {
      // 这里需要copy一个新的
      res := make([]int, len(current))
      copy(res, current)
      ans = append(ans, res)
      return
    }
    if sum > target {
      return
    }
    // 优化，不用循环里面append了
    temp := append(current, 0);
    l := len(temp)-1
    for i:=index;i<len(candidates);i++ {
      temp[l] = candidates[i]
      dfs(temp, sum + candidates[i], i)
    }
  }

  dfs([]int{}, 0, 0)

  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }