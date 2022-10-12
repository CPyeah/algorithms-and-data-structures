  package leetcode.editor.cn;
  
  /**
   * [108] 将有序数组转换为二叉搜索树
   */
  public class ConvertSortedArrayToBinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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
func sortedArrayToBST(nums []int) *TreeNode {
  return toTree(nums, 0, len(nums)-1)
}

func toTree(nums []int, left int, right int) *TreeNode {
  if left == right {
    return &TreeNode{Val:nums[left]}
  }
  if right - left == 1 {
    l := &TreeNode{Val:nums[left]}
    r := &TreeNode{Val:nums[right]}
    r.Left = l
    return r
  }
  mid := (left + right) / 2
  m := &TreeNode{Val:nums[mid]}
  m.Left = toTree(nums, left, mid-1)
  m.Right = toTree(nums, mid+1, right)
  return m
}
//leetcode submit region end(Prohibit modification and deletion)

  }