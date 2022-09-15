  package leetcode.editor.cn;
  
  /**
   * [64] 最小路径和
   */
  public class MinimumPathSum{
      public static void main(String[] args) {
           Solution solution = new MinimumPathSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func minPathSum(grid [][]int) int {
  h := len(grid)
  w := len(grid[0])
  for i:=0;i<h;i++ {
    for j:=0;j<w;j++ {
      if i==0 && j==0 {
        continue
      }
      if i == 0{
        grid[i][j] += grid[i][j-1]
      } else if j == 0 {
        grid[i][j] += grid[i-1][j]
      } else {
        grid[i][j] += min(grid[i][j-1], grid[i-1][j])
      }
    }
  }
  return grid[h-1][w-1]
}

func min(a int, b int) int {
  if a < b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }