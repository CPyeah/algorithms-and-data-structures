package leetcode.editor.cn;

import com.google.common.collect.Lists;
import leetcode.editor.cn.ReverseLinkedList.Solution;
import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;

public class ReverseLinkedListTest {

	@Test
	public void test() {
		Solution solution = new ReverseLinkedList().new Solution();
		ListNode testListNode = LinkedListUtils
				.createSinglyLinkedList(Lists.newArrayList(2, 3, 4, 7, 1));
		String expected = new StringBuilder(LinkedListUtils.toString(testListNode)).reverse()
				.toString();
		ListNode resultNodeList = solution.reverseList(testListNode);
		Assert.assertEquals(expected,
				LinkedListUtils.toString(resultNodeList));
	}

}