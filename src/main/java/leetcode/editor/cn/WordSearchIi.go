  package leetcode.editor.cn;
  
  /**
   * [212] 单词搜索 II
   */
  public class WordSearchIi{
      public static void main(String[] args) {
           Solution solution = new WordSearchIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func findWords(board [][]byte, words []string) []string {
  // build Tire tree
  rootNode := buildTireTree(words)

  // dfs every position in board
  ROW := len(board)
  COL := len(board[0])
  ans := make([]string, 0)
  ansMap := make(map[string]bool)
  var dfs func(i int, j int, node *Node, subString string)
  dfs = func(i int, j int, node *Node, subString string) {
    // 如果越界，返回
    if i < 0 || j < 0 || i == ROW || j == COL {
      return
    }

    // 如果当前位置已经访问过，返回
    if board[i][j] == '_' {
      return
    }

    // 在 T-tree的当前节点中，找有没有对应的子节点
    child := getChild(node.nextNodes, board[i][j])
    // 如果没有，返回
    if child == nil {
      return
    }

    // 判断访问过的字符串，是不是字典中的字符串
    newSubString := subString+string(board[i][j])
    // 如果是， 添加到结果中
    if child.isWord {
      ansMap[newSubString] = true
      // 这里不需要返回，可能后面还有
    }

    // 使用 _  标记访问过的位置
    c := board[i][j]
    board[i][j] = '_'

    // 递归
    dfs(i+1, j, child, newSubString)
    dfs(i-1, j, child, newSubString)
    dfs(i, j+1, child, newSubString)
    dfs(i, j-1, child, newSubString)

    // 还原
    board[i][j] = c
  }

  // 循环调用
  for i:=0;i<ROW;i++ {
    for j:=0;j<COL;j++ {
      dfs(i, j, rootNode, "")
    }
  }

  // 转成最终结果
  for k,v := range ansMap {
    if v {
      ans = append(ans, k)
    }
  }
  return ans
}


func buildTireTree(words []string) *Node {
  root := &Node{'_', []*Node{}, false}
  for _,w := range words {
    addIntoTree(root, w)
  }
  return root
}

func addIntoTree(root *Node, word string) {
  p := root
  for i:=0;i<len(word);i++ {
    child := getChild(p.nextNodes, word[i])
    if child == nil {
      child = &Node{word[i], []*Node{}, false}
      p.nextNodes = append(p.nextNodes, child)
    }
    p = child
  }
  p.isWord = true
}

func getChild(children []*Node, b byte) *Node {
  for _,n := range children {
    if b == n.value {
      return n
    }
  }
  return nil
}

type Node struct {
  value byte
  nextNodes []*Node
  isWord bool
}
//leetcode submit region end(Prohibit modification and deletion)

  }