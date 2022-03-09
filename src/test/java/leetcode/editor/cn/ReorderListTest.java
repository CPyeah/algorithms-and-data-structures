package leetcode.editor.cn;

import com.google.common.collect.Lists;
import leetcode.editor.cn.ReorderList.Solution;
import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;

public class ReorderListTest {

	@Test
	public void test() {
		Solution solution = new ReorderList().new Solution();
		ListNode listNode = LinkedListUtils
				.createSinglyLinkedList(Lists.newArrayList(1, 2, 3, 4, 5));
		solution.reorderList(listNode);
		Assert.assertEquals("15243", LinkedListUtils.toString(listNode));
	}

}