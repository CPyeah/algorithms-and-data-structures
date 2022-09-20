  package leetcode.editor.cn;
  
  /**
   * [102] 二叉树的层序遍历
   */
  public class BinaryTreeLevelOrderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
func levelOrder(root *TreeNode) [][]int {
  ans := make([][]int, 0)
  if root == nil {
    return ans
  }
  queue := make([]*TreeNode, 0)
  queue = append(queue, root)
  for len(queue) > 0 {
    // fix the size
    currentLevelSize := len(queue)
    res := make([]int, currentLevelSize)
    for i:=0;i<currentLevelSize;i++ {
      res[i] = queue[i].Val
      // add sub nodes in queue
      if queue[i].Left != nil {
        queue = append(queue, queue[i].Left)
      }
      if queue[i].Right != nil {
        queue = append(queue, queue[i].Right)
      }
    }
    ans = append(ans, res)
    queue = queue[currentLevelSize:]
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }