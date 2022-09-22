  package leetcode.editor.cn;
  
  /**
   * [200] 岛屿数量
   */
  public class NumberOfIslands{
      public static void main(String[] args) {
           Solution solution = new NumberOfIslands().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func numIslands(grid [][]byte) int {
  ans := 0
  rows := len(grid)
  cols := len(grid[0])
  // 中心扩散感染，相邻的1都变成0
  var extend func(i int, j int)
  extend = func(i int, j int) {
    if i < 0 || i > rows-1 || j < 0 || j > cols-1 {
      return
    }
    if '1' == grid[i][j] {
      grid[i][j] = '0'
      extend(i+1, j)
      extend(i-1, j)
      extend(i, j+1)
      extend(i, j-1)
    }
  }
  // 遍历，遇到的1， 结果++
  for i:=0;i<rows;i++ {
    for j:=0;j<cols;j++ {
      if '1' == grid[i][j] {
        ans ++
        extend(i, j)
      }
    }
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }