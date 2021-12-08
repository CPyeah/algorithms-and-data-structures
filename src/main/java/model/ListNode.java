package model;

import java.util.Objects;

/**
 * Normally, both val and next should be private attributes and generate getter and setter for them,
 * but for the convenience of leetcode solutions, I set them as public.
 */
public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int i) {
		this.val = i;
	}

	public int val() {
		return val;
	}


	@Override
	public String toString() {
		return "ListNode{" + "val=" + val + ", next=" + next + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ListNode)) {
			return false;
		}

		ListNode listNode = (ListNode) o;

		if (val != listNode.val) {
			return false;
		}
		return Objects.equals(next, listNode.next);
	}

	@Override
	public int hashCode() {
		int result = val;
		result = 31 * result + (next != null ? next.hashCode() : 0);
		return result;
	}

}
