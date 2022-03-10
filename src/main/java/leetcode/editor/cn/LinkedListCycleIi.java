package leetcode.editor.cn;

import model.ListNode;

/**
 * [142] 环形链表 II
 */
public class LinkedListCycleIi {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) {
	 * val = x; next = null; } }
	 */
	public class Solution {

		public ListNode detectCycle(ListNode head) {
			ListNode fast = head, slow = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					// 此时 两指针相遇 成环
					// fast走的路程是slow的两倍    f = 2 * s      -> f = s  + s
					// fast走的路程比慢指针多N圈    f - s = n * B  -> f = nB + s
					// 可以推导出 慢指针走了N个环                      s = nB
					// 所以，慢指针再走个 头的距离，就可以走到连接点， 可以使用双指针实现
					ListNode pointer = head;
					while (pointer != slow) {
						pointer = pointer.next;
						slow = slow.next;
					}
					return slow;
				}
			}
			return null;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}