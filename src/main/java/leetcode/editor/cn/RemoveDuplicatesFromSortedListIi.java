package leetcode.editor.cn;

import model.ListNode;

/**
 * [82] 删除排序链表中的重复元素 II
 */
public class RemoveDuplicatesFromSortedListIi {

	public static void main(String[] args) {
		Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
	 * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
	 * this.next = next; } }
	 */
	class Solution {

		public ListNode deleteDuplicates(ListNode head) {
			// 空节点 防止头被删除
			ListNode dummy = new ListNode(Integer.MIN_VALUE);
			dummy.next = head;
			// 两个指针
			ListNode pre = dummy;
			ListNode curr = head;
			boolean del = false;
			//  null 1	1	2	3	3	4	5	5
			while (curr != null) {
				if (curr.next != null && equalWithNext(curr)) {
					// 当前节点重复，等待删除
					del = true;
					curr = curr.next;
				} else {
					curr = curr.next;
					if (del) {
						// 删除
						pre.next = curr;
					} else {
						// next
						pre = pre.next;
					}
					del = false;
				}
			}
			return dummy.next;
		}

		private boolean equalWithNext(ListNode delPointer) {
			return delPointer.val == delPointer.next.val;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}