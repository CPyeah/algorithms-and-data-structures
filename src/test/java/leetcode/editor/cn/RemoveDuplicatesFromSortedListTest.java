package leetcode.editor.cn;

import com.google.common.collect.Lists;
import leetcode.editor.cn.RemoveDuplicatesFromSortedList.Solution;
import model.ListNode;
import org.junit.Test;
import utils.LinkedListUtils;

public class RemoveDuplicatesFromSortedListTest {

	@Test
	public void test() {
		Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
		ListNode listNode = solution.deleteDuplicates(LinkedListUtils
				.createSinglyLinkedList(Lists.newArrayList(1, 1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 7)));
		LinkedListUtils.printList(listNode);
	}

}