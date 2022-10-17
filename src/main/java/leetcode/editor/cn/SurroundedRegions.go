  package leetcode.editor.cn;
  
  /**
   * [130] 被围绕的区域
   */
  public class SurroundedRegions{
      public static void main(String[] args) {
           Solution solution = new SurroundedRegions().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func solve(board [][]byte)  {
  for i:=0;i<len(board);i++ {
    for j:=0;j<len(board[0]);j++ {
      if 'O' == board[i][j] {
        nextPosList := make([][]int, 0)
        findAllNextPos(board, i, j, &nextPosList)
        if allInMiddle(nextPosList, len(board), len(board[0])) {
          // set all O to X
          setAll(board, nextPosList, 'X')
        }
      }
    }
  }
  // set all _ to O
  for i:=0;i<len(board);i++ {
    for j:=0;j<len(board[0]);j++ {
      if board[i][j] == '_' {
        board[i][j] = 'O'
      }
    }
  }
}
func setAll(board [][]byte, posList [][]int, value byte) {
  for k:=0;k<len(posList);k++ {
    i := posList[k][0]
    j := posList[k][1]
    board[i][j] = value
  }
}

func allInMiddle(posList [][]int, row int, col int) bool {
  for k:=0;k<len(posList);k++ {
    i := posList[k][0]
    j := posList[k][1]
    if i == 0 || i == row-1 || j == 0 || j == col-1 {
      return false
    }
  }
  return true
}

func findAllNextPos(board [][]byte, i int, j int, nextPosList *[][]int) {
  if i < 0 || i >= len(board) || j < 0 || j >= len(board[0]) {
    return
  }
  if board[i][j] == 'O' {
    *nextPosList = append(*nextPosList, []int{i, j})
    board[i][j] = '_'
    findAllNextPos(board, i+1, j, nextPosList)
    findAllNextPos(board, i-1, j, nextPosList)
    findAllNextPos(board, i, j+1, nextPosList)
    findAllNextPos(board, i, j-1, nextPosList)
  }
}

//leetcode submit region end(Prohibit modification and deletion)

  }