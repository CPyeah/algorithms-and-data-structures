package greedy;

import greedy.EraseOverlapIntervals.Solution1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.CommonUtils;

public class EraseOverlapIntervalsTest {

	EraseOverlapIntervals.Solution1 solution1;

	@Before
	public void setUp() throws Exception {
		solution1 = new Solution1();
	}

	@Test
	public void test1() {
		int[][] intervals = CommonUtils.convertLeetCodeIrregularLengths2DArrayInputIntoJavaArray(
				"[1,2],[2,3],[3,4],[1,3]");
		Assert.assertEquals(1, solution1.eraseOverlapIntervals(intervals));

		intervals = CommonUtils.convertLeetCodeIrregularLengths2DArrayInputIntoJavaArray(
				"[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]");
		Assert.assertEquals(7, solution1.eraseOverlapIntervals(intervals));

		intervals = CommonUtils.convertLeetCodeIrregularLengths2DArrayInputIntoJavaArray(
				"[1,2],[1,2],[1,2]");
		Assert.assertEquals(2, solution1.eraseOverlapIntervals(intervals));

		intervals = CommonUtils.convertLeetCodeIrregularLengths2DArrayInputIntoJavaArray(
				"[1,2],[2,3]");
		Assert.assertEquals(0, solution1.eraseOverlapIntervals(intervals));
	}
}