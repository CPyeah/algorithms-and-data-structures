  package leetcode.editor.cn;
  
  /**
   * [538] 把二叉搜索树转换为累加树
   */
  public class ConvertBstToGreaterTree{
      public static void main(String[] args) {
           Solution solution = new ConvertBstToGreaterTree().new Solution();
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
func convertBST(root *TreeNode) *TreeNode {
  currentSum = 0
  dfs(root)
  return root
}
// record the currentSum
var currentSum = 0

// right -> root -> left
func dfs(root *TreeNode) {
  if root == nil {
    return
  }
  dfs(root.Right)
  root.Val += currentSum
  currentSum = root.Val
  dfs(root.Left)

}
//leetcode submit region end(Prohibit modification and deletion)

  }