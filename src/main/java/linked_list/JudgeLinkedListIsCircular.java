package linked_list;

import java.util.HashSet;
import java.util.Set;
import model.ListNode;

/**
 * 判断链表是否成环
 */
public class JudgeLinkedListIsCircular {

	/**
	 * 快慢指针
	 * @param head 链表头
	 * @return result
	 */
	public boolean solution1(ListNode head) {
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		while (true) {
			if (fastPointer.next == null || fastPointer.next.next == null) {
				return false;
			}
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if (fastPointer.val() == slowPointer.val()) {
				return true;
			}
		}
	}

	// by hash
	public boolean solution2(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		ListNode index = head;
		while (index != null) {
			if (set.add(index)) {
				index = index.next;
			} else {
				return true;
			}
		}
		return false;
	}

}
