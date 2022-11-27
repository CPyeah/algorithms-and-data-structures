  package leetcode.editor.cn;
  
  /**
   * [237] 删除链表中的节点
   * 
   * 2 (1:Easy; 2:Medium; 3:Hard)
   */
  public class DeleteNodeInALinkedList{
      public static void main(String[] args) {
           Solution solution = new DeleteNodeInALinkedList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteNode(node *ListNode) {
    node.Val = node.Next.Val
   node.Next = node.Next.Next
}
//leetcode submit region end(Prohibit modification and deletion)

  }