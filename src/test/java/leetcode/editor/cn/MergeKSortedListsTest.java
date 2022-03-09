package leetcode.editor.cn;

import com.google.common.collect.Lists;
import leetcode.editor.cn.MergeKSortedLists.Solution;
import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;

public class MergeKSortedListsTest {

	@Test
	public void test() {
		Solution solution = new MergeKSortedLists().new Solution();

		ListNode l1 = LinkedListUtils.createSinglyLinkedList(Lists.newArrayList(1, 4, 7));
		ListNode l2 = LinkedListUtils.createSinglyLinkedList(Lists.newArrayList(2, 5, 8));
		ListNode l3 = LinkedListUtils.createSinglyLinkedList(Lists.newArrayList(3, 6, 9));

		ListNode listNode = solution.mergeKLists(new ListNode[]{l1, l2, l3});
		Assert.assertEquals("123456789", LinkedListUtils.toString(listNode));

	}

}