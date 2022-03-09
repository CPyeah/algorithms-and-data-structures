package leetcode.editor.cn;

import com.google.common.collect.Lists;
import leetcode.editor.cn.MergeTwoSortedLists.Solution;
import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;

public class MergeTwoSortedListsTest {

	@Test
	public void test() {
		Solution solution = new MergeTwoSortedLists().new Solution();
		ListNode l1 = LinkedListUtils.createSinglyLinkedList(Lists.newArrayList(1, 3, 5, 7, 9));
		ListNode l2 = LinkedListUtils.createSinglyLinkedList(Lists.newArrayList(2, 4, 6, 8, 10));
		ListNode listNode = solution.mergeTwoLists(l1, l2);
		Assert.assertEquals("12345678910", LinkedListUtils.toString(listNode));
	}

}