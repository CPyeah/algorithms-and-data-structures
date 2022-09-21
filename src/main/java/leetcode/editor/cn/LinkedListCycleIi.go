  package leetcode.editor.cn;
  
  /**
   * [142] 环形链表 II
   */
  public class LinkedListCycleIi{
      public static void main(String[] args) {
           Solution solution = new LinkedListCycleIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func detectCycle(head *ListNode) *ListNode {
    fast := head
    slow := head
    for fast != nil && fast.Next != nil {
      fast = fast.Next.Next
      slow = slow.Next
      if slow == fast {
        fast = head
        for slow != fast {
          slow = slow.Next
          fast = fast.Next
        }
        return slow
      }
    }
    return nil
}
//leetcode submit region end(Prohibit modification and deletion)

  }