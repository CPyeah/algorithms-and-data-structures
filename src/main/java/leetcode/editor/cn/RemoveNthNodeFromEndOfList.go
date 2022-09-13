  package leetcode.editor.cn;
  
  /**
   * [19] 删除链表的倒数第 N 个结点
   */
  public class RemoveNthNodeFromEndOfList{
      public static void main(String[] args) {
           Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
  dummy := &ListNode{}
  dummy.Next = head
  fast := dummy
  slow := dummy
  // fast run n step
  for i:=0;i<n;i++ {
    fast = fast.Next
  }
  // fast and slow run together to the end
  for fast.Next != nil {
    fast = fast.Next
    slow = slow.Next
  }
  // remove slow 's next node
  slow.Next = slow.Next.Next
  return dummy.Next
}
//leetcode submit region end(Prohibit modification and deletion)

  }