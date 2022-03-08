package leetcode.editor.cn;

import model.ListNode;

/**
 * [92] 反转链表 II
 */
public class ReverseLinkedListIi {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
	 * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
	 * this.next = next; } }
	 */
	class Solution {

		//d   1  |  2   3   4  | 5
		//⬆  ⬆    ⬆

		//    1  |  2   3   4  | 5
		//    ⬆    ⬆  ⬆

		//    1  |  2   3   4 |  5
		//              ⬆  ⬆   ⬆
		public ListNode reverseBetween(ListNode head, int left, int right) {

			ListNode newHead = new ListNode(-1);
			newHead.next = head;
			ListNode leftNode = null, p1 = newHead, p2 = head, p3 = head.next;
			for (int i = 1; i <= right; i++) {
				if (i == left) {
					leftNode = p1;
					p2.next = null;
				} else if (i > left) {
					p2.next = p1;
				}
				p1 = p2;
				p2 = p3;
				if (p3 != null) {
					p3 = p3.next;
				}
			}
			//    1  |  2   3   4 |  5
			//                  ⬆   ⬆   ⬆
			leftNode.next.next = p2;
			leftNode.next = p1;
			return newHead.next;

		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}