package basic_concepts;

import model.ListNode;

public class JudgeLinkedListIsCircular {

	/**
	 * 快慢指针
	 * @param head 链表头
	 * @return result
	 */
	public boolean solution1(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (true) {
			if (slow.next != null) {
				slow = slow.next;
			} else {
				return false;
			}
			if (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
			} else {
				return false;
			}
			if (fast == slow) {
				return true;
			}
		}
	}

}
