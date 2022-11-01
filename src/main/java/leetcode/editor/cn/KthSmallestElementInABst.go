  package leetcode.editor.cn;
  
  /**
   * [230] 二叉搜索树中第K小的元素
   */
  public class KthSmallestElementInABst{
      public static void main(String[] args) {
           Solution solution = new KthSmallestElementInABst().new Solution();
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
func kthSmallest(root *TreeNode, k int) int {
  res := -1
  var dfs func(node *TreeNode)
  dfs = func(node *TreeNode) {
    if node == nil {
      return
    }
    dfs(node.Left)
    // this node
    if k == 1 && res == -1{
       res = node.Val
       return
    } else {
      k--
    }
    dfs(node.Right)
  }
  dfs(root)
  return res
}
//leetcode submit region end(Prohibit modification and deletion)

  }