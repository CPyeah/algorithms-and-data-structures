package leetcode.editor.cn;

import model.ListNode;

/**
 * [19] 删除链表的倒数第 N 个结点
 */
public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
	 * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
	 * this.next = next; } }
	 */
	class Solution {

		public ListNode removeNthFromEnd(ListNode head, int n) {
			// 处理可能会被删掉的头节点
			ListNode dummy = new ListNode(-1);
			dummy.next = head;

			ListNode fast = dummy, slow = dummy;
			// 此时需要注意边界， 最终需要定位到删除节点的前一个节点
			for (int i = 0; i <= n; i++) {
				fast = fast.next;
			}
			while (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
			slow.next = slow.next.next;
			return dummy.next;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}