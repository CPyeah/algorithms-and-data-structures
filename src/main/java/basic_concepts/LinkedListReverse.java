package basic_concepts;

import model.ListNode;

public class LinkedListReverse {

	public ListNode solution(ListNode head) {
		ListNode left = head;
		ListNode mid = head.next;
		ListNode right = head.next.next;
		head.next = null;
		while (true) {
			mid.next = left;
			left = mid;
			mid = right;
			right = right.next;
			if (right == null) {
				mid.next = left;
				break;
			}
		}
		return mid;
	}

}