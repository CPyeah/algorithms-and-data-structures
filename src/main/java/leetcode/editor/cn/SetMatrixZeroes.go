  package leetcode.editor.cn;
  
  /**
   * [73] 矩阵置零
   */
  public class SetMatrixZeroes{
      public static void main(String[] args) {
           Solution solution = new SetMatrixZeroes().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func setZeroes(matrix [][]int)  {
  // collect all zero
  firstRow := 1
  for i:=0;i<len(matrix);i++ {
    for j:=0;j<len(matrix[0]);j++ {
      if matrix[i][j] == 0 {
        matrix[0][j] = 0
        if i == 0 {
          firstRow = 0
        } else {
          matrix[i][0] = 0
        }

      }
    }
  }
  setAllRowZero := func(i int) {
    for j:=0;j<len(matrix[0]);j++ {
      matrix[i][j] = 0
    }
  }
  setAllColumnZero := func(j int) {
    for i:=0;i<len(matrix);i++ {
      matrix[i][j] = 0
    }
  }
  // set zeros
  // 注意这里的顺序
  for i:=1;i<len(matrix);i++ {
    if matrix[i][0] == 0 {
      setAllRowZero(i)
    }
  }
  for j:=0;j<len(matrix[0]);j++ {
    if matrix[0][j] == 0 {
      setAllColumnZero(j)
    }
  }
  if firstRow == 0 {
    setAllRowZero(0)
  }
}
//leetcode submit region end(Prohibit modification and deletion)

  }