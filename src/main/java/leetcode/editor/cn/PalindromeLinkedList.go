  package leetcode.editor.cn;
  
  /**
   * [234] 回文链表
   */
  public class PalindromeLinkedList{
      public static void main(String[] args) {
           Solution solution = new PalindromeLinkedList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func isPalindrome(head *ListNode) bool {
  // 1、快慢指针，找到中点
  fast, slow := head, head
  for fast != nil && fast.Next != nil {
    fast = fast.Next.Next
    slow = slow.Next
  }
  // 2、反转后半部分链表
  tail := reverse(slow)

  // 3、比较两个链表的值
  for head != nil && tail != nil {
    if head.Val != tail.Val {
      return false
    }
    head = head.Next
    tail = tail.Next
  }
  return true
}

func reverse(node *ListNode) *ListNode {
  if node == nil || node.Next == nil {
    return node
  }
  var p1 *ListNode
  p2, p3 := node, node.Next
  for p3 != nil {
    p2.Next = p1
    p1, p2, p3 = p2, p3, p3.Next
  }
  p2.Next = p1
  return p2
}
//leetcode submit region end(Prohibit modification and deletion)

  }