  package leetcode.editor.cn;
  
  /**
   * [105] 从前序与中序遍历序列构造二叉树
   */
  public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
 // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
func buildTree(preorder []int, inorder []int) *TreeNode {
  if len(preorder) == 0 {
    return nil
  }
  rootVal := preorder[0] // 3
  rootNode := &TreeNode{Val:rootVal}
  var rootIndexInInorder int // 1
  for i:=0;i<len(inorder);i++ {
    if inorder[i] == rootVal {
      rootIndexInInorder = i
      break
    }
  }
  // [9] , [9]
  rootNode.Left = buildTree(preorder[1:rootIndexInInorder+1], inorder[:rootIndexInInorder])
  // [20, 15, 7], [15, 20, 7]
  rootNode.Right = buildTree(preorder[rootIndexInInorder+1:], inorder[rootIndexInInorder+1:])

  return rootNode
}
//leetcode submit region end(Prohibit modification and deletion)

  }