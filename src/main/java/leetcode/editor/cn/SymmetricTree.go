  package leetcode.editor.cn;
  
  /**
   * [101] 对称二叉树
   */
  public class SymmetricTree{
      public static void main(String[] args) {
           Solution solution = new SymmetricTree().new Solution();
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
func isSymmetric(root *TreeNode) bool {
  return dfs(root.Left, root.Right)
}

// 已 2 为参考
func dfs(node1 *TreeNode, node2 *TreeNode) bool {
  if node1 == nil && node2 == nil {
    return true
  }
  if node1 == nil || node2 == nil {
    return false
  }
  if node1.Val != node2.Val {
    return false
  }
  return dfs(node1.Left, node2.Right) && dfs(node1.Right, node2.Left)
}
//leetcode submit region end(Prohibit modification and deletion)

  }