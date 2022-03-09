  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;
  import model.ListNode;

  /**
   * [143] 重排链表
   */
  public class ReorderList{

      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> positive = new ArrayList<>();
        List<ListNode> negative = new ArrayList<>();
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            positive.add(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != null) {
            negative.add(slow);
            slow = slow.next;
        }
        System.out.println(negative.size());
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int i = 0; i < positive.size(); i++) {
            p.next = positive.get(i);
            p = p.next;
            p.next = negative.get(negative.size()-1-i);
            p = p.next;
            p.next = null;
        }
        if (negative.size() != positive.size()) {
            p.next = negative.get(0);
            p.next.next = null;
        }
        head = dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }