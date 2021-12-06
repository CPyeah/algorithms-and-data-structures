package recursion;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

	public int solution(int n) {
		return f(n);
	}

	int f(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			return f(n - 1) + f(n - 2);
		}
	}
}
