package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import model.ListNode;

/**
 * [234] 回文链表
 */
public class PalindromeLinkedList {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
	 * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
	 * this.next = next; } }
	 */
	class Solution {

		public boolean isPalindrome(ListNode head) {
			List<ListNode> stack = new ArrayList<>();
			ListNode fast = head, slow = head;
			while (fast != null && fast.next != null) {
				stack.add(slow);
				fast = fast.next.next;
				slow = slow.next;
			}
			// 如果节点数为双数，中点不确定。 中点修正
			if (fast != null) {
				slow = slow.next;
			}
			while (slow != null) {
				ListNode topNode = stack.remove(stack.size() - 1);
				if (slow.val != topNode.val) {
					return false;
				}
				slow = slow.next;
			}

			return stack.isEmpty();
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}