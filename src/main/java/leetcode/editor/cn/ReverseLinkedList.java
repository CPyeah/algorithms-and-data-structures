package leetcode.editor.cn;

import model.ListNode;

/**
 * [206] 反转链表
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		Solution solution = new ReverseLinkedList().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
	 * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
	 * this.next = next; } }
	 */
	class Solution {

		//    1    2   3   4   5
		//⬆  ⬆   ⬆

		//    1    2   3   4   5
		//                 ⬆  ⬆   ⬆
		public ListNode reverseList(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}
			ListNode prev = null;
			ListNode curr = head;
			ListNode next = head.next;
			while (next != null) {
				curr.next = prev;
				prev = curr;
				curr = next;
				next = next.next;
			}
			curr.next = prev;
			return curr;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}