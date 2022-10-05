  package leetcode.editor.cn;
  
  /**
   * [36] 有效的数独
   */
  public class ValidSudoku{
      public static void main(String[] args) {
           Solution solution = new ValidSudoku().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func isValidSudoku(board [][]byte) bool {
  rows := make([]map[byte]bool, 9)
  cols := make([]map[byte]bool, 9)
  blocks := make([]map[byte]bool, 9)

  for i:=0;i<9;i++ {
    rows[i] = make(map[byte]bool)
    cols[i] = make(map[byte]bool)
    blocks[i] = make(map[byte]bool)
  }

  for i:=0;i<9;i++ {
    for j:=0;j<9;j++ {
      if board[i][j] != '.' {
        c := board[i][j]
        blockIndex := (i/3)*3 + (j/3)
        if check(rows[i], c) ||
        check(cols[j], c) ||
        check(blocks[blockIndex], c) {
          return false
        }
      }
    }
  }
  return true
}

func check(set map[byte]bool, c byte) bool {
  if set[c] {
    return true
  }
  set[c] = true
  return false
}
//leetcode submit region end(Prohibit modification and deletion)

  }