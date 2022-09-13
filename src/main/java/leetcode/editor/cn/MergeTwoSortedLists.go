  package leetcode.editor.cn;
  
  /**
   * [21] 合并两个有序链表
   */
  public class MergeTwoSortedLists{
      public static void main(String[] args) {
           Solution solution = new MergeTwoSortedLists().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
  dummy := &ListNode{}
  p := dummy
  for list1 != nil && list2 != nil{
    if list1.Val < list2.Val {
      p.Next = list1
      list1 = list1.Next
    } else {
      p.Next = list2
      list2 = list2.Next
    }
    p = p.Next
  }
  if list1 != nil {
    p.Next = list1
  }
  if list2 != nil {
    p.Next = list2
  }

  return dummy.Next
}
//leetcode submit region end(Prohibit modification and deletion)

  }