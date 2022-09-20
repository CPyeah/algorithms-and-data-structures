  package leetcode.editor.cn;
  
  /**
   * [114] 二叉树展开为链表
   */
  public class FlattenBinaryTreeToLinkedList{
      public static void main(String[] args) {
           Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
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
func flatten(root *TreeNode)  {
  if root == nil {
    return
  }
  if root.Left != nil {
    rightSub := root.Right
    // find rightest in leftSubTree
    rightest := root.Left
    for rightest.Right != nil {
      rightest = rightest.Right
    }
    // insert left into right
    root.Right = root.Left
    root.Left = nil
    rightest.Right = rightSub
  }
  flatten(root.Right)
}
//leetcode submit region end(Prohibit modification and deletion)

  }