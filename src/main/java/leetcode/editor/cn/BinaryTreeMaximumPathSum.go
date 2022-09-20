  package leetcode.editor.cn;
  
  /**
   * [124] 二叉树中的最大路径和
   */
  public class BinaryTreeMaximumPathSum{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeMaximumPathSum().new Solution();
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
func maxPathSum(root *TreeNode) int {
  maxSum := root.Val
  var dfs func(node *TreeNode) int
  dfs = func(node *TreeNode) int {
    if node == nil {
      return 0
    }
    rootVal := node.Val
    leftMax := dfs(node.Left)
    rightMax := dfs(node.Right)
    rootWithLeft := rootVal + leftMax
    rootWithRight := rootVal + rightMax
    rootWithBothSide := rootVal + leftMax + rightMax
    // 根、 左根、 右根 可以继续向上链接， 取最大值返回
    retVal := max(rootVal, rootWithLeft, rootWithRight)
    // 左根右   无法继续向上链接，判断当前最大值
    maxSum = max(maxSum, retVal, rootWithBothSide)
    return retVal
  }
  dfs(root)
  return maxSum
}
func max(nums ...int) int {
  m := nums[0]
  for i:=1;i<len(nums);i++ {
    if nums[i] > m {
      m = nums[i]
    }
  }
  return m
}
//leetcode submit region end(Prohibit modification and deletion)

  }