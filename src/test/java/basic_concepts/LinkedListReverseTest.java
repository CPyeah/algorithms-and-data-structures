package basic_concepts;

import static org.junit.Assert.*;

import model.ListNode;
import org.junit.Test;

public class LinkedListReverseTest {

	LinkedListReverse linkedListReverse = new LinkedListReverse();

	@Test
	public void solution() {
		ListNode listNode1 = getListNode1();
		System.out.println(listNode1);
		ListNode newList = linkedListReverse.solution(listNode1);
		System.out.println(newList);
	}

	@Test
	public void solution1() {
		ListNode listNode1 = getListNode1();
		System.out.println(listNode1);
		ListNode newList = linkedListReverse.solution1(listNode1);
		System.out.println(newList);
	}

	private ListNode getListNode1() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		return node1;
	}
}