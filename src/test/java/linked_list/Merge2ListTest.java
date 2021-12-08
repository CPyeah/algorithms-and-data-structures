package linked_list;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import model.ListNode;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.LinkedListUtils;

public class Merge2ListTest {

	private static Merge2List.Solution1 solution1;
	private static Merge2List.Solution2 solution2;
	private static ListNode l1;
	private static ListNode l2;

	@BeforeClass
	public static void setup() {
		solution1 = new Merge2List.Solution1();
		solution2 = new Merge2List.Solution2();
	}

	@Test
	public void test1() {
		l1 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 3, 5));
		l2 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 4, 6));
		assertEquals(LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 2, 3, 4, 5, 6)),
				solution1.merge2List(l1, l2));
	}

	@Test
	public void test2() {
		l1 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 3, 5));
		l2 = LinkedListUtils.createSinglyLinkedList(Arrays.asList(2, 4, 6));
		assertEquals(LinkedListUtils.createSinglyLinkedList(Arrays.asList(1, 2, 2, 3, 4, 5, 6)),
				solution2.merge2List(l1, l2));
	}

}