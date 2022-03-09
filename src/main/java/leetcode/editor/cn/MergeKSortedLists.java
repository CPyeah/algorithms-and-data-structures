package leetcode.editor.cn;

import model.ListNode;

/**
 * [23] 合并K个升序链表
 */
public class MergeKSortedLists {

	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
	 * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
	 * this.next = next; } }
	 */
	class Solution {

		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0) {
				return null;
			}
			return mergeKLists(lists, 0, lists.length - 1);
		}

		public ListNode mergeKLists(ListNode[] lists, int begin, int end) {
			if (begin == end) {
				return lists[begin];
			} else if (end - begin == 1) {
				return mergeTwoLists(lists[begin], lists[end]);
			} else {
				int mid = (begin + end) / 2;
				ListNode l1 = mergeKLists(lists, begin, mid);
				ListNode l2 = mergeKLists(lists, mid + 1, end);
				return mergeTwoLists(l1, l2);
			}
		}

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