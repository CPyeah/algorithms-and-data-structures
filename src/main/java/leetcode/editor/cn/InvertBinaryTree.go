  package leetcode.editor.cn;
  
  /**
   * [226] 翻转二叉树
   */
  public class InvertBinaryTree{
      public static void main(String[] args) {
           Solution solution = new InvertBinaryTree().new Solution();
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
func invertTree(root *TreeNode) *TreeNode {
  invert(root)
  return root
}
func invert(root *TreeNode){
  if root == nil {
    return
  }
  invert(root.Left)
  invert(root.Right)
  root.Left, root.Right = root.Right, root.Left
}
//leetcode submit region end(Prohibit modification and deletion)

  }