package leetcode.editor.cn;

import com.google.common.collect.Lists;
import java.util.List;
import leetcode.editor.cn.BinaryTreeLevelOrderTraversal.Solution;
import model.TreeNode;
import org.junit.Test;
import utils.TreeUtils;

public class BinaryTreeLevelOrderTraversalTest {

	@Test
	public void test() {
		Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
		TreeNode root = TreeUtils
				.constructBinaryTree(Lists.newArrayList(1, 2, 3, 4, null, null, 5));
		List<List<Integer>> lists = solution.levelOrder(root);

	}

}