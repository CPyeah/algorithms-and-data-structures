  package leetcode.editor.cn;
  
  /**
   * [143] 重排链表
   * 
   * 2 (1:Easy; 2:Medium; 3:Hard)
   */
  public class ReorderList{
      public static void main(String[] args) {
           Solution solution = new ReorderList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reorderList(head *ListNode)  {
    array := make([]*ListNode, 0)
    p := head
    for p != nil {
        array = append(array, p)
        p = p.Next
    }
    dummy := &ListNode{}
    i, j := 0, len(array)-1
    p = dummy
    for i < j {
        p.Next = array[i]
        p = p.Next
        p.Next = array[j]
        p = p.Next
        i ++
        j --
    }
    if i == j {
        p.Next = array[i]
        p = p.Next
    }
    p.Next = nil
    head = dummy.Next
}
//leetcode submit region end(Prohibit modification and deletion)

  }