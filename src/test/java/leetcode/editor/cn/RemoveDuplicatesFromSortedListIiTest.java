package leetcode.editor.cn;

import com.google.common.collect.Lists;
import leetcode.editor.cn.RemoveDuplicatesFromSortedListIi.Solution;
import model.ListNode;
import org.junit.Test;
import utils.LinkedListUtils;

public class RemoveDuplicatesFromSortedListIiTest {

	@Test
	public void test() {
		Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
		ListNode listNode = solution.deleteDuplicates(
				LinkedListUtils.createSinglyLinkedList(Lists.newArrayList(1, 1, 2, 3, 3, 4, 5, 5)));
		LinkedListUtils.printList(listNode);
	}

}