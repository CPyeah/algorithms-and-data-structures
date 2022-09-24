  package leetcode.editor.cn;
  
  /**
   * [236] 二叉树的最近公共祖先
   */
  public class LowestCommonAncestorOfABinaryTree{
      public static void main(String[] args) {
           Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
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
 func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
  return dfs(root, p, q)
}

func dfs(root, p, q *TreeNode) *TreeNode {
  if root == nil {
    return nil
  }
  if root == p || root == q {
    return root
  }
  left := dfs(root.Left, p, q)
  right := dfs(root.Right, p, q)
  if left != nil && right != nil {
    return root
  }
  if left != nil {
    return left
  }
  if right != nil {
    return right
  }
  return nil
}
//leetcode submit region end(Prohibit modification and deletion)

  }