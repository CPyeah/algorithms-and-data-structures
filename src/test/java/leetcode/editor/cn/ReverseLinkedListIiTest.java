package leetcode.editor.cn;

import com.google.common.collect.Lists;
import leetcode.editor.cn.ReverseLinkedListIi.Solution;
import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;

public class ReverseLinkedListIiTest {

	@Test
	public void test() {
		Solution solution = new ReverseLinkedListIi().new Solution();

		ListNode singlyLinkedList = LinkedListUtils
				.createSinglyLinkedList(Lists.newArrayList( 3, 5));
		ListNode listNode = solution.reverseBetween(singlyLinkedList, 1, 2);
		Assert.assertEquals("53", LinkedListUtils.toString(listNode));

		singlyLinkedList = LinkedListUtils
				.createSinglyLinkedList(Lists.newArrayList(1, 2, 3, 4, 5));
		listNode = solution.reverseBetween(singlyLinkedList, 2, 4);
		Assert.assertEquals("14325", LinkedListUtils.toString(listNode));
	}

}