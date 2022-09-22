  package leetcode.editor.cn;
  
  /**
   * [148] 排序链表
   */
  public class SortList{
      public static void main(String[] args) {
           Solution solution = new SortList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func sortList(head *ListNode) *ListNode {
  if head == nil || head.Next == nil {
    return head
  }
  fast := head
  slow := head
  // 这里注意 因为中点取点是slow.Next
  // 这里需要 && fast.Next.Next != nil
  for fast != nil && fast.Next != nil && fast.Next.Next != nil {
    fast = fast.Next.Next
    slow = slow.Next
  }
  right := sortList(slow.Next)
  slow.Next = nil
  left := sortList(head)

  return merge2LinkedList(left, right)
}

func merge2LinkedList(left *ListNode, right *ListNode) *ListNode {
  dummy := &ListNode{}
  p := dummy
  for left != nil && right != nil {
    if left.Val < right.Val {
      p.Next = left
      left = left.Next
    } else {
      p.Next = right
      right = right.Next
    }
    p = p.Next
  }
  if left != nil {
    p.Next = left
  }
  if right != nil {
    p.Next = right
  }

  return dummy.Next
}
//leetcode submit region end(Prohibit modification and deletion)

  }