package leetcode.editor.cn;

import model.ListNode;

/**
 * [21] 合并两个有序链表
 */
public class MergeTwoSortedLists {
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
	 * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
	 * this.next = next; } }
	 */
	class Solution {

		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			ListNode dummy = new ListNode(-1);
			ListNode pointer = dummy;
			while (true) {
				if (list1 == null) {
					pointer.next = list2;
					break;
				}
				if (list2 == null) {
					pointer.next = list1;
					break;
				}
				if (list1.val > list2.val) {
					pointer.next = list2;
					list2 = list2.next;
				} else {
					pointer.next = list1;
					list1 = list1.next;
				}
				pointer = pointer.next;

			}
			return dummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}