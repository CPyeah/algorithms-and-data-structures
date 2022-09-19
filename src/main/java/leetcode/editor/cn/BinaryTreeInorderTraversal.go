  package leetcode.editor.cn;
  
  /**
   * [94] 二叉树的中序遍历
   */
  public class BinaryTreeInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
func inorderTraversal(root *TreeNode) []int {
  ans := make([]int, 0)
  var dfs func(root *TreeNode)
  dfs = func(root *TreeNode) {
    if root == nil {
      return
    }
    dfs(root.Left)
    ans = append(ans, root.Val)
    dfs(root.Right)
  }
  dfs(root)
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }