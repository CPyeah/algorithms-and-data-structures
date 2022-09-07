  package leetcode.editor.cn;
  
  /**
   * [617] 合并二叉树
   */

      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func mergeTrees(root1 *TreeNode, root2 *TreeNode) *TreeNode {
  if root1 == nil && root2 == nil {
      return nil
    }
    if root1 == nil {
      return root2
    }
    if root2 == nil  {
      return root1
    }
    newNode := &TreeNode{Val:(root1.Val + root2.Val)}
    newNode.Left = mergeTrees(root1.Left, root2.Left)
    newNode.Right = mergeTrees(root1.Right, root2.Right)
    return newNode

}

//leetcode submit region end(Prohibit modification and deletion)

  }