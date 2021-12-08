package linked_list;

import model.ListNode;

/**
 * 合并两个链表
 */
public class Merge2List {

	// loop
	public static class Solution1 {

		ListNode merge2List(ListNode l1, ListNode l2) {
			ListNode dummy = new ListNode(0);
			ListNode pointer1 = l1;
			ListNode pointer2 = l2;
			ListNode curr = dummy;
			while (true) {
				if (pointer1 == null) {
					curr.next = pointer2;
					break;
				}
				if (pointer2 == null) {
					curr.next = pointer1;
					break;
				}
				if (pointer1.val < pointer2.val) {
					curr.next = pointer1;
					pointer1 = pointer1.next;
				} else {
					curr.next = pointer2;
					pointer2 = pointer2.next;
				}
				curr = curr.next;
			}

			return dummy.next;
		}

	}

	// 递归
	public static class Solution2 {

		ListNode merge2List(ListNode l1, ListNode l2) {
			ListNode dummy = new ListNode(0);
			ListNode pointer = dummy;
			merge2List(l1, l2, pointer);
			return dummy.next;
		}

		void merge2List(ListNode l1, ListNode l2, ListNode p) {
			if (l1 == null) {
				p.next = l2;
				return;
			} else if (l2 == null) {
				p.next = l1;
				return;
			}
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
			merge2List(l1, l2, p);
		}


	}

}
