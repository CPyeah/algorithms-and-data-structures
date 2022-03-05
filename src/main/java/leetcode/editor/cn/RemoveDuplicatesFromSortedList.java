package leetcode.editor.cn;

import model.ListNode;

/**
 * [83] 删除排序链表中的重复元素
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
	 * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
	 * this.next = next; } }
	 */
	class Solution {

		public ListNode deleteDuplicates(ListNode head) {
			ListNode pointer = head;
			while(pointer != null && pointer.next != null) {
				if (pointer.val == pointer.next.val) {
					// delete next node
					pointer.next = pointer.next.next;
				} else {
					pointer = pointer.next;
				}
			}
			return head;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}