  package leetcode.editor.cn;
  
  /**
   * [85] 最大矩形
   */
  public class MaximalRectangle{
      public static void main(String[] args) {
           Solution solution = new MaximalRectangle().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maximalRectangle(matrix [][]byte) int {
  rows = len(matrix)
  columns = len(matrix[0])
  newMatrix := make([][]int, rows)
  ans := 0
  for i:=0;i<rows;i++ {
    newMatrix[i] = make([]int, columns)
    fill(matrix, newMatrix, i)
    a := maxInRow(newMatrix[i])
    if a > ans {
      ans = a
    }
  }
  return ans
}

var rows int
var columns int

func fill(matrix [][]byte, newMatrix [][]int, rowIndex int) {
  for i:=0;i<columns;i++ {
    if rowIndex == 0 {
      if matrix[rowIndex][i] == '1' {
        newMatrix[rowIndex][i] = 1
      }
    } else {
      if matrix[rowIndex][i] == '1' {
        newMatrix[rowIndex][i] = newMatrix[rowIndex-1][i] + 1
      }
    }
  }
}

func maxInRow(row []int) int {
  row = append([]int{0}, row...)
  row = append(row, 0)
  stack := make([]int, 0)
  res := 0
  for i:=0;i<len(row);i++ {
    for len(stack) > 0 && row[i] < row[stack[len(stack)-1]] {
      topIndex := stack[len(stack)-1]
      stack = stack[:len(stack)-1]
      leftIndex := stack[len(stack)-1]
      r := (i - leftIndex - 1) * row[topIndex]
      if r > res {
        res = r
      }
    }
    stack = append(stack, i)
  }
  return res
}
//leetcode submit region end(Prohibit modification and deletion)

  }