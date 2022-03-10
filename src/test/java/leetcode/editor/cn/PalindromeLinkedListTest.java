package leetcode.editor.cn;

import com.google.common.collect.Lists;
import leetcode.editor.cn.PalindromeLinkedList.Solution;
import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;

public class PalindromeLinkedListTest {

	@Test
	public void test() {
		Solution solution = new PalindromeLinkedList().new Solution();
		ListNode listNode = LinkedListUtils
				.createSinglyLinkedList(Lists.newArrayList(0, 0));
		Assert.assertTrue(solution.isPalindrome(listNode));

	}

}