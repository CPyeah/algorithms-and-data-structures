  package leetcode.editor.cn;
  
  /**
   * [235] 二叉搜索树的最近公共祖先
   * 
   * 2 (1:Easy; 2:Medium; 3:Hard)
   */
  public class LowestCommonAncestorOfABinarySearchTree{
      public static void main(String[] args) {
           Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val   int
 *     Left  *TreeNode
 *     Right *TreeNode
 * }
 */

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
  if p.Val > q.Val {
    return lowestCommonAncestor(root, q, p)
  }
  queue := make([]*TreeNode, 0)
  queue = append(queue, root)
  for len(queue) > 0 {
    node := queue[0]
    queue = queue[1:]
    if node.Val >= p.Val && node.Val <= q.Val {
      return node
    }
    if node.Left != nil {
      queue = append(queue, node.Left)
    }
    if node.Right != nil {
      queue = append(queue, node.Right)
    }
  }
  return nil
}
//leetcode submit region end(Prohibit modification and deletion)

  }