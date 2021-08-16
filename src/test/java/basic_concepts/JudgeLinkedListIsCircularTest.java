package basic_concepts;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class JudgeLinkedListIsCircularTest {

	JudgeLinkedListIsCircular judgeLinkedListIsCircular = new JudgeLinkedListIsCircular();

	@Test
	public void solution1() {
		ListNode head1 = getLinkedList1();
		Assert.assertTrue(judgeLinkedListIsCircular.solution1(head1));
		ListNode head2 = getLinkedList2();
		Assert.assertFalse(judgeLinkedListIsCircular.solution1(head2));
	}

	@Test
	public void solution2() {
		ListNode head1 = getLinkedList1();
		Assert.assertTrue(judgeLinkedListIsCircular.solution2(head1));
		ListNode head2 = getLinkedList2();
		Assert.assertFalse(judgeLinkedListIsCircular.solution2(head2));
	}

	private ListNode getLinkedList1() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = node1;
		return node1;
	}

	private ListNode getLinkedList2() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		return node1;
	}
}