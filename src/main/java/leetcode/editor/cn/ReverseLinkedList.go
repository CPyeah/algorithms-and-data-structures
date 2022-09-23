  package leetcode.editor.cn;
  
  /**
   * [206] 反转链表
   */
  public class ReverseLinkedList{
      public static void main(String[] args) {
           Solution solution = new ReverseLinkedList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
  if head == nil {
    return nil
  }
  var p1 *ListNode
  p2, p3 := head, head.Next
  for p3 != nil {
    p2.Next = p1
    p1, p2, p3 = p2, p3, p3.Next
  }
  p2.Next = p1
  return p2
}
//leetcode submit region end(Prohibit modification and deletion)

  }