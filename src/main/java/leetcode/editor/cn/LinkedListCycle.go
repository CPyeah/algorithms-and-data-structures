  package leetcode.editor.cn;
  
  /**
   * [141] 环形链表
   */
  public class LinkedListCycle{
      public static void main(String[] args) {
           Solution solution = new LinkedListCycle().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {
    fast := head
    slow := head
    for fast != nil && fast.Next != nil{
      slow = slow.Next
      fast = fast.Next.Next
      if slow == fast {
        return true
      }
    }
    return false
}
//leetcode submit region end(Prohibit modification and deletion)

  }