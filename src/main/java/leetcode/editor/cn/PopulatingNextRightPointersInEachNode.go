  package leetcode.editor.cn;
  
  /**
   * [116] 填充每个节点的下一个右侧节点指针
   */
  public class PopulatingNextRightPointersInEachNode{
      public static void main(String[] args) {
           Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

func connect(root *Node) *Node {
  var dfs func(root *Node)
	dfs = func(root *Node) {
	  if root == nil || root.Left == nil {
	    return
	  }
	  root.Left.Next = root.Right
	  if root.Next != nil { // if current is (2)
      root.Right.Next = root.Next.Left
	  }
	  dfs(root.Left)
	  dfs(root.Right)
	}
	dfs(root)
	return root
}
//leetcode submit region end(Prohibit modification and deletion)

  }