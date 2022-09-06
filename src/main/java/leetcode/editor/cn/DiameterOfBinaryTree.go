  package leetcode.editor.cn;
  
  /**
   * [543] 二叉树的直径
   */
  public class DiameterOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new DiameterOfBinaryTree().new Solution();
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
func diameterOfBinaryTree(root *TreeNode) int {
  maxDiameter := 0

  var dfs func(node *TreeNode) int
  dfs = func(node *TreeNode) int {
    if node == nil {
      return -1
    }
    l := dfs(node.Left)
    r := dfs(node.Right)
    d := l + r + 2
    maxDiameter = max(maxDiameter, d)
    return max(l, r) + 1
  }
  dfs(root)
  return maxDiameter
}

func max(a int, b int) int{
  if a > b {
    return a
  }
  return b
}


//leetcode submit region end(Prohibit modification and deletion)

  }