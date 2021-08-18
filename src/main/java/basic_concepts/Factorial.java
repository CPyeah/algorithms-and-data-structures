package basic_concepts;

/**
 * 阶乘
 */
public class Factorial {

	// by recursion
	public int solution1(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * solution1(n - 1);
		}
	}

	// by loop
	// 5! = 5 * 4 * 3 * 2 * 1
	public int solution2(int n) {
		int result = 1;
		for (int i = n; i > 0; i--) {
			result = result * i;
		}
		return result;
	}

}
