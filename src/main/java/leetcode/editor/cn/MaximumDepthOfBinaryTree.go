  package leetcode.editor.cn;
  
  /**
   * [104] 二叉树的最大深度
   */
  public class MaximumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
func maxDepth(root *TreeNode) int {
  ans := 0
  var dfs func(node *TreeNode, c int)
  dfs = func(node *TreeNode, c int) {
    if node == nil {
      return
    }
    if c > ans {
      ans = c
    }
    dfs(node.Left, c + 1)
    dfs(node.Right, c+1)
  }
  dfs(root, 1)
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }