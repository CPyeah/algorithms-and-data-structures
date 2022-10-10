  package leetcode.editor.cn;
  
  /**
   * [54] 螺旋矩阵
   */
  public class SpiralMatrix{
      public static void main(String[] args) {
           Solution solution = new SpiralMatrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func spiralOrder(matrix [][]int) []int {
  row := len(matrix)
  col := len(matrix[0])
  ans := make([]int, 0)

  isValid := func(i int, j int) bool {
    if i < 0 || j < 0 || i >= row || j >= col {
      return false
    }
    if matrix[i][j] == 101 {
      return false
    }
    return true
  }

  i,j := 0, -1
  for len(ans) < row * col{
    // go right
    for isValid(i, j+1) {
      j++
      ans = append(ans, matrix[i][j])
      matrix[i][j] = 101
    }
    // go down
    for isValid(i+1, j) {
      i++
      ans = append(ans, matrix[i][j])
      matrix[i][j] = 101
    }
    // go left
    for isValid(i, j-1) {
      j--
      ans = append(ans, matrix[i][j])
      matrix[i][j] = 101
    }
    // go up
    for isValid(i-1, j) {
      i--
      ans = append(ans, matrix[i][j])
      matrix[i][j] = 101
    }
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }