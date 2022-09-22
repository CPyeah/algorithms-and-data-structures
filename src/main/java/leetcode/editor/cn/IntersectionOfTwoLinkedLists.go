  package leetcode.editor.cn;
  
  /**
   * [160] 相交链表
   */
  public class IntersectionOfTwoLinkedLists{
      public static void main(String[] args) {
           Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    pA := headA
    pB := headB
    for pA != pB{
      if pA == nil {
        pA = headB
      } else {
        pA = pA.Next
      }
      if pB == nil {
        pB = headA
      } else {
        pB = pB.Next
      }
    }
    return pA
}
//leetcode submit region end(Prohibit modification and deletion)

  }