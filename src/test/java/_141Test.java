import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.Test;
import utils.LinkedListUtils;

public class _141Test {

	private static _141.Solution1 solution1;
	private static _141.Solution2 solution2;

	@BeforeClass
	public static void setup() {
		solution1 = new _141.Solution1();
		solution2 = new _141.Solution2();
	}

	@Test
	public void test1() {
		assertFalse(solution1.hasCycle(LinkedListUtils.contractLinkedList(new int[]{1, 2, 3, 4})));
	}

	@Test
	public void test2() {
		assertFalse(solution2.hasCycle(LinkedListUtils.contractLinkedList(new int[]{1, 2, 3, 4})));
	}
}
