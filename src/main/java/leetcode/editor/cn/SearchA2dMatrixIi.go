  package leetcode.editor.cn;
  
  /**
   * [240] 搜索二维矩阵 II
   */
  public class SearchA2dMatrixIi{
      public static void main(String[] args) {
           Solution solution = new SearchA2dMatrixIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func searchMatrix(matrix [][]int, target int) bool {
    // right-up corner
    i, j := 0, len(matrix[0])-1
    for i < len(matrix) && j > -1{
      if matrix[i][j] == target {
        return true
      }
      if target < matrix[i][j] {
        // go left
        j--
      } else {
        // go down
        i ++
      }
    }
    return false
}
//leetcode submit region end(Prohibit modification and deletion)

  }