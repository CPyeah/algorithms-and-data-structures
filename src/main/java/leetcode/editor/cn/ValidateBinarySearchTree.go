  package leetcode.editor.cn;
  
  /**
   * [98] 验证二叉搜索树
   */
  public class ValidateBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new ValidateBinarySearchTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isValidBST(root *TreeNode) bool {
  ans = true
  res = make([]int, 0)
  bfs(root)
  return ans
}

var res []int
var ans bool

func bfs(node *TreeNode) {
  if !ans || node == nil  {
    return
  }
  bfs(node.Left)
  if len(res) > 0 && node.Val <= res[len(res)-1] {
    ans = false
    return
  }
  res = append(res, node.Val)
  bfs(node.Right)
}
//leetcode submit region end(Prohibit modification and deletion)

  }