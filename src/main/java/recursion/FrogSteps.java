package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 青蛙上台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class FrogSteps {

	public static class Solution1 {

		public int count;

		public int frogSteps(int n) {
			count ++;
			if (n <= 0) {
				return 0;
			}
			if (n == 1) {
				return 1;
			}
			if (n == 2) {
				return 2;
			}
			return frogSteps(n-1) + frogSteps(n-2);
		}
	}

	public static class Solution2 {

		private final Map<Integer, Integer> cache = new HashMap<>();
		public int count;

		public int frogSteps(int n) {
			Integer result;
			if (( result = cache.get(n)) != null) {
				return result;
			}
			count ++;
			if (n <= 0) {
				result = 0;
			} else if (n == 1) {
				result = 1;
			} else if (n == 2) {
				result = 2;
			} else {
				result = frogSteps(n-1) + frogSteps(n-2);
			}
			cache.put(n, result);
			return result;
		}
	}

}
