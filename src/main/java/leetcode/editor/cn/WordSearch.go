  package leetcode.editor.cn;
  
  /**
   * [79] 单词搜索
   */
  public class WordSearch{
      public static void main(String[] args) {
           Solution solution = new WordSearch().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func exist(board [][]byte, word string) bool {
  rows := len(board)
  columns := len(board[0])
  visited := make([][]bool, rows)
  for i := range visited {
    visited[i] = make([]bool, columns)
  }

  // r:第几行；c:第几列； i：word的索引
  var dfs func(r, c, i int) bool
  dfs = func(r, c, i int) bool {
    if i == len(word) {
      return true
    }
    if r < 0 || c < 0 || r > rows-1 || c > columns-1 || board[r][c] != word[i]|| visited[r][c] {
        return false
    }
    // 这里表示当前位置走过，再进入递归
    visited[r][c] = true
    i ++
    res := dfs(r-1, c, i) || dfs(r+1, c, i)|| dfs(r, c-1, i)|| dfs(r, c+1, i)
    // 递归出来之后，把当前位置还原，就像什么事情都没有发生
    visited[r][c] = false
    return res
  }

  for i:=0;i<rows;i++ {
    for j:=0;j<columns;j++ {
      if dfs(i, j, 0) {
        return true
      }
    }
  }

  return false
}
//leetcode submit region end(Prohibit modification and deletion)

  }