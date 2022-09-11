  package leetcode.editor.cn;
  
  /**
   * [2] 两数相加
   */
  public class AddTwoNumbers{
      public static void main(String[] args) {
           Solution solution = new AddTwoNumbers().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
  if l1 == nil {
    return l2
  }
  if l2 == nil {
    return l1
  }
  // 进 1 标记
  addOne := false
  p1 := l1
  p2 := l2
  dummy := &ListNode{}
  r := dummy
  // 两个指针都位null，循环才结束
  for p1 != nil || p2 != nil {
    // 计算，并控制进位
    sum := getValue(p1) + getValue(p2)
    if addOne {
      sum ++
    }
    if sum >= 10 {
      sum -= 10
      addOne = true
    } else {
      addOne = false
    }
    r.Next = &ListNode{Val:sum}
    p1 = getNext(p1)
    p2 = getNext(p2)
    r = r.Next
  }
  // 如果最后还有进位，还要加一个 1
  if addOne {
   r.Next = &ListNode{Val:1}
  }
  return dummy.Next
}

func getValue(node *ListNode) int {
  if node == nil {
    return 0
  }
  return node.Val
}

func getNext(node *ListNode) *ListNode {
  if node == nil {
    return nil
  }
  return node.Next
}
//leetcode submit region end(Prohibit modification and deletion)

  }