package leetcode.editor.cn;

import model.ListNode;

/**
 * [141] 环形链表
 */
public class LinkedListCycle {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) {
	 * val = x; next = null; } }
	 */
	public class Solution {

		public boolean hasCycle(ListNode head) {
			ListNode fast = head, slow = head;
			while (true) {
				if (fast == null || fast.next == null) {
					return false;
				}
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					return true;
				}

			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}