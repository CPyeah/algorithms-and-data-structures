  package leetcode.editor.cn;
  
  /**
   * [23] 合并K个升序链表
   */
  public class MergeKSortedLists{
      public static void main(String[] args) {
           Solution solution = new MergeKSortedLists().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeKLists(lists []*ListNode) *ListNode {
  dummy := &ListNode{}
  p := dummy
  for {
    nextNode := getNextNode(lists)
    if nextNode == nil {
      break
    }
    p.Next = nextNode
    p = p.Next
  }
  return dummy.Next
}

func getNextNode(lists []*ListNode) *ListNode {
  minVal := 10001
  var ret *ListNode = nil
  index := -1
  for i:=0;i<len(lists);i++ {
    if lists[i] != nil && lists[i].Val < minVal{
      minVal = lists[i].Val
      ret = lists[i]
      index = i
    }
  }
  if index > -1 {
    lists[index] = lists[index].Next
  }
  return ret
}
//leetcode submit region end(Prohibit modification and deletion)

  }